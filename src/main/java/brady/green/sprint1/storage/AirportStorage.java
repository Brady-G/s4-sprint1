package brady.green.sprint1.storage;

import brady.green.sprint1.models.Airport;
import brady.green.sprint1.models.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportStorage {

    private static final Map<Integer, City> CITIES = new HashMap<>();
    private static final Map<Integer, Airport> AIRPORTS = new HashMap<>();

    private static int nextCityId = 1;
    private static int nextAirportId = 1;

    // Cities

    public static void addCity(City city) {
        CITIES.put(city.id(), city);
    }

    public static City removeCity(int id) {
        return CITIES.remove(id);
    }

    public static City getCity(int id) {
        return CITIES.get(id);
    }

    public static List<City> getCities() {
        return List.copyOf(CITIES.values());
    }

    public static int getNextCityId() {
        return nextCityId++;
    }

    // Airports

    public static void addAirport(Airport airport) {
        AIRPORTS.put(airport.id(), airport);
    }

    public static Airport getAirport(int id) {
        return AIRPORTS.get(id);
    }

    public static List<Airport> getAirports() {
        return List.copyOf(AIRPORTS.values());
    }

    public static int getNextAirportId() {
        return nextAirportId++;
    }

}
