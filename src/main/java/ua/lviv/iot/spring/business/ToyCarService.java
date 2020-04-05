package ua.lviv.iot.spring.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

}
