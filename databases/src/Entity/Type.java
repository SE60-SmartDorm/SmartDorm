package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private double cost;

    public Type(long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        String res = "Entity.Type ";
        res += "ID: " + this.id + " ";
        res += "Name: " + this.name + " ";
        res += "Cost: " + this.cost;

        return res;
    }
}