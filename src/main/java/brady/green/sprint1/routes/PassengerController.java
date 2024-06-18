package brady.green.sprint1.routes;

import brady.green.sprint1.models.Passenger;
import brady.green.sprint1.models.Route;
import brady.green.sprint1.storage.AirCraftStorage;
import brady.green.sprint1.storage.PassengerStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PassengerController {

    @GetMapping("/passengers/{id}")
    public ResponseEntity<Passenger> get(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(PassengerStorage.getPassenger(id));
    }

    @GetMapping("/passengers")
    public List<Passenger> get() {
        return PassengerStorage.getPassengers();
    }

    @PostMapping("/passengers")
    public Passenger add(@RequestBody Passenger.Body body) {
        Passenger passenger = new Passenger(PassengerStorage.getNextPassengerId(), body);
        PassengerStorage.addPassenger(passenger);
        return passenger;
    }

    @PutMapping("/passengers/{id}")
    public ResponseEntity<Passenger> update(@PathVariable Integer id, @RequestBody Passenger.Body body) {
        Passenger passenger = PassengerStorage.getPassenger(id);
        if (passenger == null) return ResponseEntity.notFound().build();
        Passenger updated = new Passenger(id, body);
        PassengerStorage.addPassenger(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/passengers/{id}")
    public ResponseEntity<Passenger> delete(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(PassengerStorage.removePassenger(id));
    }

    @GetMapping("/passengers/{id}/routes")
    public ResponseEntity<List<Route>> flights(@PathVariable Integer id) {
        Passenger passenger = PassengerStorage.getPassenger(id);
        if (passenger == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(AirCraftStorage.getRoutesByPassenger(id));
    }

}
