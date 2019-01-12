package inkollu.akash.video.config;

//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//@Configuration
//public class PropertiesConfiguration {
//	private static final Logger LOG = LoggerFactory.getLogger(PropertiesConfiguration.class);
//
//	@Bean
//	public PropertyPlaceholderConfigurer properties() {
//		final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
////		ppc.setIgnoreUnresolvablePlaceholders(true);
//		ppc.setIgnoreResourceNotFound(true);
//
//		final List<Resource> resourceLst = new ArrayList<Resource>();
//
//		resourceLst.add(new ClassPathResource("application.properties"));
//		resourceLst.add(new ClassPathResource("acutator.properties"));
//		resourceLst.add(new ClassPathResource("logger.properties")); // for Developer debugging.
//
//		ppc.setLocations(resourceLst.toArray(new Resource[] {}));
//
//		LOG.info("Using {} as user resource", ppc);
//
//		return ppc;
//	}
//
//}