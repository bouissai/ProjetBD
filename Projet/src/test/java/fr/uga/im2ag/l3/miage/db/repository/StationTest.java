package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Etat;
import fr.uga.im2ag.l3.miage.db.model.*;
import fr.uga.im2ag.l3.miage.db.model.velo;
import fr.uga.im2ag.l3.miage.db.repository.impl.StationRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static fr.uga.im2ag.l3.miage.db.model.Statut.VMOINS;
import static fr.uga.im2ag.l3.miage.db.model.Statut.VPLUS;
import static org.assertj.core.api.Assertions.assertThat;


class StationTest extends Base {

    StationRepositoryImpl stationRepository;

    @BeforeEach
    void before() {
        stationRepository = (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveStation() {
        // TODO
        final var station = new Station();
        station.setStatus(VPLUS);
        station.setAdresse("Rue de bonheur");

        entityManager.getTransaction().begin();
        entityManager.persist(station);
        entityManager.getTransaction().commit();
        entityManager.detach(station);

        var T_station = stationRepository.findById(station.getId());
        assertThat(T_station.getId() == station.getId());

    	

    }

   @Test
   void  shouldGetByStatut(){
        var station = new Station();
        station.setStatus(VPLUS);

        var station_2 = new Station();
       station_2.setStatus(VMOINS);

       var station_3 = new Station();
       station_3.setStatus(VPLUS);

       entityManager.getTransaction().begin();
       entityManager.persist(station);
       entityManager.persist(station_2);
       entityManager.persist(station_3);
       entityManager.getTransaction().commit();


       List<Station> stations = stationRepository.getByStatut(VPLUS);
       assertThat(stations.size()==2);
   }
    @Test
    void   shouldGetVelosByStation(){
        var station = new Station() ;

        //Velos
        var velo_1 = new velo();
        velo_1.setEtat(Etat.OK   );
        velo_1.setModele(Marque.BTWIB);

        var velo_2 = new velo();
        velo_2.setEtat(Etat.OK);

        var velo_3 = new velo();
        velo_1.setEtat(Etat.HS);


        var Bornette_1 = new Bornette(Etat.OK ,velo_1,true );
        var Bornette_2 = new Bornette(Etat.HS, velo_2 , true);
        var Bornette_3 = new Bornette(Etat.OK , velo_3,true);
        List<Bornette> bornettes = new ArrayList<Bornette>();
        bornettes.add(Bornette_1);
        bornettes.add(Bornette_2);
        bornettes.add(Bornette_3);

        station.setContient(bornettes);

        entityManager.getTransaction().begin();
        entityManager.persist(velo_1);
        entityManager.persist(velo_2);
        entityManager.persist(velo_3);

        entityManager.persist(Bornette_1);
        entityManager.persist(Bornette_2);
        entityManager.persist(Bornette_3);

       // entityManager.persist(bornettes);
        entityManager.persist(station);
        entityManager.getTransaction().commit();


        List<velo> velos = stationRepository.getVelosByStation(station.getId());
        assertThat( velos.size() == 2 );


    }

    @Test
    void shouldgetNombreVeloParStation(){
        var velo_1 = new velo();
        var velo_2 = new velo();
        var velo_3 = new velo();

        velo_1.setEtat(Etat.OK);
        velo_2.setEtat(Etat.OK);
        velo_3.setEtat(Etat.HS);

        var bornette_1 = new Bornette(Etat.OK,velo_1,true);
        var bornette_2 = new Bornette(Etat.OK,velo_2,true);
        var bornette_3 = new Bornette(Etat.HS,velo_3,true);
        var bornette_4 = new Bornette();
        var bornette_5 = new Bornette();

        bornette_4.setEstPresent(false);

        List<Bornette> bornettes = new ArrayList();
        bornettes.add(bornette_1);
        bornettes.add(bornette_2);
        bornettes.add(bornette_3);
        bornettes.add(bornette_4);
        bornettes.add(bornette_5);


        var station_1 = new Station();
        station_1.setContient(bornettes);




        int somme = stationRepository.getNombreVeloParStation( station_1);
        assertThat(somme==3);


    }

    @Test
    void shouldgetNombreVeloEndommageByStation(){
        var velo_1 = new velo();
        var velo_2 = new velo();
        var velo_3 = new velo();

        velo_1.setEtat(Etat.OK);
        velo_2.setEtat(Etat.OK);
        velo_3.setEtat(Etat.HS);

        var bornette_1 = new Bornette(Etat.OK,velo_1,true);
        var bornette_2 = new Bornette(Etat.OK,velo_2,true);
        var bornette_3 = new Bornette(Etat.HS,velo_3,true);
        var bornette_4 = new Bornette();
        var bornette_5 = new Bornette();

        bornette_4.setEstPresent(false);

        List<Bornette> bornettes = new ArrayList();
        bornettes.add(bornette_1);
        bornettes.add(bornette_2);
        bornettes.add(bornette_3);
        bornettes.add(bornette_4);
        bornettes.add(bornette_5);


        var station_1 = new Station();
        station_1.setContient(bornettes);

        entityManager.getTransaction().begin();
        entityManager.persist(velo_1);
        entityManager.persist(velo_2);
        entityManager.persist(velo_3);

        entityManager.persist(bornette_1);
        entityManager.persist(bornette_2);
        entityManager.persist(bornette_3);
        entityManager.persist(bornette_4);
        entityManager.persist(bornette_5);
        entityManager.getTransaction().commit();


        int nombre = stationRepository.getNombreVeloEndommageByStation(station_1);
        assertThat(nombre==1);


    }

    @Test
    void shouldgetNombreVeloOKByStation(){
        var velo_1 = new velo();
        var velo_2 = new velo();
        var velo_3 = new velo();

        velo_1.setEtat(Etat.OK);
        velo_2.setEtat(Etat.OK);
        velo_3.setEtat(Etat.HS);

        var bornette_1 = new Bornette(Etat.OK,velo_1,true);
        var bornette_2 = new Bornette(Etat.OK,velo_2,true);
        var bornette_3 = new Bornette(Etat.HS,velo_3,true);
        var bornette_4 = new Bornette();
        var bornette_5 = new Bornette();

        bornette_4.setEstPresent(false);

        List<Bornette> bornettes = new ArrayList();
        bornettes.add(bornette_1);
        bornettes.add(bornette_2);
        bornettes.add(bornette_3);
        bornettes.add(bornette_4);
        bornettes.add(bornette_5);


        var station_1 = new Station();
        station_1.setContient(bornettes);

        entityManager.getTransaction().begin();
        entityManager.persist(velo_1);
        entityManager.persist(velo_2);
        entityManager.persist(velo_3);

        entityManager.persist(bornette_1);
        entityManager.persist(bornette_2);
        entityManager.persist(bornette_3);
        entityManager.persist(bornette_4);
        entityManager.persist(bornette_5);
        entityManager.getTransaction().commit();


        int nombre = stationRepository.getNombreVeloOKByStation(station_1);
        assertThat(nombre==2);


    }


}
