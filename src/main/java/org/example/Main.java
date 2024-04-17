package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FlightScheduler flightScheduler = objectMapper.readValue(new File("input.json"), FlightScheduler.class);
            System.out.println(flightScheduler.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}