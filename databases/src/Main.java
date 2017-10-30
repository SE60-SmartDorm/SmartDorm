import Entity.Room;
import Entity.Tenant;
import Model.RoomsModel;
import Model.TenantsModel;
import Model.TypesModel;

public class Main {
    public static void main(String[] args) {
        TypesModel typesManager = new TypesModel();
        RoomsModel roomsManager = new RoomsModel();
        TenantsModel tenantsManager = new TenantsModel();

        TypesModel.connect();
        RoomsModel.connect();
        TenantsModel.connect();

        tenantsManager.createTenant(237, "ul", "Timate",
                1250100357136L, "0848652299", "your balls");
        roomsManager.updateRoomVacantById(237, false);
        tenantsManager.createTenant(435, "Panda", "Rannnn",
                1112223334445L, "0812345678", "yo puzzy");
        roomsManager.updateRoomVacantById(435, false);
        tenantsManager.createTenant(123, "JBas", "Saooo",
                9998887776665L, "0898765432", "yo ass");
        roomsManager.updateRoomVacantById(123, false);

        for (Room r : roomsManager.getAllRooms())
            System.out.println(r);

        for (Tenant p : tenantsManager.getAllTenants())
            System.out.println(p);

        tenantsManager.updateTenantInfoByRoomId(123, "TO", "ON",
                1212312121123L, "0818181818", "yo shit");

        for (Tenant p : tenantsManager.getAllTenants())
            System.out.println(p);

        tenantsManager.removeTenantByRoomId(435);
        roomsManager.updateRoomVacantById(435, true);

        for (Room r : roomsManager.getAllRooms())
            System.out.println(r);

        for (Tenant p : tenantsManager.getAllTenants())
            System.out.println(p);

        tenantsManager.createTenant(435, "Panda", "Rannnn",
                1112223334445L, "0812345678", "yo puzzy");
        roomsManager.updateRoomVacantById(435, false);

        for (Tenant p : tenantsManager.getAllTenants())
            System.out.println(p);

        TypesModel.close();
        RoomsModel.close();
        TenantsModel.close();

    }
}