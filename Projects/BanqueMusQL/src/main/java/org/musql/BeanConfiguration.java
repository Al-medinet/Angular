package org.musql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class BeanConfiguration {

	@Bean
	public SimpleJaxWsServiceExporter getJWS()
	{
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8888/Banque");
		return exporter;
	}
}
