package org.tammy.weatherproject.Models;

public class Weather {

    private double temp;
    private String location;
    private Long timeInMilliseconds;
    private String description;
    private String weatherType;

    public Weather(double temp, String location, Long date, String description, String weatherType) {
        this.temp = temp;
        this.location = location;
        this.timeInMilliseconds = date;
        this.description = description;
        this.weatherType = weatherType;
    }


    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String mLocation) {
        this.location = mLocation;
    }

    public Long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    public void setTimeInMilliseconds(Long mTimeInMilliseconds) {
        this.timeInMilliseconds = mTimeInMilliseconds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String mDescription) {
        this.description = mDescription;
    }

    public String getWeatherType() {
        return weatherType;
    }
}
