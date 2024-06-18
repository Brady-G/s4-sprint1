package brady.green.sprint1.routes;

import brady.green.sprint1.models.AirCraft;
import brady.green.sprint1.storage.AirCraftStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AirCraftController {

    @GetMapping("/aircrafts/{id}")
    public ResponseEntity<AirCraft> get(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirCraftStorage.getAirCraft(id));
    }

    @GetMapping("/aircrafts")
    public List<AirCraft> get() {
        return AirCraftStorage.getAirCrafts();
    }

    @PostMapping("/aircrafts")
    public AirCraft add(@RequestBody AirCraft.Body body) {
        AirCraft airCraft = new AirCraft(AirCraftStorage.getNextAirCraftId(), body);
        AirCraftStorage.addAirCraft(airCraft);
        return airCraft;
    }

    @PutMapping("/aircrafts/{id}")
    public ResponseEntity<AirCraft> update(@PathVariable Integer id, @RequestBody AirCraft.Body body) {
        AirCraft airCraft = AirCraftStorage.getAirCraft(id);
        if (airCraft == null) return ResponseEntity.notFound().build();
        AirCraft updated = new AirCraft(id, body);
        AirCraftStorage.addAirCraft(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/aircrafts/{id}")
    public ResponseEntity<AirCraft> delete(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirCraftStorage.removeAirCraft(id));
    }

}
