package Model;

import Entity.Rental;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class RentalModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        Map<String, String> properties = Config.properties;
        emf = Persistence.createEntityManagerFactory(
                Config.serverURI + "Rental.odb", properties);
    }

    public static void close() {
        emf.close();
    }

    public static void createRentalRecord(long owner_id, int month, int year, double room_rent, double water, double electric, double other) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Rental m = new Rental(owner_id, month, year, room_rent, water, electric, other);
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }

    public static void updatePaidById(long rid, boolean stat) {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "UPDATE Rental r SET paid = :status " +
                        "WHERE r.id = :id");
        query.setParameter("status", stat);
        query.setParameter("id", rid);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static List<Rental> getAllRentals() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT r FROM Rental r");
        List<Rental> result = q1.getResultList();
        em.close();
        return result;
    }

    public static Rental getRentalById(long rid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r WHERE r.id = :id", Rental.class);
        query.setParameter("id", rid);
        List<Rental> result = query.getResultList();
        em.close();
        return result.get(0);
    }

    public static List<Rental> getRentalByOwnerId(long oid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r WHERE r.owner_id = :id", Rental.class);
        query.setParameter("id", oid);
        List<Rental> result = query.getResultList();
        em.close();
        return result;
    }
}
