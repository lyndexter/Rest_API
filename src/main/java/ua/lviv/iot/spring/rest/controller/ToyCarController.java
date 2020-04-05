package ua.lviv.iot.spring.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RequestMapping("/toyCar")
@RestController
public class ToyCarController {

    private Map<Integer, Toy> toys = new HashMap<Integer, Toy>();

    @Autowired
    ToyCarService toyCarService;

    @GetMapping
    public List<ToyCar> getToyCars() {
        return toyCarService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Toy getToyCar(@PathVariable("id") Integer toyCarId) {
        return toys.get(toyCarId);
    }

    @PostMapping
    public Toy createToyCar(@RequestBody ToyCar toyCar) {
        return toyCarService.createToyCar(toyCar);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Toy> deleteToyCar(@PathVariable("id") Integer toyId) {
        HttpStatus status = toys.remove(toyId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Toy> updateToyCar(@PathVariable("id") Integer toyId,
            @RequestBody ToyCar toy) {
        toy.setId(toyId);
        HttpStatus status = toys.replace(toyId, toy) == null ? HttpStatus.NOT_FOUND
                : HttpStatus.CREATED;
        return ResponseEntity.status(status).build();

    }
}
