package org.tammy.weatherproject.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tammy.weatherproject.Models.QueryUtils;
import org.tammy.weatherproject.Models.Weather;


@Controller
@RequestMapping("")

public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        Weather theWeather = QueryUtils.fetchWeatherData("http://api.wunderground.com/api/cb5d7b2fbd91dacc/conditions/q/CA/San_Francisco.json");
        String image = "http://api.wunderground.com/api/cb5d7b2fbd91dacc/animatedradar/q/CA/San_Francisco.gif?newmaps=1";
        model.addAttribute(theWeather);
        model.addAttribute("imageURL", image);
        return "jumbotron";
    }
}
