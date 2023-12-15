package com.hateos.example;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final String HOME_URI = "http://localhost:8080/customers";
    private static final String REL_SEARCH = "allOrders";
    private static final String REL_PRODUCT = "http://localhost:8080/rels/product";


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.traverse("1");
        main.traverse("2");
    }

    private String getHalJson() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/customers";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        return response.getBody();
    }

    public void traverse(final String customerId) throws IOException {
        System.out.println("\n\n");
        System.out.println("---------- Example ----------");
        String jsonpathCustomerIdPath = "$._embedded.customers.customerName";
        String jsonpathCustomersPath = "$['_embedded']['customers'][*]";


        String jsonSource = getHalJson();
        DocumentContext jsonContext = JsonPath.parse(jsonSource);
        List<String> jsonpathCreatorLocation = jsonContext.read(jsonpathCustomersPath);
        System.out.println(jsonpathCreatorLocation);
        System.out.println("----------------------------------------");


        JSONArray expensive = JsonPath.parse(jsonSource)
//                .read("$['_embedded']['customers'][?(@['customerId'] == "+ customerId+")]");
                .read("$._embedded.customers.[?(@.customerId == "+ customerId+")]");
        System.out.println(expensive.get(0));
    }

}