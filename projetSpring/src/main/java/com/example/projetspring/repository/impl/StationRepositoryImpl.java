package com.example.projetspring.repository.impl;

import com.example.projetspring.*;
import com.example.projetspring.Etat;
import com.example.projetspring.repository.api.StationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class StationRepositoryImpl  extends BaseRepositoryImpl implements StationRepository {


    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public StationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public void saveStation(Station s){
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
        entityManager.detach(s);
    }
    public Station findById(Long id) {
        return entityManager.find(Station.class, id);
    }

    public List<Station> getAll(){
        return entityManager.createNamedQuery("get-all-stations", Station.class ).getResultList();

    }
    public List<Station> getByStatut(Statut statut){
        return entityManager.createQuery("Select s from Station s where s.status=?1" , Station.class).setParameter(1,statut).getResultList();
    }

    //Affiche la liste des velos disponibles
    public List<Velo> getVelosByStation(Long id){
        var station = findById(id);

        return entityManager.createQuery("Select v from Station s join s.Contient b Join b.Propose v where b.estPresent=?1 and v.etat=?2 and b.etat=?3" , Velo.class)
                .setParameter(1,true)
                .setParameter(2, Etat.OK).setParameter(3,Etat.OK).getResultList();
    }
    public void saveVelo(Velo v){
        entityManager.getTransaction().begin();
        entityManager.persist(v);
        entityManager.getTransaction().commit();
        entityManager.detach(v);
    }

    public int getNombreVeloParStation(Station station){
        int somme = 0 ;
        for( int i =0 ; i < station.getContient().size() ; i++){
                if( station.getContient().get(i).estPresent()){
                    somme++;
                }
        }
        return somme ;
    }
    public int getNombrePlaceLibreParBornette( Station station){
        int somme = 0 ;
        for (Bornette b:station.getContient()) {
            if( (!b.estPresent()) && b.getEtat().equals(Etat.OK) ){
                somme++;
            }

        }
        return somme;
    }
    public int getNombreVeloEndommageByStation( Station station){
        int somme = 0 ;
        for( int i =0 ; i < station.getContient().size() ; i++){
            if(station.getContient().get(i).getPropose()!=null) {
                if ((station.getContient().get(i).getPropose().getEtat().equals(Etat.HS))) {
                    somme++;
                }
            }
        }
        return somme;
    }

    public int getNombreVeloOKByStation( Station station){
        int somme = 0 ;
        for( int i =0 ; i < station.getContient().size() ; i++){
            if(station.getContient().get(i).getPropose()!=null) {
                if ((station.getContient().get(i).getPropose().getEtat().equals(Etat.OK))) {
                    somme++;
                }
            }
        }
        return somme;
    }



}
