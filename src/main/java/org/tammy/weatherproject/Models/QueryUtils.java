package org.tammy.weatherproject.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tammy on 10/6/2017.
 */

public final class QueryUtils {

    /*
        Default Constructor
     */
    public QueryUtils() {
    }

    /**
    *Create a URL object from the given URL string
     */
    private static URL createUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * Convert InputStream into String
    */
    private static String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();

        if(inputStream !=null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while( line != null){
                output.append(line);
                line = reader.readLine();
            }
        } return output.toString();
    }

    /**
     * Establish a network connection. Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // if the url is null, return early
        if(url == null){
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else{
                System.out.println("Error response code" + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            System.out.println("Problem returning the JSON information");
        } finally {
            if(urlConnection != null ){
                urlConnection.disconnect();
            } if(inputStream != null){
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Parse JSON response
     * @param weatherJSON the JSON data
     * @return list of weather objects from JSON
     */
    private static Weather extractWeatherData(String weatherJSON){

        // If the JSON string is empty or null, then return early.
        if (weatherJSON == null) {
            return null;
        }

        try {
            JSONObject myObject = new JSONObject(weatherJSON);
            JSONObject currentObservation = new JSONObject(myObject.getString("current_observation"));
            JSONObject displayLocation = new JSONObject(currentObservation.getString("display_location"));

            String temp = currentObservation.getString("temperature_string");
            String location = displayLocation.getString("full");
            String observationTime = currentObservation.getString("observation_time");
            String weatherDescription = currentObservation.getString("weather");


            Weather result = new Weather(temp, location, observationTime, weatherDescription);
            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<WeatherForecast> extractWeatherForecast(String weatherJSON){

        // If the JSON string is empty or null, then return early.
        if (weatherJSON == null) {
            return null;
        }

        ArrayList<WeatherForecast> weatherForecast = new ArrayList<>();

        try {
            JSONObject weatherData = new JSONObject(weatherJSON);
            JSONObject forecast = weatherData.getJSONObject("forecast");
            JSONObject txtForecast = forecast.getJSONObject("txt_forecast");
            JSONArray forecastArray = txtForecast.getJSONArray("forecastday");

            for(int i = 0; i < forecastArray.length(); i += 2){
                JSONObject firstWeather = forecastArray.getJSONObject(i);

                String description = firstWeather.getString("fcttext");
                String day = firstWeather.getString("title");
                String iconUrl = firstWeather.getString("icon_url");
                // Add new Weather object to weathers arraylist

                weatherForecast.add(new WeatherForecast(description, day, iconUrl));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weatherForecast;
    }
        /*
        Retrieve Weather Data from API
     */

    public static Weather fetchWeatherData(String requestUrl){
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request
        String jsonResponse = null;
        try{
            jsonResponse = makeHttpRequest(url);
        } catch(IOException e){
            System.out.println("Problem making the HTTP request");
        }
        // Extract relevant field from JSON response and add it to an Earthquake List
        Weather weatherData = extractWeatherData(jsonResponse);
        return weatherData;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
   public static String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    public static String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    public static String formatTemp(Double tempC){
        Double fTemp = tempC * (9.0/5) + 32.0;
        DecimalFormat fTempFormatted = new DecimalFormat("0.0");
        return fTempFormatted.format(fTemp);
    }

//    public static int getWeatherIcon(String weatherType){
//        int iconResourceId;
//       switch (weatherType){
//           case "Clear":
//               iconResourceId = R.drawable.sun;
//                break;
//            case "Rain":
//                iconResourceId = R.drawable.rain;
//                break;
//           case "clouds":
//               iconResourceId = R.drawable.cloudy;
//                break;
//            default:
//                iconResourceId = R.drawable.umbrella;
//        }
//        return iconResourceId;
//    }

}
