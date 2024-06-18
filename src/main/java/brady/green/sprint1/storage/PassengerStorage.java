package brady.green.sprint1.storage;

import brady.green.sprint1.models.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerStorage {

    private static final Map<Integer, Passenger> PASSENGERS = new HashMap<>();
    private static int nextPassengerId = 1;

    public static void addPassenger(Passenger passenger) {
        PASSENGERS.put(passenger.id(), passenger);
    }

    public static Passenger getPassenger(int id) {
        return PASSENGERS.get(id);
    }

    public static Passenger removePassenger(int id) {
        return PASSENGERS.remove(id);
    }

    public static List<Passenger> getPassengers() {
        return List.copyOf(PASSENGERS.values());
    }

    public static int getNextPassengerId() {
        return nextPassengerId++;
    }
}
