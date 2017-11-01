package Model;

import Entity.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class TypesModel {
    private static EntityManagerFactory emf;

    public static void connect() {
        Map<String, String> properties = Config.properties;
        emf = Persistence.createEntityManagerFactory(
                Config.serverURI + "Types.odb", properties);
    }

    public static void close() {
        emf.close();
    }

    public long countTypes() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(t) FROM Type t");
        long count = Long.parseLong(q1.getSingleResult().toString());
        em.close();
        return count;
    }

    public Type getTypeById(long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Type> query = em.createQuery("SELECT t FROM Type t WHERE t.id = :id", Type.class);
        query.setParameter("id", id);
        List<Type> result = query.getResultList();
        em.close();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    public void createType(long id, String name, double cost) {
        if (getTypeById(id) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Type t = new Type(id, name, cost);
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("ALREADY");
    }

    public List<Type> getAllTypes() {
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT t FROM Type t");
        List<Type> result = q1.getResultList();
        em.close();
        return result;
    }

    public void removeTypeById(long id) {
        if (getTypeById(id) != null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery(
                    "DELETE FROM Type t WHERE t.id = :id");
            query.setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("NOPE");
    }

    public void updateTypeCostById(long id, double cost) {
        if (getTypeById(id) != null) {
            EntityManager em = emf.createEntityManager();
            em.getEntityManagerFactory().getCache().evictAll();
            em.getTransaction().begin();
            Query query = em.createQuery(
                    "UPDATE Type t SET cost = :cost " +
                            "WHERE t.id = :id");
            query.setParameter("cost", cost);
            query.setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();
            return;
        }
        System.out.println("NOPE--UPDATE");
    }

}
