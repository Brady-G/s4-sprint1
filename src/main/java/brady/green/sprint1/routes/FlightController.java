package brady.green.sprint1.routes;

import brady.green.sprint1.models.Flight;
import brady.green.sprint1.storage.AirCraftStorage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class FlightController {

    @GetMapping("/flights/{id}")
    public ResponseEntity<Set<Flight>> get(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirCraftStorage.getFlights(id));
    }

    @GetMapping("/flights")
    public Map<Integer, Set<Flight>> get() {
        return AirCraftStorage.getFlights();
    }

    @PostMapping("/flights")
    public ResponseEntity<Flight> add(@RequestBody Flight body) {
        if (!AirCraftStorage.addFlight(body)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @DeleteMapping("/flights")
    public ResponseEntity<Flight> delete(@RequestBody Flight body) {
        if (!AirCraftStorage.removeFlight(body)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
