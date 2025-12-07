package farbfetzen.spring_soap_guides_consumer;

import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class CountryConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        final var marshaller = new Jaxb2Marshaller();
        // This package must match the package configured in the pom.xml.
        marshaller.setContextPath("farbfetzen.spring_soap_guides_producer.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(final WebServiceTemplateBuilder builder, final Jaxb2Marshaller marshaller) {
        final WebServiceTemplate template = builder.setMarshaller(marshaller).setUnmarshaller(marshaller).build();
        final var client = new CountryClient();
        client.setWebServiceTemplate(template);
        client.setDefaultUri("http://localhost:8080/services");
        return client;
    }
}
