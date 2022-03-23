package com.example.projetspring;

import com.example.projetspring.repository.RepositoryFactory;
import com.example.projetspring.repository.impl.StationRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.ui.Model;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static com.example.projetspring.Statut.*;

@SpringBootApplication
public class ProjetSpringApplication {



    public static void main(String[] args) throws IOException {


        //connexion à la BD
        SpringApplication.run(ProjetSpringApplication.class, args);

        EntityManager entityManager;
        RepositoryFactory daoFactory = new RepositoryFactory();
        entityManager = Persistence.createEntityManagerFactory("Main").createEntityManager();


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
        final var bornette2=new Bornette();
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
        entityManager.persist(station1);
        entityManager.getTransaction().commit();
        entityManager.detach(station1);


        //lancement MENU INTERFACE
        LocalDate todaysDate = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        String reponse1;
        boolean d=true;

        while(d){
            System.out.print("----------------------------------------");
            System.out.print("Bonjour, vous êtes sur le MENU PRINCIPAL ");
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
                    StationRepositoryImpl stationRepository= (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);

                    //affiche les stations dispo
                    System.out.print("\nVoici les stations disponibles : \n");
                    var stations = stationRepository.getAll();
                    stations.forEach(station -> System.out.print("("+station.getId()+") - "+station.getAdresse()+" "+station.getStatut()+"\n"));

                    //- demander dans quelle station il est?
                    System.out.print("\nDans quelle station êtes vous ? \n");
                    long n = scanner.nextInt();

                    var stationSelected = stationRepository.findById(n);

                    if(n==stationSelected.getId()){

                        //Après avoir noté sa station
                        System.out.println(stationSelected.getAdresse());

                        String reponse2;
                        boolean d2=true;

                        while(d2){

                            //affichage info station entrée
                            System.out.print("----------------------------------------");
                            System.out.print("vous êtes sur le MENU de la STATION \n");
                            System.out.println("Nous sommes le "+todaysDate);
                            System.out.println("\n\t\t\t\t----Station "+stationSelected.getId()+"----");
                            System.out.println("\nEtat station :");
                            System.out.println("    - adresse : "+stationSelected.getAdresse());
                            System.out.println("    - statut : "+stationSelected.getStatut());
                            System.out.println("    - nombre de vélos disponibles : "+stationRepository.getNombreVeloOKByStation(stationSelected));
                            System.out.println("    - nombre de vélos endommagés : "+stationRepository.getNombreVeloEndommageByStation(stationSelected));
                            System.out.println("    - nombre de places vides : "+(stationSelected.getContient().size()-stationRepository.getNombreVeloParStation(stationSelected)));

                            //affichage info bornes
                            System.out.println("\nEtat des bornes :");
                            stationSelected.getContient().forEach(bornette -> {
                                        if(bornette.isEstPresent()) {
                                            if(bornette.getPropose().getEtat()==Etat.OK){
                                                System.out.println("    - B n°"+bornette.getNumeroBorn()+" | etat : "+bornette.getEtat()+" | place : vélo "+ bornette.getPropose().getModele()+" disponible");
                                            }else {
                                                System.out.println("    - B n°"+bornette.getNumeroBorn()+" | etat : "+bornette.getEtat()+" | place : vélo "+ bornette.getPropose().getModele()+" en panne");
                                            }
                                        }else {
                                            System.out.println("    - B n°" + bornette.getNumeroBorn() + " | etat : " + bornette.getEtat() + " | place : vide ");
                                        }
                                    }
                            );

                            System.out.println("\n\t\t\t\t----MENU Station----");
                            System.out.println("\n\t\t\t\tQue voulez-vous faire?");
                            //System.out.println("(1) - Voir les informations de la station ");
                            System.out.println("(1) - Emprunter un/des vélos");
                            System.out.println("(2) - Rendre un/des vélos");
                            System.out.println("(3) - Signaler un vélo");
                            System.out.println("(4) - Quitter");

                            reponse2 = scanner.next();

                            switch (reponse2){

                                // - Emprunter un ou plusieurs vélo
                                case "1":

                                    break;
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

                            }
                        }
                    }else{
                        System.out.println("La station "+n+" n'existe pas\n\n");
                    }
                    break;
                case "2":
                    //- voir des infos sur toutes les stations (nb vélos dans chaque station, le nombre de vélos endommagés, et le nombre de places libres)
                    break;
                case "3":
                    //- s'abonner?
                    break;
                case "4":
                    //- quitter
                    d=false;
                    //reponse1.close();
                    break;
                default:
                    //- on recommence
            }
        }
    }

}


