package org.tammy.weatherproject.Models;

public class WeatherForecast {

    private String description;
    private String title;
    private String iconUrl;

    public WeatherForecast(String description, String title, String iconUrl) {
        this.description = description;
        this.title = title;
        this.iconUrl = iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
