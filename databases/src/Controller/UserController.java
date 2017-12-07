package Controller;

import Entity.Tenant;
import Entity.User;
import Model.UserModel;
import Model.UserModel;
import ProgramException.DatabaseException;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserController {
    public static void create(long tenant_id) throws DatabaseException {
        UserModel.connect();
        if (UserModel.getUserByTenantId(tenant_id) == null) {
            UserModel.createUser(tenant_id);
        } else {
            UserModel.close();
            throw new DatabaseException("User already exist");
        }

        UserModel.close();
    }

    public static boolean checkPassword(String uid, String pass) {
        UserModel.connect();
        User a = UserModel.getUserByUsername(uid);
        if (a != null && a.getPassword() == pass)
            return true;
        else
            return false;
    }

    public static void removeUserByTenant(long tid) {
        UserModel.connect();
        UserModel.removeTenantById(tid);
        UserModel.close();
    }


}
