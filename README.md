# Spring SOAP Guides

This project follows two official Spring guides to learn the basics of creating and consuming SOAP web services:

- [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service)
- [Consuming a SOAP web service](https://spring.io/guides/gs/consuming-web-service)

The repository contains two modules:

- [Producer](producer): A simple SOAP endpoint.
- [Consumer](consumer): A client application that calls the SOAP endpoint.

The code closely follows the guides, with small adjustments where necessary to integrate both sides into one project.

## How to run

1. Open two terminals, one for the producer and one for the consumer.
2. Compile and start the Producer: `mvn -pl producer spring-boot:run`
3. Wait for the Producer to be ready.
   You can open <http://localhost:8080/services/countries.wsdl> in a browser to check if the wsdl is available.
   This is necessary for the Consumer to generate the sources during its compilation.
4. Compile and start the Consumer: `mvn -pl consumer spring-boot:run`  
   It will send a request to the Producer as soon as it's ready, with Spain as the default country.
   You can request a different country as a command line argument:
   `mvn -pl consumer spring-boot:run -Dspring-boot.run.arguments="--country='United Kingdom'"`  
   The result will be logged to the console.

## Troubleshooting

### IntelliJ doesn't resolve the imports of the generated sources

1. Compile the Producer to generate the sources.
2. Right click on `producer/target/generated-sources/jaxb` in the file tree.
3. Select `Mark Directory as` > `Generated Sources Root`
4. Start the Producer.
5. Compile the Consumer.
6. Right click on `consumer/target/generated-sources/wsimport`.
7. Select `Mark Directory as` > `Generated Sources Root`

### Testing with Postman produces a 500 Internal Server Error

Postman automatically adds the header `Content-Type` with the value `application/xml`, but the server expects
`text/xml`.

1. Go to the Headers tab.
2. Uncheck the checkbox of the content-type header.
3. Add a new header key-value pair with `Content-Type` and `text/xml`.

## License

This project is licensed under the Apache License Version 2.0.
See [LICENSE.txt](LICENSE.txt) for more information.
