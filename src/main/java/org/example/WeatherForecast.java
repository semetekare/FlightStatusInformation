package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Прогноз погоды
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "wind",
        "visibility"
})
public class WeatherForecast {
    /**
     * МЕСТНОЕ время
     */
    @JsonProperty("time")
    private int time;
    /**
     * скорость ветра в м/с
     */
    @JsonProperty("wind")
    private int wind;
    /**
     * видимость в метрах
     */
    @JsonProperty("visibility")
    private int visibility;

    /**
     * Пустой конструктор
     */
    WeatherForecast() {  }

    /**
     * Конструктор с 3 параметрами
     * @param time
     * @param wind
     * @param visibility
     */
    WeatherForecast(int time, int wind, int visibility) {
        this.time = time;
        this.wind = wind;
        this.visibility = visibility;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Переопределенный toString()
     * @return
     */
    @Override
    public String toString(){
        return time + " | " + wind + " | " + visibility;
    }
}
