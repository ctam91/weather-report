package org.tammy.weatherproject.Models;

// This class encapsulates data for current weather conditions

public class Weather {

    private String temperature;
    private String location;
    private String observationTime;
    private String weatherDescription;
    private String iconURL;

    public Weather(String temperature, String location, String observationTime, String description, String iconURL) {
        this.temperature = temperature;
        this.location = location;
        this.observationTime = observationTime;
        this.weatherDescription = description;
        this.iconURL = iconURL;
    }


    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String mLocation) {
        this.location = mLocation;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getDescription() {
        return weatherDescription;
    }

    public void setDescription(String description) {
        this.weatherDescription = description;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
