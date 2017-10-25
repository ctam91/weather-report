package org.tammy.weatherproject.Models;

public class Weather {

    private String temperature;
    private String location;
    private String observationTime;
    private String weatherDescription;

    public Weather(String temperature, String location, String observationTime, String description) {
        this.temperature = temperature;
        this.location = location;
        this.observationTime = observationTime;
        this.weatherDescription = description;
    }


    public String getTemp() {
        return temperature;
    }

    public void setTemp(String temperature) {
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

    public void setDescription(String mDescription) {
        this.weatherDescription = mDescription;
    }


}
