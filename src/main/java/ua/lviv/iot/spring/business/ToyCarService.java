package ua.lviv.iot.spring.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.dataaccess.ToyCarRepository;
import ua.lviv.iot.spring.rest.model.ToyCar;

@Service
public class ToyCarService {

    @Autowired
    ToyCarRepository toyCarRepository;

    public ToyCar createToyCar(ToyCar toyCar) {
        return toyCarRepository.save(toyCar);
    }

    public List<ToyCar> findAll() {
        return toyCarRepository.findAll();
    }

    public ToyCar find(Integer toyCarId) {
        return toyCarRepository.findById(toyCarId).get();
    }

    public HttpStatus deleteToyCar(Integer toyCarId) {
        HttpStatus status = toyCarRepository.existsById(toyCarId) == false ? HttpStatus.NOT_FOUND
                : HttpStatus.OK;
        toyCarRepository.deleteById(toyCarId);
        return status;
    }

    public HttpStatus updateToyCar(Integer toyCarId, ToyCar toyCar) {
        toyCar.setId(toyCarId);
        toyCarRepository.save(toyCar);
        HttpStatus status = toyCarRepository.existsById(toyCarId) == false ? HttpStatus.NOT_FOUND
                : HttpStatus.CREATED;
        return status;
    }

}
