package com.example.service;

import com.example.DTO.WeatherDTO;
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

    public WeatherDTO getWeatherByCityName(String cityName) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey + "&units=metric";

        WeatherResponse response;
        try {
            response = restTemplate.getForObject(apiUrl, WeatherResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("City not found or API error!");
        }

        // Extract required data and return a clean DTO
        return new WeatherDTO(
                response.getName(),
                response.getMain().getTemp(),
                response.getMain().getHumidity(),
                response.getWeather().get(0).getDescription() // Get first weather condition
        );
    }
}
