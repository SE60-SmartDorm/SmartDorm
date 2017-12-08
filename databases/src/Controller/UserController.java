package Controller;

import Entity.Tenant;
import Entity.User;
import Model.UserModel;
import Model.UserModel;
import ProgramException.DatabaseException;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserController {
    public static User create(long tenant_id) {
        UserModel.connect();
        if (UserModel.getUserByTenantId(tenant_id) == null) {
            UserModel.createUser(tenant_id);
        }

        User u = UserModel.getUserByTenantId(tenant_id);
        UserModel.close();
        return u;
    }

    public static boolean checkPassword(String uid, String pass) {
        UserModel.connect();
        User a = UserModel.getUserByUsername(uid);
        UserModel.close();
        if (a != null && a.getPassword().equals(pass))
            return true;
        else
            return false;
    }

    public static Long getTenantIdByUid(String uid) {
        UserModel.connect();
        Long oid = UserModel.getUserByUsername(uid).getTenant_id();
        UserModel.close();
        return oid;
    }

    public static void removeUserByTenant(long tid) {
        UserModel.connect();
        UserModel.removeTenantById(tid);
        UserModel.close();
    }

    public static void updateTidByUid(String uid, long tid) {
        UserModel.connect();
        UserModel.updateTidByUid(uid, tid);
        UserModel.close();
    }


}
