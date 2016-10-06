package com.thinkenterprise.repository.driver;

import com.thinkenterprise.domain.route.Route;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestRouteRepositoryDriver implements RouteRepositoryDriver {

    @Max(2L)
    @Value("${route.count}")
    private short routeCount;

    private List<Route> routeList = new ArrayList<>();
    private List<String> flightNumberList = new ArrayList<>();
    private List<String> departureList = new ArrayList<>();
    private List<String> destinationList = new ArrayList<>();

    public TestRouteRepositoryDriver() {
        flightNumberList.add("LH7902");
        flightNumberList.add("LH1602");

        departureList.add("MUC");
        departureList.add("FRA");

        destinationList.add("MUC");
        destinationList.add("FRA");
    }

    @PostConstruct
    public void initRoutesList() {
        for (short i = 0; i < routeCount; i++) {
            String flightNumber = flightNumberList.get(i);
            String departure = departureList.get(i);
            String destination = destinationList.get(i);

            Route route = new Route(flightNumber, departure, destination);
            route.addScheduledDaily();
            route.setDepartureTime(LocalTime.of(9 - i, 30));
            route.setArrivalTime(LocalTime.of(14 - i, 0));
            routeList.add(route);
        }
    }

    @Override
    public List<Route> getRouteList() {
        return routeList;
    }
}
