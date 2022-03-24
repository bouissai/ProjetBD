package com.example.projetspring;

import com.example.projetspring.repository.RepositoryFactory;
import com.example.projetspring.repository.impl.ClientRepositoryImpl;
import com.example.projetspring.repository.impl.LocationRepositoryImpl;
import com.example.projetspring.repository.impl.StationRepositoryImpl;
import com.example.projetspring.repository.impl.VeloRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static com.example.projetspring.Statut.*;

@SpringBootApplication
public class ProjetSpringApplication {



    public static void main(String[] args) throws IOException {

        SpringApplication.run(ProjetSpringApplication.class, args);

        EntityManager entityManager;
        RepositoryFactory daoFactory = new RepositoryFactory();
        entityManager = Persistence.createEntityManagerFactory("Main")
                .createEntityManager();
        //instantiation des objets
        final var station1 = new Station();
        final var station2 = new Station();
        final var station3 = new Station();
        final var station4 = new Station();
        final var station5 = new Station();

        //initialisation des objets
        station1.setStatus(VPLUS);
        station1.setAdresse("Rue de bonheur");

        station2.setStatus(VMOINS);
        station2.setAdresse("Rue maréchal foch ");

        station3.setStatus(VPLUS);
        station3.setAdresse("Rue de chimie");

        station4.setStatus(VNUL);
        station4.setAdresse("Rue de commerce");

        station5.setStatus(VNUL);
        station5.setAdresse("Rue condillac");
//bornette
        final var bornette1=new Bornette();
        bornette1.setEstPresent(true);
        bornette1.setEtat(Etat.OK);
        final var bornette2=new Bornette();
        bornette2.setEstPresent(true);
        bornette2.setEtat(Etat.OK);
        final var bornette3=new Bornette();
        final var bornette4=new Bornette();
        final var bornette5=new Bornette();




        //vélos
        Velo velo1=new Velo();
        Velo velo2=new Velo();
        Velo velo3=new Velo();
        Velo velo4=new Velo();



        velo1.setModele(Marque.VTT);
        velo1.setEtat(Etat.OK);

//velo1.setDateMisesEnService(15/03/2022);

        velo2.setModele(Marque.BTWIB);
        velo2.setEtat(Etat.OK);

        velo3.setModele(Marque.LOOK);
        velo3.setEtat(Etat.HS);

        velo4.setModele(Marque.PEUGEOT);
        velo4.setEtat(Etat.OK);

        //sauvegarde dans la BD
        entityManager.getTransaction().begin();
        entityManager.persist(velo1);
        entityManager.getTransaction().commit();
        entityManager.detach(velo1);
        entityManager.getTransaction().begin();
        entityManager.persist(velo2);
        entityManager.getTransaction().commit();
        entityManager.detach(velo2);

        // bornettes -> velos
        bornette1.setPropose(velo1);
        bornette2.setPropose(velo2);

        //sauvegarde dans la BD
        entityManager.getTransaction().begin();
        entityManager.persist(bornette1);
        entityManager.getTransaction().commit();
        entityManager.detach(bornette1);
        entityManager.getTransaction().begin();
        entityManager.persist(bornette2);
        entityManager.getTransaction().commit();
        entityManager.detach(bornette2);

        // ajouter les bornettes dans une station
        List<Bornette> bornettes = new ArrayList<Bornette>();
        bornettes.add(bornette1);
        bornettes.add(bornette2);
        station1.setContient(bornettes);




        //sauvegarde dans la BD
        entityManager.getTransaction().begin();
        entityManager.persist(station1);
        entityManager.getTransaction().commit();
        entityManager.detach(station1);

        //repositpries

        VeloRepositoryImpl veloRepository = (VeloRepositoryImpl) daoFactory.newVeloRepository(entityManager);
        ClientRepositoryImpl clientRepository = (ClientRepositoryImpl) daoFactory.newClientRepository(entityManager);
        LocationRepositoryImpl locationRepository = (LocationRepositoryImpl) daoFactory.newLocationRepository(entityManager);

        //lancement MENU INTERFACE
        LocalDate todaysDate = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        String reponse1;
        boolean d=true;
        while(d){
            System.out.print("----------------------------------------");
            System.out.print("Bonjour, vous êtes sur le MENU PRINCIPAL");
            System.out.println("Nous sommes le "+todaysDate);
            System.out.println("\n\t\t\t\t----MENU PRINCIPAL----");
            System.out.println("\n\t\t\t\tQue voulez-vous faire?");
            System.out.println("(1) - Emprunter un velo ");
            System.out.println("(2) - Rendre un velo");
            System.out.println("(3) - S'abonner");
            System.out.println("(4) - Quitter");

            reponse1 = scanner.next();

            switch(reponse1){
                case "1":
                    //- demander dans quelle station il est?
                    System.out.print("Dans quelle station êtes vous ? \n");
                    long n = scanner.nextInt();
                    StationRepositoryImpl stationRepository= (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);
                    var T_station = stationRepository.findById(n);
                    System.out.println(T_station.toString());

                    System.out.println(" Veuillez choisir un velo : ");
                    long numVelo = scanner.nextInt();

                    System.out.println("Veuillez saisir le numero de votre CB :");
                    int numCarte = scanner.nextInt();

                    Client na1 = new NonAbonne();
                    na1.setNumeroCB(numCarte);
                    clientRepository.clientLoueUnVelo(na1, veloRepository.findById(numVelo));
                    entityManager.getTransaction().begin();
                    entityManager.persist(na1);
                    entityManager.getTransaction().commit();
                    entityManager.detach(na1);

                case "2":
                    System.out.println("Veuillez saisir votre code secret :");
                    long codeClient = scanner.nextInt();
                    List<Location> locs = clientRepository.findLocationByClient(codeClient);
                    for( Location l : locs) {
                        System.out.println(l.toString());
                    }
                    System.out.println("Veuillez choisir la location que vous voulez deposer : ");
                    long idLoc = scanner.nextInt();
                    Location veloADeposer = locationRepository.findById(idLoc);
                    Date now = Calendar.getInstance().getTime();
                    veloADeposer.setDateRendu(now);
                    entityManager.getTransaction().begin();
                    entityManager.persist(veloADeposer);
                    entityManager.getTransaction().commit();
                    entityManager.detach(veloADeposer);


                case "3":
                    //- s'abonner?

                case "4":
                    //- quitter
                    d=false;
                    //reponse1.close();

                default:
                    //- on recommence
            }





            //Après avoir noté sa station

            //- voir des infos sur la station (nb vélos , le nombre de vélos endommagés, et le nombre de places libres)
            // - Emprunter un ou plusieurs vélo
            // - Connexion Client ou non
            // si abonné, propose missions VPLUS/VMOINS/VNUL
            // - choisi sa borne/velo?
            // Signale si client abonné qui prend son vélo s'il bénéficie d'une remise Vplus pour son prochain trajet
            // - Donner l'état du velo en panne ()

            // Rendre un velo loué
            // - Entrez code secret
            // - Entrer le numero de station (et voir si  station = vide)
            // - Donner l'état du velo en panne (HS ou OK)
            // - Signale si client abonné qui rend son vélo s'il bénéficie d'une remise Vplus pour son prochain trajet
            //  => Le client est débité du temps de location

            //- quitter
        }
    }

}


