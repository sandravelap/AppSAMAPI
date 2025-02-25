package com.sanalberto.svp.dataBase;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@ApplicationScoped
public class DatabaseInitializer {
    EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    @PostConstruct
    public void init() {
        try (EntityManager em = emf.createEntityManager()) {
            // This will trigger the schema generation
            em.createNativeQuery("select * from Issue").getSingleResult();
        }
    }
}
