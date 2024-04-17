package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Класс представляющий собой модель рейса
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
//    "flights",
        "no",
        "departure",
        "from",
        "to",
        "duration"
})
public class Flight {
    /**
     * номер рейса
     */
    @JsonProperty("no")
    private String no;
    /**
     * время отправления по МЕСТНОМУ времени
     */
    @JsonProperty("departure")
    private int departure;
    /**
     * город отправления
     */
    @JsonProperty("from")
    private String from;
    /**
     * город назначения
     */
    @JsonProperty("to")
    private String to;
    /**
     * время полета в часах
     */
    @JsonProperty("duration")
    private int duration;

    /**
     * Конструктор без ппараметров
     */
    Flight() {}

    /**
     * Конструктор с 5 параметрамми
     * @param no
     * @param departure
     * @param from
     * @param to
     * @param duration
     */
    Flight(String no, int departure, String from, String to, int duration) {
        this.no = no;
        this.departure = departure;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Переопределенный метод toString()
     * @return
     */
    @Override
    public String toString(){
        return no + " | " + from + " -> " + to + " | ";
    }
}
