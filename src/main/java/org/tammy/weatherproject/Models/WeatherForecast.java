package org.tammy.weatherproject.Models;

// This class encapsulates data for weather forecast conditions

public class WeatherForecast {

    private String description;
    private String day;
    private String iconUrl;


    public WeatherForecast(String description, String day, String iconUrl) {
        this.description = description;
        this.day = day;
        this.iconUrl = iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
