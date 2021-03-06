package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rental implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private long owner_id;
    private int month, year;
    private double room_rent, water, electric, other;
    private boolean paid;

    public Rental(long owner_id, int month, int year, double room_rent, double water, double electric, double other) {
        this.owner_id = owner_id;
        this.month = month;
        this.year = year;
        this.room_rent = room_rent;
        this.water = water;
        this.electric = electric;
        this.other = other;
        this.paid = false;
    }

    public long getId() {
        return id;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getRoom_rent() {
        return room_rent;
    }

    public double getWater() {
        return water;
    }

    public double getElectric() {
        return electric;
    }

    public double getOther() {
        return other;
    }

    public boolean isPaid() {
        return paid;
    }
}