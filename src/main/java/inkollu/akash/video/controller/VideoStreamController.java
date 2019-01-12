package inkollu.akash.video.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class VideoStreamController {
//	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${video.location}")
	private String videoLocation;

	@GetMapping("/videos/{name}/full")
	public ResponseEntity<UrlResource> getFullVideo(@PathVariable String name) {

		UrlResource video = null;
		try {
			video = new UrlResource("file:" + videoLocation + "/" + name);
		} catch (MalformedURLException e) {
//			logger.error(this.getClass().toString(), e.printStackTrace());

		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
				.contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.APPLICATION_OCTET_STREAM))
				.body(video);
	}

	@GetMapping("/videos/{name}")
	ResponseEntity<ResourceRegion> getVideo(@PathVariable String name, @RequestHeader HttpHeaders headers) {
		UrlResource video = null;
		try {
			video = new UrlResource("file:" + videoLocation + "/" + name);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ResourceRegion region = resourceRegion(video, headers);
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
				.contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.APPLICATION_OCTET_STREAM))
				.body(region);
	}

	private ResourceRegion resourceRegion(UrlResource video, HttpHeaders headers) {
		Long contentLength = null;
		try {
			contentLength = video.contentLength();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		HttpRange range = headers.getRange().get(0);

		if (headers.getRange().size() > 0) {
			HttpRange range = headers.getRange().get(0);
			long start = range.getRangeStart(contentLength);
			long end = range.getRangeEnd(contentLength);
			long rangeLength = Long.min(1 * 1024 * 1024, end - start + 1);
			return new ResourceRegion(video, start, rangeLength);
		} else {
			Long rangeLength = Long.min(1 * 1024 * 1024, contentLength);
			return new ResourceRegion(video, 0, rangeLength);
		}
	}

}
