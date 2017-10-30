import Entity.Room;
import Entity.Type;
import Model.RoomsModel;
import Model.TypesModel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TypesModel typesManager = new TypesModel();
        RoomsModel roomsManager = new RoomsModel();

        TypesModel.connect();
        RoomsModel.connect();

        typesManager.createType(1, "1 Bed", 3000);
        typesManager.createType(2, "2 Bed", 5000);
        typesManager.createType(3, "Suite", 8000);

        List<Type> res = typesManager.getAllTypes();

        for (Type t : res) {
            System.out.println(t);
        }

        List<Room> rmres = roomsManager.getAllRooms();
        for (Room r : rmres) {
            System.out.println(r);
        }

        typesManager.updateTypeCostById(2, 5500);

        res = typesManager.getAllTypes();

        for (Type t : res) {
            System.out.println(t);
        }

        double tpe = typesManager.getTypeById(roomsManager.getRoomById(435).getType()).getCost();
        System.out.println(tpe);

        TypesModel.close();
        RoomsModel.close();

    }
}