package Controller;

import Entity.Rental;
import Model.RentalModel;

import java.util.List;

public class RentalController {
    public static void create(long oid, int month, int year, float room_rent, float water, float electric, float other) {
        RentalModel.connect();
        RentalModel.createRentalRecord(oid, month, year, room_rent, water, electric, other);
        RentalModel.close();
    }

    public static List<Rental> getAll() {
        RentalModel.connect();
        List<Rental> m = RentalModel.getAllRentals();
        RentalModel.close();
        return m;
    }

    public static Rental getById(long rid) {
        RentalModel.connect();
        Rental r = RentalModel.getRentalById(rid);
        RentalModel.close();
        return r;
    }

    public static void setRentalPaid(long rid) {
        RentalModel.connect();
        RentalModel.updatePaidById(rid, true);
        RentalModel.close();
    }

    public static List<Rental> getByOwnerId(long oid) {
        RentalModel.connect();
        List<Rental> r = RentalModel.getRentalByOwnerId(oid);
        RentalModel.close();
        return r;
    }
}
