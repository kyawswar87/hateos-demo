# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web.spring-hateoas)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)

This sample HATEOAS 

```
{
  "_embedded": {
    "customers": [
      {
        "customerId": "1",
        "customerName": "kyawswa",
        "companyName": "truemoney",
        "_links": {
          "self": {
            "href": "http://localhost:8080/customers/1"
          },
          "allOrders": {
            "href": "http://localhost:8080/customers/1/orders"
          }
        }
      },
      {
        "customerId": "2",
        "customerName": "kyawswa",
        "companyName": "cdsg",
        "_links": {
          "self": {
            "href": "http://localhost:8080/customers/2"
          },
          "allOrders": {
            "href": "http://localhost:8080/customers/2/orders"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/customers"
    }
  }
}
```

The client consume with Jsonpath way.

Find customer by customer id.

> JsonPath.parse(jsonSource).read("$._embedded.customers.[?(@.customerId == "+ customerId+")]");