package com.example.service;

import com.example.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openweathermap.api.key}")
    private String apiKey; // Fetch from application.properties

    public WeatherResponse getWeatherByCity(String cityName) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey + "&units=metric";
  try {
      WeatherResponse response = restTemplate.getForObject(apiUrl, WeatherResponse.class);
      return response;
  }catch(Exception e){
      throw new RuntimeException("Error fetching weather data OR City not found");
  }
    }
}
