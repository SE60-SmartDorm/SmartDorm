package Model;

import Entity.Room;
import ProgramException.DatabaseException;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class RoomsModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        Map<String, String> properties = Config.properties;
        emf = Persistence.createEntityManagerFactory(
                Config.serverURI + "Rooms.odb", properties);
    }

    public static void close() {
        emf.close();
    }

    public static long countRooms() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(r) FROM Entity.Room r");
        long count = Long.parseLong(q1.getSingleResult().toString());
        em.close();
        return count;
    }

    public static Room getRoomById(long id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Room> query = em.createQuery("SELECT r FROM Room r WHERE r.id = :id", Room.class);
        query.setParameter("id", id);
        List<Room> result = query.getResultList();
        em.close();
        return result.get(0);
    }

    public static void createRoom(long id, int type) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Room r = new Room(id, type, false, 0, 0);
        em.persist(r);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Room> getAllRooms() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT r FROM Room r");
        List<Room> result = q1.getResultList();
        em.close();
        return result;
    }

    public static void removeRoomById(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "DELETE FROM Room r WHERE r.id = :id");
        query.setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static void updateRoomVacantById(long id, boolean status) {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "UPDATE Room r SET vacant = :status " +
                        "WHERE r.id = :id");
        query.setParameter("status", status);
        query.setParameter("id", id);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static void updateTenant(long rid, long primary_tenant, long secondary_tenant) {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "UPDATE Room r SET primary_tenant = :ptn, " +
                        "secondary_tenant = :stn " +
                        "WHERE r.id = :id");
        query.setParameter("ptn", primary_tenant);
        query.setParameter("stn", secondary_tenant);
        query.setParameter("id", rid);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
