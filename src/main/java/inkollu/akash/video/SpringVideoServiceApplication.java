package inkollu.akash.video;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages="inkollu.akash")
@SpringBootApplication
public class SpringVideoServiceApplication {
	private static final Logger  LOGGER = LoggerFactory.getLogger(SpringVideoServiceApplication.class);

	public static void main(String[] args) {
		  LOGGER.debug("Spring Application Statted");
		SpringApplication.run(SpringVideoServiceApplication.class, args);
	}
}
