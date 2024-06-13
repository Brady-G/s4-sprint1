package brady.green.sprint1.storage;

import brady.green.sprint1.models.Airport;
import brady.green.sprint1.models.City;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AirportStorage {

    private static final Map<Integer, City> CITIES = new HashMap<>();
    private static final Map<Integer, Airport> AIRPORTS = new HashMap<>();

    public static void addCity(City city) {
        CITIES.put(city.id(), city);
    }

    public static City getCity(int id) {
        return CITIES.get(id);
    }

    public static Collection<City> getCities() {
        return CITIES.values();
    }

    public static void addAirport(Airport airport) {
        AIRPORTS.put(airport.id(), airport);
    }

    public static Airport getAirport(int id) {
        return AIRPORTS.get(id);
    }

    public static Collection<Airport> getAirports() {
        return AIRPORTS.values();
    }

}
