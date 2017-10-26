package org.tammy.weatherproject.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tammy.weatherproject.Models.QueryUtils;
import org.tammy.weatherproject.Models.Weather;


@Controller
@RequestMapping("")

public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        String city = "Seattle";
        String state = "WA";

        String image = "http://api.wunderground.com/api/cb5d7b2fbd91dacc/animatedradar/q/" + state + "/" + city + ".gif?newmaps=1";
        Weather theWeather = QueryUtils.fetchWeatherData("http://api.wunderground.com/api/cb5d7b2fbd91dacc/conditions/q/" + state + "/" + city + ".json");

        model.addAttribute("imageURL", image);
        model.addAttribute(theWeather);
        return "jumbotron";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String index(Model model, @RequestParam String city) {
        String image = "http://api.wunderground.com/api/cb5d7b2fbd91dacc/animatedradar/q/" + "WA" + "/" + city + ".gif?newmaps=1";
        Weather theWeather = QueryUtils.fetchWeatherData("http://api.wunderground.com/api/cb5d7b2fbd91dacc/conditions/q/" + "WA" + "/" + city + ".json");

        model.addAttribute("imageURL", image);
        model.addAttribute(theWeather);
        return "jumbotron";
    }
}
