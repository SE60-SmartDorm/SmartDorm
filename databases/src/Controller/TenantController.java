package Controller;

import Entity.Tenant;
import Model.TenantsModel;
import ProgramException.DatabaseException;

import java.util.List;

public class TenantController {
    public static void create(long roomId, String name, String nickname, String dob, String citizenId, String phone, String email, String address, String emergency_ppl, String emergency_relation, String emergency_telephone, String type, String school, String faculty, String position, String year)  {
        TenantsModel.connect();
        if (TenantsModel.getTenantByCitizenId(citizenId) == null) {
            TenantsModel.createTenant(roomId, name, nickname, dob, citizenId, phone, email, address, emergency_ppl, emergency_relation, emergency_telephone, type, school, faculty, position, year);
        }
        TenantsModel.close();
    }

    public static long count() {
        TenantsModel.connect();
        long result = TenantsModel.countTenants();
        TenantsModel.close();
        return result;
    }

    public static void update(long uid, String name, String nickname, String phone, String email, String address, String emergency_ppl, String emergency_relation, String emergency_telephone, String school, String faculty) throws DatabaseException {
        TenantsModel.connect();
        if (TenantsModel.getTenantByUserId(uid) != null) {
            TenantsModel.updateTenantInfoByUID(uid, name, nickname, phone, email, address, emergency_ppl, emergency_relation, emergency_telephone, school, faculty);
        } else {
            TenantsModel.close();
            throw new DatabaseException("User not found");
        }
        TenantsModel.close();
    }

    public static Tenant getById(long userId) {
        TenantsModel.connect();
        Tenant p = TenantsModel.getTenantByUserId(userId);
        TenantsModel.close();
        return p;
    }

    public static List<Tenant> getByRoomId(long roomId) {
        if (RoomController.getById(roomId) != null) {
            TenantsModel.connect();
            List<Tenant> result = TenantsModel.getTenantByRoomId(roomId);
            TenantsModel.close();
            return result;
        }
        return null;
    }

    public static void removeById (long uid) {
        TenantsModel.connect();
        TenantsModel.removeTenantById(uid);
        TenantsModel.close();
    }

    public static Tenant getByCitizenId(String cid) {
        TenantsModel.connect();
        Tenant p = TenantsModel.getTenantByCitizenId(cid);
        TenantsModel.close();
        return p;
    }
}

