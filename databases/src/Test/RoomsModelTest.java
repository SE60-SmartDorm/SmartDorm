package Test;

import Entity.Room;
import Model.RoomsModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomsModelTest {
    private RoomsModel roomManager = new RoomsModel();


    @Test
    public void countRooms() throws Exception {
        RoomsModel.connect();
        assertEquals(3L, roomManager.countRoooms());
        RoomsModel.close();
    }

    @Test
    public void getRoomById() throws Exception {
        RoomsModel.connect();
        Room r = new Room(435, 1, false);
        assertEquals(r, roomManager.getRoomById(435));
        assertEquals(null, roomManager.getRoomById(898));
        RoomsModel.close();
    }

    @Test
    public void createRoom() throws Exception {
        RoomsModel.connect();
        assertEquals(false, roomManager.createRoom(435, 1));
        assertEquals(true, roomManager.createRoom(632, 2));
        roomManager.removeRoomById(632);
        RoomsModel.close();
    }

    @Test
    public void getAllRooms() throws Exception {
        RoomsModel.connect();
        assertEquals(3, roomManager.getAllRooms().size());
        RoomsModel.close();
    }

    @Test
    public void removeRoomById() throws Exception {
        RoomsModel.connect();
        assertEquals(true, roomManager.removeRoomById(435));
        assertEquals(false, roomManager.removeRoomById(898));
        roomManager.createRoom(435, 1);
        RoomsModel.close();
    }

    @Test
    public void updateRoomVacantById() throws Exception {
        RoomsModel.connect();
        assertEquals(true, roomManager.updateRoomVacantById(435, true));
        assertEquals(false, roomManager.updateRoomVacantById(898, false));
        roomManager.updateRoomVacantById(435, false);
        RoomsModel.close();
    }

}