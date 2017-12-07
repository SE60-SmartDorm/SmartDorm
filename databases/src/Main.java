import Controller.TenantController;
import Entity.Room;
import Entity.Tenant;
import Model.RoomsModel;
import Model.TenantsModel;
import Model.TypesModel;
import ProgramException.DatabaseException;



public class Main {

    public static void main(String[] args) throws DatabaseException {
        System.out.println(TenantController.count());

        Tenant p = TenantController.getById(4);
        System.out.println(p.getName());
        TenantController.update(4, "นายอิอิ กำ", p.getNickname(), p.getPhone(), p.getEmail(), p.getAddress(), p.getEmergency_ppl(), p.getEmergency_relation(), p.getSchool(), p.getFaculty());

        p = TenantController.getById(4);
        System.out.println(p.getName());
        System.out.println(TenantController.count());

    }

}



