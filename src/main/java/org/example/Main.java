package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    /**
     * Класс содержащий в себе расписание полетов и состояние всех рейсов
     */
    static FlightScheduler flightScheduler = null;

    /**
     * Точка входа в программу
     * @param args
     * @throws JsonProcessingException
     */
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            flightScheduler = objectMapper.readValue(new File("input.json"), FlightScheduler.class);
            System.out.println(flightScheduler.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}