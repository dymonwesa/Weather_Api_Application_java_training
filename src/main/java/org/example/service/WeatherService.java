package org.example.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class WeatherService {

    private static final String API_LINK = " ";

    HttpClient client = HttpClient.newHttpClient();




    public void printWeather(String city) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_LINK + "/" + city))
                .GET()
                .build();


        System.out.println();
    }

}
