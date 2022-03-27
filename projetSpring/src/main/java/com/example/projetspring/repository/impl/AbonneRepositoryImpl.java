package com.example.projetspring.repository.impl;

import com.example.projetspring.Abonne;
import com.example.projetspring.Sexe;
import com.example.projetspring.repository.api.AbonneRepository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;

public class AbonneRepositoryImpl  extends BaseRepositoryImpl implements AbonneRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public AbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public Abonne findByNom(String nom ){
        return (Abonne) entityManager.createQuery("Select A from Abonne A " +
                "where A.nom=?1").setParameter(1,nom).getSingleResult();
    }
    /*
    public void saveAbonne(String nom, String prenom, String adresse, Sexe sexe, LocalDate dateNais){
        Abonne a = new Abonne();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setAdresse(adresse);
        Date date = new Date();
        a.setDateAbonnement(date);
        a.setSexe(sexe);
        a.setDateNaissance(dateNais);
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
        entityManager.detach(a);

    }*/
    public void saveAbonne(Abonne a){
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
        entityManager.detach(a);
    }

    

    public void updateAbonne(Abonne a){
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
        entityManager.detach(a);
    }

    public Abonne findById( long codesecret){
        return entityManager.find(Abonne.class, codesecret);
    }


    public Abonne trouverAbonne(int num){
        return entityManager.createQuery("select a from Abonne a where a.nom=?1", Abonne.class).setParameter(1,num).getSingleResult();

    }

}