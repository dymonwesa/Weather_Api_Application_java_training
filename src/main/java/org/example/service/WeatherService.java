package org.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Properties;

public class WeatherService {

    private static final String URL_LINK = "http://api.weatherapi.com/v1/current.json";
    private String city;

    HttpClient client = HttpClient.newHttpClient();

    public WeatherService(String city) {
        this.city = city;
    }
//get
    public String getCity() {
        return city;
    }
//set
    public void setCity(String city) {
        this.city = city;
    }

    public void printWeather(String city) {
        Properties properties = new Properties();
        InputStream input = WeatherService.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String apiKey = properties.getProperty("api.key");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_LINK + "?key=" + apiKey + "&q=" + city + "&lang=ru"))
                .GET()
                .build();


        System.out.println();
    }

}
