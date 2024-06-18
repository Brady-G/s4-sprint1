package brady.green.sprint1.routes;

import brady.green.sprint1.models.City;
import brady.green.sprint1.storage.AirportStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CityController {

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> get(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirportStorage.getCity(id));
    }

    @GetMapping("/cities")
    public List<City> get() {
        return AirportStorage.getCities();
    }

    @PostMapping("/cities")
    public City add(@RequestBody City.Body body) {
        City city = new City(AirportStorage.getNextCityId(), body);
        AirportStorage.addCity(city);
        return city;
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> update(@PathVariable Integer id, @RequestBody City.Body body) {
        City city = AirportStorage.getCity(id);
        if (city == null) return ResponseEntity.notFound().build();
        City updated = new City(id, body);
        AirportStorage.addCity(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<City> delete(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirportStorage.removeCity(id));
    }

}
