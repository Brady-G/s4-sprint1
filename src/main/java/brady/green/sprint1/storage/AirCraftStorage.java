package brady.green.sprint1.storage;

import brady.green.sprint1.models.AirCraft;
import brady.green.sprint1.models.Flight;
import brady.green.sprint1.models.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirCraftStorage {

    private static final Map<Integer, AirCraft> AIRCRAFTS = new HashMap<>();
    private static final Map<Integer, List<Flight>> FLIGHTS = new HashMap<>();
    private static final Map<Integer, Route> ROUTES = new HashMap<>();

    public static void addAirCraft(AirCraft airCraft) {
        AIRCRAFTS.put(airCraft.id(), airCraft);
    }

    public static AirCraft getAirCraft(int id) {
        return AIRCRAFTS.get(id);
    }

    public static Map<Integer, AirCraft> getAirCrafts() {
        return AIRCRAFTS;
    }

    public static void addFlight(Flight flight) {
        FLIGHTS.computeIfAbsent(flight.aircraft(), k -> new ArrayList<>())
                .add(flight);
    }

    public static List<Flight> getFlights(int aircraft) {
        return FLIGHTS.getOrDefault(aircraft, new ArrayList<>());
    }

    public static Map<Integer, List<Flight>> getFlights() {
        return FLIGHTS;
    }

    public static void addRoute(Route route) {
        ROUTES.put(route.id(), route);
    }

    public static Route getRoute(int id) {
        return ROUTES.get(id);
    }

    public static Map<Integer, Route> getRoutes() {
        return ROUTES;
    }
}
