package com.example.projetspring;

import com.example.projetspring.repository.RepositoryFactory;
import com.example.projetspring.repository.impl.StationRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static com.example.projetspring.Statut.VPLUS;

@SpringBootApplication
public class ProjetSpringApplication {



    public static void main(String[] args) throws IOException {

        SpringApplication.run(ProjetSpringApplication.class, args);

        EntityManager entityManager;
        RepositoryFactory daoFactory = new RepositoryFactory();
        entityManager = Persistence.createEntityManagerFactory("Main")
                .createEntityManager();
//insertion des données dans la base de données
        final var station = new Station();
        station.setStatus(VPLUS);
        station.setAdresse("Rue de bonheur");

        entityManager.getTransaction().begin();
        entityManager.persist(station);
        entityManager.getTransaction().commit();
        entityManager.detach(station);


        LocalDate todaysDate = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        String reponse1;
        //lancement MENU INTERFACE
        boolean d=true;
        while(d){
            System.out.print("----------------------------------------");
            System.out.print("Bonjour, vous êtes sur le MENU PRINCIPAL");
            System.out.println("Nous sommes le "+todaysDate);
            System.out.println("\n\t\t\t\t----MENU PRINCIPAL----");
            System.out.println("\n\t\t\t\tQue voulez-vous faire?");
            System.out.println("(1) - Entrer dans une station ");
            System.out.println("(2) - Voir l'état de toutes les stations");
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
                    System.out.println(T_station.getAdresse());
                case "2":
                    //- voir des infos sur toutes les stations (nb vélos dans chaque station, le nombre de vélos endommagés, et le nombre de places libres)

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


