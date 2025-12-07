package farbfetzen.spring_soap_guides_consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import farbfetzen.spring_soap_guides_producer.wsdl.GetCountryRequest;
import farbfetzen.spring_soap_guides_producer.wsdl.GetCountryResponse;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

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
