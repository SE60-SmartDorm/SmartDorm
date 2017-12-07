package Controller;

import Entity.Room;
import Model.RoomsModel;
import ProgramException.DatabaseException;

public class RoomController {
    public static void create(long rid, int type) {
        RoomsModel.connect();
        RoomsModel.createRoom(rid, type);
        RoomsModel.close();
    }

    public static long count() {
        RoomsModel.connect();
        long result = RoomsModel.countRooms();
        RoomsModel.close();
        return result;
    }

    public static void updateTenant(long rid, long primary_tenant, long secondary_tenant) throws  DatabaseException{
        RoomsModel.connect();
        if (getById(rid) != null) {
            RoomsModel.updateTenant(rid, primary_tenant, secondary_tenant);
            RoomsModel.close();
        } else {
            RoomsModel.close();
            throw new DatabaseException("Room not found");
        }
    }

    public static void setRoomToVacant(long rid) {
        RoomsModel.connect();
        RoomsModel.updateRoomVacantById(rid, true);
        RoomsModel.close();
    }

    public static void setRoomToOccupied(long rid) {
        RoomsModel.connect();
        RoomsModel.updateRoomVacantById(rid, false);
        RoomsModel.close();
    }

    public static Room getById(long rid) throws DatabaseException {
        RoomsModel.connect();
        Room r = RoomsModel.getRoomById(rid);
        RoomsModel.close();
        if (r == null)
            throw new DatabaseException("Room not found");
        else
            return r;
    }


}
