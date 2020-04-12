package ua.lviv.iot.spring.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring.business.ToyCarService;
import ua.lviv.iot.spring.rest.model.Toy;
import ua.lviv.iot.spring.rest.model.ToyCar;

@RequestMapping("/toyCars")
@RestController
public class ToyCarController {

    @Autowired
    ToyCarService toyCarService;

    @GetMapping
    public List<ToyCar> getToyCars() {
        return toyCarService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Toy getToyCar(@PathVariable("id") Integer toyCarId) {
        return toyCarService.find(toyCarId);
    }

    @PostMapping
    public Toy createToyCar(@RequestBody ToyCar toyCar) {
        return toyCarService.createToyCar(toyCar);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Toy> deleteToyCar(@PathVariable("id") Integer toyCarId) {
        return ResponseEntity.status(toyCarService.deleteToyCar(toyCarId)).build();

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Toy> updateToyCar(@PathVariable("id") Integer toyCarId,
            @RequestBody ToyCar toyCar) {
        return ResponseEntity.status(toyCarService.updateToyCar(toyCarId, toyCar)).build();
    }
}
