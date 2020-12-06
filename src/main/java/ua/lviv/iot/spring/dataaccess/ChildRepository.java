package ua.lviv.iot.spring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.rest.model.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {

}
