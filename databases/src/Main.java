import Entity.Room;
import Entity.Tenant;
import Model.RoomsModel;
import Model.TenantsModel;
import Model.TypesModel;
import ProgramException.DatabaseException;



public class Main {

    public static void main(String[] args) throws DatabaseException {
        RoomsModel.connect();

        try {
            RoomsModel.getRoomById(777);
        } catch (DatabaseException ex) {
            System.out.println(ex.getMessage());
            throw new DatabaseException(ex.getMessage());
        }

        RoomsModel.close();


    }

}


