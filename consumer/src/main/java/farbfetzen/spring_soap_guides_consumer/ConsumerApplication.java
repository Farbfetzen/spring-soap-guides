package farbfetzen.spring_soap_guides_consumer;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ConsumerApplication {

    static void main(final String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    ApplicationRunner lookup(final CountryClient countryClient) {
        return args -> {
            final List<String> countryOption = args.getOptionValues("country");
            final String country = (countryOption == null || countryOption.isEmpty()) ?
                    "Spain" :
                    countryOption.getFirst();
            final var response = countryClient.getCountry(country);
            logger.info("Country \"{}\" has currency \"{}\".", country, response.getCountry().getCurrency());
        };
    }
}
