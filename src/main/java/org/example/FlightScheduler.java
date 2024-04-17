package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({ "flights", "forecast" })
public class FlightScheduler {
    private List<Flight> flights;
    @JsonProperty("forecast")
    private Map<String, List<WeatherForecast>> forecast;

    FlightScheduler() {}

    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Flight flight : flights) {
            List<WeatherForecast> cityForecasts = forecast.get(flight.getFrom());
            List<WeatherForecast> cityForecastsTo = forecast.get(flight.getTo());
            if (cityForecasts != null && cityForecastsTo != null) {
                int arrival = (flight.getDeparture() + flight.getDuration()) % 24;
                for (WeatherForecast weatherForecast : cityForecasts) {
                    for (WeatherForecast weatherForecastTo : cityForecastsTo) {
                        if (weatherForecast.getTime() == flight.getDeparture() && weatherForecastTo.getTime()
                                == arrival) {
                            if (weatherForecast.getWind() <= 30 && weatherForecast.getVisibility() >= 200 &&
                                    weatherForecastTo.getWind() <= 30 && weatherForecastTo.getVisibility() >= 200) {
                                res.append(flight.toString()).append("по расписанию").append("\n");
                            } else {
                                res.append(flight.toString()).append("отменен").append("\n");
                            }
                        }
                    }
                }
            } else {
                res.append("No weather forecast available for ").append(flight.getFrom()).append(" or ")
                        .append(flight.getTo()).append("\n");
            }
        }
        return res.toString();
    }

    public Map<String, List<WeatherForecast>> getWeathers() {
        return forecast;
    }

    public void setWeathers(Map<String, List<WeatherForecast>> weathers) {
        this.forecast = weathers;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
