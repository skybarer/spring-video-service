package inkollu.akash.video.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inkollu.akash.video.model.Employee;
import inkollu.akash.video.util.JsonUtils;

@RestController
public class SimpleRestController {

	private static final Logger logger = LoggerFactory.getLogger(SimpleRestController.class);

	@GetMapping("/info")
	public String example() {
		return JsonUtils.toString(new Date());
	}

	@GetMapping(value = "/content-test")
	public ResponseEntity<Employee> contentTets(@RequestParam String format) {

		logger.info("getPersonFormat - format: {}", format);
		HttpHeaders httpHeaders = new HttpHeaders();
		if (format.equals("json")) {
			logger.info("Ok JSON");
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		} else {
			logger.info("Ok XML");
			httpHeaders.setContentType(MediaType.APPLICATION_XML);
		}

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		return new ResponseEntity<>(emp, httpHeaders, HttpStatus.OK);
	}

	@GetMapping(value = "/content-test1")
	public ResponseEntity<Employee> contentTets1() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}