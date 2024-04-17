package org.example;

/**
 * Класс представляющий собой модель рейса
 */
public class Flight {
    /**
     * номер рейса
     */
    private String no;
    /**
     * время отправления по МЕСТНОМУ времени
     */
    private int departure;
    /**
     * город отправления
     */
    private String from;
    /**
     * город назначения
     */
    private String to;
    /**
     * время полета в часах
     */
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
