package brady.green.sprint1.routes;

import brady.green.sprint1.models.Route;
import brady.green.sprint1.storage.AirCraftStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RouteController {

    @GetMapping("/routes/{id}")
    public ResponseEntity<Route> get(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirCraftStorage.getRoute(id));
    }

    @GetMapping("/routes")
    public List<Route> get() {
        return AirCraftStorage.getRoutes();
    }

    @PostMapping("/routes")
    public Route add(@RequestBody Route.Body body) {
        Route route = new Route(AirCraftStorage.getNextRouteId(), body);
        AirCraftStorage.addRoute(route);
        return route;
    }

    @PutMapping("/routes/{id}")
    public ResponseEntity<Route> update(@PathVariable Integer id, @RequestBody Route.Body body) {
        Route route = AirCraftStorage.getRoute(id);
        if (route == null) return ResponseEntity.notFound().build();
        Route updated = new Route(id, body);
        AirCraftStorage.addRoute(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/routes/{id}")
    public ResponseEntity<Route> delete(@PathVariable Integer id) {
        return ResponseEntity.ofNullable(AirCraftStorage.deleteRoute(id));
    }

}
