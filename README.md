# EXAMPLE OF MICROSERVICES

It's a simple example how the structure of microservices looks like in environment of production
governed by service discovery, client-side load-balancing and intelligent routing.

## MODULES

- eureka-service

It is a service registry including Netflix's Eureka.

> A service registry is a phone book for your microservices. Each service registers itself with the service registry and tells the registry where it lives (host, port, node name) and perhaps other service-specific metadata - things that other services can use to make informed decisions about it.

- cat-catalog-service

This service is a simple service behind the "gateway", contains the business logic, serves client with
data trough the edge-service. This service is one of the so-called platform services, containing business logic.

- edge-service

An edge service is a component which is exposed to the public internet.
It acts as a gateway to all other services, the so-called platform services. 

### What are microservices?

> The microservice style of architecture is not so much about building individual services so much as it is making the interactions between services reliable and failure-tolerant. 

### Service Discovery

Netflix has a Eureka-aware client-side load-balancing client called Ribbon that Spring Cloud integrates extensively.
Spring Cloud helps you manage that complexity with a service registry like Eureka, Ribbon, Hystrix.


## INSPIRATIONS

[Josh Long](https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka)

[Matt Raible](https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot)

[Edge service](https://medium.com/knerd/api-infrastructure-at-knewton-whats-in-an-edge-service-51a3777aeb41)