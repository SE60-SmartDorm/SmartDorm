import Controller.RentalController;
import Controller.RoomController;
import Controller.TenantController;
import Controller.UserController;
import Entity.Room;
import Entity.Tenant;
import Model.RoomsModel;
import Model.TenantsModel;
import Model.TypesModel;
import ProgramException.DatabaseException;



public class Main {

    public static void main(String[] args) throws DatabaseException {
        for (int i = 1; i <= 12; i++) {
            double wt = (double)((int)((Math.random() * 5) + 1));
            double elec = (double)((int)((Math.random() * 100) + 1));
            RentalController.create(2, i, 2017, 3600, wt, elec, 100);
        }
    }

}



