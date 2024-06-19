package brady.green.sprint1.storage;

import brady.green.sprint1.models.AirCraft;
import brady.green.sprint1.models.Flight;
import brady.green.sprint1.models.Route;

import java.util.*;

public class AirCraftStorage {

    private static final Map<Integer, AirCraft> AIRCRAFTS = new HashMap<>();
    private static final Map<Integer, Set<Flight>> FLIGHTS = new HashMap<>();
    private static final Map<Integer, Route> ROUTES = new HashMap<>();

    private static int nextAirCraftId = 1;
    private static int nextRouteId = 1;

    // AirCrafts

    public static void addAirCraft(AirCraft airCraft) {
        AIRCRAFTS.put(airCraft.id(), airCraft);
    }

    public static AirCraft removeAirCraft(int id) {
        return AIRCRAFTS.remove(id);
    }

    public static AirCraft getAirCraft(int id) {
        return AIRCRAFTS.get(id);
    }

    public static List<AirCraft> getAirCrafts() {
        return List.copyOf(AIRCRAFTS.values());
    }

    public static int getNextAirCraftId() {
        return nextAirCraftId++;
    }

    // Flights

    public static boolean addFlight(Flight flight) {
        return FLIGHTS.computeIfAbsent(flight.route(), k -> new HashSet<>())
                .add(flight);
    }

    public static boolean removeFlight(Flight flight) {
        var flights = FLIGHTS.get(flight.route());
        if (flights == null) return false;
        return flights.remove(flight);
    }

    public static Set<Flight> getFlights(int aircraft) {
        return FLIGHTS.get(aircraft);
    }

    public static Map<Integer, Set<Flight>> getFlights() {
        return FLIGHTS;
    }

    public static Set<Flight> getFlightsByPassenger(int passenger) {
        Set<Flight> flights = new HashSet<>();
        FLIGHTS.values().stream().flatMap(Set::stream)
                .filter(f -> f.passenger() == passenger)
                .forEach(flights::add);
        return flights;
    }

    // Routes

    public static void addRoute(Route route) {
        ROUTES.put(route.id(), route);
    }

    public static Route deleteRoute(int id) {
        return ROUTES.remove(id);
    }

    public static Route getRoute(int id) {
        return ROUTES.get(id);
    }

    public static List<Route> getRoutes() {
        return List.copyOf(ROUTES.values());
    }

    public static int getNextRouteId() {
        return nextRouteId++;
    }

    public static List<Route> getRoutesByPassenger(int passenger) {
        List<Route> routes = new ArrayList<>();
        getFlightsByPassenger(passenger).stream()
                .map(f -> ROUTES.get(f.route()))
                .filter(Objects::nonNull)
                .forEach(routes::add);
        return routes;
    }
}
