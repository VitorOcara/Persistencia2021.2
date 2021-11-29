package com.example.Atv_06.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
    private static EntityManager em = emf.createEntityManager();
    private static ThreadLocal<EntityManager> ems = new ThreadLocal<>();

    public static EntityManager getEntityManager() {
        em = ems.get();
        if (em == null) {
            em = emf.createEntityManager();
            ems.set(em);
        }
        return em;
    }
    public static void closeEntityManager() {
        em = ems.get();
        if (em != null) {
            EntityTransaction tx = em.getTransaction();
            if (tx.isActive()) {
                tx.commit();
            }
            em.close();
            ems.set(null);
        }
    }

    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public static void commit() {
        EntityTransaction tx = getEntityManager().getTransaction();
        if (tx.isActive()) {
            tx.commit();
        }
    }

    public static void rollback() {
        EntityTransaction tx = getEntityManager().getTransaction();
        if (tx.isActive()) {
            tx.rollback();
        }
    }


}
