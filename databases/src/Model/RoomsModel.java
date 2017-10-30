package Model;

import Entity.Room;

import javax.persistence.*;
import java.util.List;

public class RoomsModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/Rooms.odb");
    }

    public static void close() {
        emf.close();
    }

    public long countRoooms() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Entity.Room p");
        long count = Long.parseLong(q1.getSingleResult().toString());
        em.close();
        return count;
    }

    public Room getRoomById(long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Room> query = em.createQuery("SELECT r FROM Room r WHERE r.id = :id", Room.class);
        query.setParameter("id", id);
        List<Room> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    public void createRoom(long id, int type) {
        if (getRoomById(id) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Room r = new Room(id, type, false);
            em.persist(r);
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("ALREADY");
    }

    public List<Room> getAllRooms() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT r FROM Room r");
        List<Room> result = q1.getResultList();
        em.close();
        return result;
    }

    public void removeRoomById(long id) {
        if (getRoomById(id) != null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery(
                    "DELETE FROM Room r WHERE r.id = :id");
            query.setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("NOPE");
    }

    public void updateRoomVacantById(long id, boolean status) {
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
            return;
        }
        System.out.println("NOPE--UPDATE");
    }

}
