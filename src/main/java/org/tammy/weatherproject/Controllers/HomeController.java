package org.tammy.weatherproject.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tammy.weatherproject.Models.WeatherData;
import org.tammy.weatherproject.Models.Weather;
import org.tammy.weatherproject.Models.WeatherForecast;

import java.util.ArrayList;


@Controller
@RequestMapping("")

public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        String city = "Seattle";
        String state = "WA";

        String image = "http://api.wunderground.com/api/cb5d7b2fbd91dacc/animatedradar/q/"+ state + "/" + city + ".gif?newmaps=1";

        Weather theWeather = WeatherData.fetchWeatherData("http://api.wunderground.com/api/cb5d7b2fbd91dacc/conditions/q/"+state +"/"+ city +".json");

        ArrayList<WeatherForecast> forecasts = WeatherData.fetchWeatherForecast("http://api.wunderground.com/api/cb5d7b2fbd91dacc/forecast/q/"+ state +"/" + city + ".json");

        model.addAttribute("forecasts", forecasts);
        model.addAttribute("weather",theWeather);
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String index(Model model, @RequestParam String search){
        String state = WeatherData.findState(search);
        String city = WeatherData.findCity(search);

        String image = "http://api.wunderground.com/api/cb5d7b2fbd91dacc/animatedradar/q/"+ state + "/" + city + ".gif?newmaps=1";

        Weather theWeather = WeatherData.fetchWeatherData("http://api.wunderground.com/api/cb5d7b2fbd91dacc/conditions/q/"+state +"/"+ city +".json");

        ArrayList<WeatherForecast> forecasts = WeatherData.fetchWeatherForecast("http://api.wunderground.com/api/cb5d7b2fbd91dacc/forecast/q/"+ state +"/" + city + ".json");

        model.addAttribute("forecasts", forecasts);
        model.addAttribute("weather",theWeather);

        return "index";
    }

}
