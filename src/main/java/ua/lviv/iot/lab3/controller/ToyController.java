package ua.lviv.iot.lab3.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
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
import ua.lviv.iot.lab3.model.Toy;
import ua.lviv.iot.lab3.model.ToyCar;

@RequestMapping("/toy")
@RestController
public class ToyController {

    private Map<Integer, Toy> toys = new HashMap<Integer, Toy>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<Toy> getToys() {
        return new LinkedList<Toy>(toys.values());
    }

    @GetMapping(path = "/{id}")
    public Toy getToy(@PathVariable("id") Integer toyId) {
        System.out.println(toyId);
        return toys.get(toyId);
    }

    @PostMapping
    public Toy createToy(@RequestBody ToyCar toy) {
        toy.setId(idCounter.incrementAndGet());
        toys.put(toy.getId(), toy);
        return toy;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Toy> deleteToy(@PathVariable("id") Integer toyId) {
        HttpStatus status = toys.remove(toyId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Toy> updateToy(@PathVariable("id") Integer toyId,
            @RequestBody ToyCar toy) {
        toy.setId(toyId);
        HttpStatus status = toys.replace(toyId, toy) == null ? HttpStatus.NOT_FOUND
                : HttpStatus.CREATED;
        return ResponseEntity.status(status).build();

    }
}
