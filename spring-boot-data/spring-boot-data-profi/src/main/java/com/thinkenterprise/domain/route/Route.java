package com.thinkenterprise.domain.route;


import com.thinkenterprise.domain.core.AbstractDocument;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
public class Route extends AbstractDocument {

    private String flightNumber;
    private String departure;
    private String destination;

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    private Set<DayOfWeek> scheduledWeekdays = new HashSet<>();

    private List<Flight> flights = new ArrayList<>();

    @Transient
    private Double total;

    public Route() {
        super();
    }

    public Route(String flightNumber) {
        super();
        this.flightNumber = flightNumber;
    }

    public Route(String flightNumber, String departure, String destination) {
        super();
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String number) {
        this.flightNumber = number;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime time) {
        this.departureTime = time;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime time) {
        this.arrivalTime = time;
    }

    public Set<DayOfWeek> getScheduledWeekdays() {
        return scheduledWeekdays;
    }

    public void setScheduledWeekdays(Set<DayOfWeek> scheduledWeekday) {
        this.scheduledWeekdays = scheduledWeekday;
    }

    public void addScheduledWeekday(DayOfWeek scheduledWeekday) {
        this.scheduledWeekdays.add(scheduledWeekday);
    }

    public void addScheduledDaily() {
        this.scheduledWeekdays.add(DayOfWeek.MONDAY);
        this.scheduledWeekdays.add(DayOfWeek.TUESDAY);
        this.scheduledWeekdays.add(DayOfWeek.WEDNESDAY);
        this.scheduledWeekdays.add(DayOfWeek.THURSDAY);
        this.scheduledWeekdays.add(DayOfWeek.FRIDAY);
        this.scheduledWeekdays.add(DayOfWeek.SATURDAY);
        this.scheduledWeekdays.add(DayOfWeek.SUNDAY);
    }

}