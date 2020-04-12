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
import ua.lviv.iot.spring.business.ChildService;
import ua.lviv.iot.spring.rest.model.Child;

@RestController
@RequestMapping("/childs")
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping
    public List<Child> getChilds() {
        return childService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Child getChild(@PathVariable("id") Integer childId) {
        return childService.find(childId);
    }

    @PostMapping
    public Child createChild(@RequestBody Child child) {
        return childService.createChild(child);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Child> updateChild(@PathVariable("id") Integer childId,
            @RequestBody Child child) {
        return ResponseEntity.status(childService.update(childId, child)).build();

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Child> deleteChild(@PathVariable("id") Integer childId) {
        return ResponseEntity.status(childService.delete(childId)).build();
    }
}
