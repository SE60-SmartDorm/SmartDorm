package Model;

import Entity.Message;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class MessageModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        Map<String, String> properties = Config.properties;
        emf = Persistence.createEntityManagerFactory(
                Config.serverURI + "Messages.odb", properties);
    }

    public static void close() {
        emf.close();
    }

    public static void createMessage(long owner_id, String type, String topic, String detail, String timestamp) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Message m = new Message(owner_id, type, topic, detail, timestamp);
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateReadById(long mid, boolean stat) {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "UPDATE Message m SET read = :status " +
                        "WHERE m.id = :id");
        query.setParameter("status", stat);
        query.setParameter("id", mid);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static long countMessage() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(m) FROM Entity.Message m");
        long count = Long.parseLong(q1.getSingleResult().toString());
        em.close();
        return count;
    }

    public static List<Message> getAllMessages() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT m FROM Message m");
        List<Message> result = q1.getResultList();
        em.close();
        return result;
    }

    public static Message getMessageById(long mid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m WHERE m.id = :id", Message.class);
        query.setParameter("id", mid);
        List<Message> result = query.getResultList();
        em.close();
        return result.get(0);
    }

    public static List<Message> getMessageByOwnerId(long oid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m WHERE m.owner_id = :id", Message.class);
        query.setParameter("id", oid);
        List<Message> result = query.getResultList();
        em.close();
        return result;
    }

}
