package com.sagarandcompany.weatherapp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceDownTime")
    public String getWeather() {
        return restTemplate.getForEntity("http://weather-service/weather", String.class).getBody();
    }

    public String serviceDownTime() {
        return "Service is down";
    }
}
