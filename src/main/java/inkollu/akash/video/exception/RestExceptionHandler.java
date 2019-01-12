package inkollu.akash.video.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import inkollu.akash.video.model.ErrorResponse;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	
	ErrorResponse errorResponse;

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<Object> exceptionHandler(Exception e) {
//		HashMap<String, Object> msg = new HashMap<>(2);
		errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(new Date().getTime());
		errorResponse.setStatus( e.getCause().toString() );
		errorResponse.setError(e.getLocalizedMessage());
		errorResponse.setException("something went wrong with this request.");
		errorResponse.setMessage(String.valueOf(HttpStatus.PRECONDITION_FAILED.value()));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/*
	 * private static MediaType getContentType(WebRequest request) throws
	 * NullPointerException, IllegalArgumentException { String accepts =
	 * request.getHeader(HttpHeaders.ACCEPT);
	 * 
	 * if(accepts==null) throw new NullPointerException();
	 * 
	 * // XML if(accepts.contains(MediaType.APPLICATION_XML_VALUE) ||
	 * accepts.contains(MediaType.TEXT_XML_VALUE) ||
	 * accepts.contains(MediaType.APPLICATION_XHTML_XML_VALUE)) return
	 * MediaType.APPLICATION_XML; // JSON else
	 * if(accepts.contains(MediaType.APPLICATION_JSON_VALUE)) return
	 * MediaType.APPLICATION_JSON_UTF8; // other else throw new
	 * IllegalArgumentException(); }
	 */
}