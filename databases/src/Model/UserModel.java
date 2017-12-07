package Model;

import Entity.User;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class UserModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        Map<String, String> properties = Config.properties;
        emf = Persistence.createEntityManagerFactory(
                Config.serverURI + "User.odb", properties);
    }

    public static void close() {
        emf.close();
    }

    public static void createUser(long tenant_id) {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(u) FROM User u");
        long count = Long.parseLong(q1.getSingleResult().toString()) + 1;
        String username = "SE" + String.format("%04d", count);
        em.getTransaction().begin();
        String patt = "abcdefghijklmnopqrstuvwxyz1234567890";
        String pass = "";
        for (int i = 0; i < 5; i++) {
            int indx = (int)(Math.random() * patt.length());
            pass += Character.toString(patt.charAt(indx));
        }
        User u = new User(username, pass, tenant_id);
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }

    public static void removeTenantById(long tenant_id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(
                "DELETE FROM User u WHERE u.tenant_id = :id");
        query.setParameter("id", tenant_id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public static User getUserByUsername(String uid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.uid = :uid", User.class);
        query.setParameter("uid", uid);
        List<User> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    public static User getUserByTenantId(long tid) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.tenant_id = :tid", User.class);
        query.setParameter("tid", tid);
        List<User> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }


}
