package brady.green.sprint1.storage;

import brady.green.sprint1.models.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerStorage {

    private static final Map<Integer, Passenger> PASSENGERS = new HashMap<>();

    public static void addPassenger(Passenger passenger) {
        PASSENGERS.put(passenger.id(), passenger);
    }

    public static Passenger getPassenger(int id) {
        return PASSENGERS.get(id);
    }

    public static void removePassenger(int id) {
        PASSENGERS.remove(id);
    }

    public static Map<Integer, Passenger> getPassengers() {
        return PASSENGERS;
    }
}
