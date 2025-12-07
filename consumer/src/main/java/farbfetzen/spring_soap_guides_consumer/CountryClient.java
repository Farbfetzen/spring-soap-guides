package farbfetzen.spring_soap_guides_consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import farbfetzen.spring_soap_guides_producer.wsdl.GetCountryRequest;
import farbfetzen.spring_soap_guides_producer.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(final String country) {
        logger.info("Requesting location for \"{}\"", country);
        final var request = new GetCountryRequest();
        request.setName(country);
        return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/services/countries",
                request,
                new SoapActionCallback("https://spring.io/guides/gs-producing-web-service/GetCountryRequest")
        );
    }
}
