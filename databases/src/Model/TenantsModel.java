package Model;

import Entity.Tenant;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class TenantsModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        Map<String, String> properties = Config.properties;
        emf = Persistence.createEntityManagerFactory(
                Config.serverURI + "Tenants.odb", properties);
    }

    public static void close() {
        emf.close();
    }

    public static long countTenants() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Tenant p");
        long count = Long.parseLong(q1.getSingleResult().toString());
        em.close();
        return count;
    }

    public static List<Tenant> getTenantByRoomId(long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Tenant> query = em.createQuery("SELECT p FROM Tenant p WHERE p.roomId = :id", Tenant.class);
        query.setParameter("id", id);
        List<Tenant> result = query.getResultList();
        em.close();
        return result;
    }

    public static Tenant getTenantByUserId(long cid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Tenant> query = em.createQuery("SELECT p FROM Tenant p WHERE p.id = :cid", Tenant.class);
        query.setParameter("cid", cid);
        List<Tenant> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    public static Tenant getTenantByCitizenId(long cid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Tenant> query = em.createQuery("SELECT p FROM Tenant p WHERE p.citizenId = :cid", Tenant.class);
        query.setParameter("cid", cid);
        List<Tenant> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    public static void createTenant(long roomId, String name, String nickname, String dob, long citizenId, String phone, String email, String address, String emergency_ppl, String emergency_relation, String type, String school, String faculty, String position, int year) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Tenant p = new Tenant(roomId, name, nickname, dob, citizenId, phone, email, address, emergency_ppl, emergency_relation, type, school, faculty, position, year);
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Tenant> getAllTenants() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT p FROM Tenant p");
        List<Tenant> result = q1.getResultList();
        em.close();
        return result;
    }

    public static void removeTenantById(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "DELETE FROM Tenant p WHERE p.id = :id");
        query.setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static void updateTenantInfoByUID(long uid, String name, String nickname, String phone, String email, String address, String emergency_ppl, String emergency_relation, String school, String faculty) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "UPDATE Tenant p SET name = :nme, " +
                        "nickname = :ninme, " +
                        "phone = :phn, " +
                        "email = :eml, " +
                        "address = :adrs, " +
                        "emergency_ppl = :emppl, " +
                        "emergency_relation = :emrl, " +
                        "school = :schl, " +
                        "faculty = :fcty " +
                        "WHERE p.id = :uid");
        query.setParameter("nme", name);
        query.setParameter("ninme", nickname);
        query.setParameter("phn", phone);
        query.setParameter("eml", email);
        query.setParameter("adrs", address);
        query.setParameter("emppl", emergency_ppl);
        query.setParameter("emrl", emergency_relation);
        query.setParameter("schl", school);
        query.setParameter("fcty", faculty);
        query.setParameter("uid", uid);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
