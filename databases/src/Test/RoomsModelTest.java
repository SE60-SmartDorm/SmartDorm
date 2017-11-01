package Test;

import Entity.Room;
import Model.RoomsModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomsModelTest {

    @Test
    public void countRooms() throws Exception {
        RoomsModel.connect();
        assertEquals(3L, RoomsModel.countRooms());
        RoomsModel.close();
    }

    @Test
    public void getRoomById() throws Exception {
        RoomsModel.connect();
        Room r = new Room(435, 1, false);
        assertEquals(r, RoomsModel.getRoomById(435));
        assertEquals(null, RoomsModel.getRoomById(898));
        RoomsModel.close();
    }

    @Test
    public void createRoom() throws Exception {
        RoomsModel.connect();
        assertEquals(false, RoomsModel.createRoom(435, 1));
        assertEquals(true, RoomsModel.createRoom(632, 2));
        RoomsModel.removeRoomById(632);
        RoomsModel.close();
    }

    @Test
    public void getAllRooms() throws Exception {
        RoomsModel.connect();
        assertEquals(3, RoomsModel.getAllRooms().size());
        RoomsModel.close();
    }

    @Test
    public void removeRoomById() throws Exception {
        RoomsModel.connect();
        assertEquals(true, RoomsModel.removeRoomById(435));
        assertEquals(false, RoomsModel.removeRoomById(898));
        RoomsModel.createRoom(435, 1);
        RoomsModel.close();
    }

    @Test
    public void updateRoomVacantById() throws Exception {
        RoomsModel.connect();
        assertEquals(true, RoomsModel.updateRoomVacantById(435, true));
        assertEquals(false, RoomsModel.updateRoomVacantById(898, false));
        RoomsModel.updateRoomVacantById(435, false);
        RoomsModel.close();
    }

}