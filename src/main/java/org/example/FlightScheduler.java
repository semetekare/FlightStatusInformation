package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;


/**
 * Класс FlightScheduler представляет расписание рейсов и прогноз погоды для различных городов.
 */
@JsonPropertyOrder({ "flights", "forecast" })
public class FlightScheduler {
    /**
     * Все рейсы
     */
    private List<Flight> flights;
    /**
     * Прогноз погоды для различных городов.
     */
    @JsonProperty("forecast")
    private Map<String, List<WeatherForecast>> forecast;

    /**
     * Пустой конструктор
     */
    FlightScheduler() {}

    /**
     * Возвращает строковое представление расписания рейсов с информацией о статусе каждого рейса.
     * @return Строковое представление расписания рейсов.
     */
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
