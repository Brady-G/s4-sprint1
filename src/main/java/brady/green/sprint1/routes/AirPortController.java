package brady.green.sprint1.routes;

import brady.green.sprint1.models.Airport;
import brady.green.sprint1.storage.AirportStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AirPortController {

    @GetMapping("/airports/{id}")
    public ResponseEntity<Airport> get(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirportStorage.getAirport(id));
    }

    @GetMapping("/airports")
    public List<Airport> get() {
        return AirportStorage.getAirports();
    }

    @PostMapping("/airports")
    public Airport add(@RequestBody Airport.Body body) {
        Airport airport = new Airport(AirportStorage.getNextAirportId(), body);
        AirportStorage.addAirport(airport);
        return airport;
    }

    @PutMapping("/airports/{id}")
    public ResponseEntity<Airport> update(@PathVariable Integer id, @RequestBody Airport.Body body) {
        Airport airport = AirportStorage.getAirport(id);
        if (airport == null) return ResponseEntity.notFound().build();
        Airport updated = new Airport(id, body);
        AirportStorage.addAirport(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/airports/{id}")
    public ResponseEntity<Airport> delete(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirportStorage.getAirport(id));
    }

}
