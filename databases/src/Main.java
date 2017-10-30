import Entity.Room;
import Model.RoomsModel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RoomsModel roomManager = new RoomsModel();
        RoomsModel.connect();

        roomManager.createRoom(123, 2);
        roomManager.createRoom(237, 1);
        roomManager.createRoom(435, 1);

        List<Room> res = roomManager.getAllRooms();

        boolean temp = true;
        for (Room r : res) {
            System.out.println(r);
            if (r.getId() == 435)
                temp = !(r.isVacant());
        }

        System.out.println(temp);

        roomManager.updateRoomVacantById(435, temp);

        List<Room> resz = roomManager.getAllRooms();

        for (Room r : resz) {
            if (r.getId() == 435)
                System.out.println(r);
        }

        RoomsModel.close();
    }
}