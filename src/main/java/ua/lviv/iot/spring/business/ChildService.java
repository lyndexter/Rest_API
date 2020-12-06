package ua.lviv.iot.spring.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.dataaccess.ChildRepository;
import ua.lviv.iot.spring.rest.model.Child;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public Child createChild(Child child) {
        return childRepository.save(child);
    }

    public List<Child> findAll() {
        return childRepository.findAll();
    }

    public Child find(Integer childId) {
        return childRepository.findById(childId).get();
    }

    public HttpStatus delete(Integer childId) {
        HttpStatus status = childRepository.existsById(childId) ? HttpStatus.OK
                : HttpStatus.NOT_FOUND;
        childRepository.deleteById(childId);
        return status;
    }

    public HttpStatus update(Integer childId, Child child) {
        HttpStatus status;
        child.setId(childId);
        if (childRepository.existsById(childId)) {
            status = HttpStatus.CREATED;
            childRepository.save(child);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return status;
    }

}
