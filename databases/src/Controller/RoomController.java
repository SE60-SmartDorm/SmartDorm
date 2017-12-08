package Controller;

import Entity.Room;
import Model.RoomsModel;
import ProgramException.DatabaseException;

import java.util.List;

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

    public static void updateTenant(long rid, long primary_tenant, long secondary_tenant) {
        RoomsModel.connect();
        if (getById(rid) != null) {
            RoomsModel.connect();
            RoomsModel.updateTenant(rid, primary_tenant, secondary_tenant);
            RoomsModel.close();
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

    public static Room getById(long rid) {
        RoomsModel.connect();
        Room r = RoomsModel.getRoomById(rid);
        RoomsModel.close();
            return r;
    }

    public static List<Room> getAllRooms() {
        RoomsModel.connect();
        List<Room> r = RoomsModel.getAllRooms();
        RoomsModel.close();
        return r;
    }

    public static void setContactDate(Long rid, String start_date, String end_date) {
        RoomsModel.connect();
        RoomsModel.updateContactDateByRoomId(rid, start_date, end_date);
        RoomsModel.close();
    }

    public static Room getByTenantId(Long tid) {
        RoomsModel.connect();
        Room r = RoomsModel.getRoomByTenantId(tid);
        RoomsModel.close();
        return r;
    }


}
