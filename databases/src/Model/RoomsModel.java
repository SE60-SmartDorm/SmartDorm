package Model;

import Entity.Room;

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
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Entity.Room p");
        long count = Long.parseLong(q1.getSingleResult().toString());
        em.close();
        return count;
    }

    public static Room getRoomById(long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Room> query = em.createQuery("SELECT r FROM Room r WHERE r.id = :id", Room.class);
        query.setParameter("id", id);
        List<Room> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    public static boolean createRoom(long id, int type) {
        if (getRoomById(id) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Room r = new Room(id, type, false);
            em.persist(r);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }

    public static List<Room> getAllRooms() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT r FROM Room r");
        List<Room> result = q1.getResultList();
        em.close();
        return result;
    }

    public static boolean removeRoomById(long id) {
        if (getRoomById(id) != null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery(
                    "DELETE FROM Room r WHERE r.id = :id");
            query.setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }

    public static boolean updateRoomVacantById(long id, boolean status) {
        if (getRoomById(id) != null) {
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
            return true;
        }
        return false;
    }

}
