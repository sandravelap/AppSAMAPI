package com.sanalberto.svp.repositories;

import com.sanalberto.svp.daos.Issue;
import com.sanalberto.svp.dataBase.EmfSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.sql.Date;
import java.time.LocalDate;

public class IssuesRepositories {
    EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    public void insertIssue() {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Issue testIssue = new Issue();
            testIssue.setDescription("test description");
            testIssue.setInitDate(Date.valueOf(LocalDate.now()));
            em.persist(testIssue);
            em.getTransaction().commit();
        }
    }
}
