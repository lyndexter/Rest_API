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
import javax.persistence.ManyToOne;

@Entity
public abstract class Toy {

    private double priceInUAH;
    private int ageGroup;
    private Size size;
    private TypeOfToy typeOfToy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id")
    @JsonIgnoreProperties("toys")
    private Child child;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Shop_Toy", joinColumns = {
            @JoinColumn(name = "toy_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "shop_id", nullable = false) })
    @JsonIgnoreProperties("toys")
    private Set<Shop> shops;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    public Toy(double priceInUAH, int ageGroup, Size size) {
        this.priceInUAH = priceInUAH;
        this.ageGroup = ageGroup;
        this.size = size;
    }

    public String getHeaders() {
        return "priceInUAH" + "," + "ageGroup" + "," + "size" + "," + "typeOfToy";
    }

    public String toCSV() {
        return getPriceInUAH() + "," + getAgeGroup() + "," + getSize() + "," + getTypeOfToy();
    }

    public double getPriceInUAH() {
        return priceInUAH;
    }

    public void setPriceInUAH(double priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public TypeOfToy getTypeOfToy() {
        return typeOfToy;
    }

    public void setTypeOfToy(TypeOfToy typeOfToy) {
        this.typeOfToy = typeOfToy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ageGroup;
        result = prime * result + ((child == null) ? 0 : child.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        long temp;
        temp = Double.doubleToLongBits(priceInUAH);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((shops == null) ? 0 : shops.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((typeOfToy == null) ? 0 : typeOfToy.hashCode());
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
        Toy other = (Toy) obj;
        if (ageGroup != other.ageGroup) {
            return false;
        }
        if (child == null) {
            if (other.child != null) {
                return false;
            }
        } else if (!child.equals(other.child)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (Double.doubleToLongBits(priceInUAH) != Double.doubleToLongBits(other.priceInUAH)) {
            return false;
        }
        if (shops == null) {
            if (other.shops != null) {
                return false;
            }
        } else if (!shops.equals(other.shops)) {
            return false;
        }
        if (size != other.size) {
            return false;
        }
        if (typeOfToy != other.typeOfToy) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Toy [priceInUAH=" + priceInUAH + ", ageGroup=" + ageGroup + ", size=" + size
                + ", typeOfToy=" + typeOfToy + ", child=" + child + ", shops=" + shops + ", id="
                + id + "]";
    }

}
