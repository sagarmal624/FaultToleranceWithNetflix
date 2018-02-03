package com.sagarandcompany.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class WeatherServiceApplication {
    private String[] weathers = new String[]{"Sunny", "Cloudy", "Rainy", "windy"};

    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApplication.class, args);
    }

    @GetMapping("/weather")
    public String getWeather() {
        int index = ThreadLocalRandom.current().nextInt(0, 4);
        return weathers[index];
    }
}
