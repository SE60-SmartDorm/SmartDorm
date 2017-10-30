package Model;

import Entity.Tenant;

import javax.persistence.*;
import java.util.List;

public class TenantsModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/Tenants.odb");
    }

    public static void close() {
        emf.close();
    }

    public long countTenants() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Tenant p");
        long count = Long.parseLong(q1.getSingleResult().toString());
        em.close();
        return count;
    }

    public Tenant getTenantByRoomId(long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Tenant> query = em.createQuery("SELECT p FROM Tenant p WHERE p.roomId = :id", Tenant.class);
        query.setParameter("id", id);
        List<Tenant> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    public void createTenant(long roomId, String fname, String lname, long cid, String phn, String addrs) {
        if (getTenantByRoomId(roomId) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Tenant p = new Tenant(roomId, fname, lname, cid, phn, addrs);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("ALREADY");
    }

    public List<Tenant> getAllTenants() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT p FROM Tenant p");
        List<Tenant> result = q1.getResultList();
        em.close();
        return result;
    }

    public void removeTenantByRoomId(long id) {
        if (getTenantByRoomId(id) != null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery(
                    "DELETE FROM Tenant p WHERE p.roomId = :id");
            query.setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("NOPE");
    }

    public void updateTenantInfoByRoomId(long roomId, String fname, String lname, long cid, String phn, String addrs) {
        if (getTenantByRoomId(roomId) != null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery(
                    "UPDATE Tenant p SET firstname = :fname, " +
                            "lastname = :lname, " +
                            "citizenId = :cid, " +
                            "phone = :phn, " +
                            "address = :addrs " +
                            "WHERE p.roomId = :roomId");
            query.setParameter("roomId", roomId);
            query.setParameter("fname", fname);
            query.setParameter("lname", lname);
            query.setParameter("cid", cid);
            query.setParameter("phn", phn);
            query.setParameter("addrs", addrs);
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("NOPE--UPDATE");
    }

}
