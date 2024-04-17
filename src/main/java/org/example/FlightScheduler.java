package org.example;

import java.util.List;

public class FlightScheduler {
    private List<Flight> flights;
    private List<WeatherForecast> weathers;

    FlightScheduler() {}
    FlightScheduler(String pathJSON) {

    }

    public List<WeatherForecast> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeatherForecast> weathers) {
        this.weathers = weathers;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
