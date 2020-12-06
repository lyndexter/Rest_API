package ua.lviv.iot.spring.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Shop {

    private String name;

    private String location;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Shop_Toy", joinColumns = {
            @JoinColumn(name = "shop_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "toy_id", nullable = false) })
    @JsonIgnoreProperties("shops")
    private Set<ToyCar> toys;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    Shop() {
    }

    public Shop(String name, String location) {
        super();
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<ToyCar> getToys() {
        return toys;
    }

    public void setToys(Set<ToyCar> toys) {
        this.toys = toys;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((toys == null) ? 0 : toys.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Shop other = (Shop) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (location == null) {
            if (other.location != null) {
                return false;
            }
        } else if (!location.equals(other.location)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (toys == null) {
            if (other.toys != null) {
                return false;
            }
        } else if (!toys.equals(other.toys)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shop [name=" + name + ", location=" + location + ", toys=" + toys + ", id=" + id
                + "]";
    }

}
