package com.example.projetspring;
import java.lang.Thread;
import com.example.projetspring.repository.RepositoryFactory;
import com.example.projetspring.repository.impl.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static com.example.projetspring.Statut.*;

@SpringBootApplication
public class ProjetSpringApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        //connexion à la BD
        SpringApplication.run(ProjetSpringApplication.class, args);

        EntityManager entityManager;
        RepositoryFactory daoFactory = new RepositoryFactory();
        entityManager = Persistence.createEntityManagerFactory("Main")
                                   .createEntityManager();

        //repositories
        VeloRepositoryImpl veloRepository = (VeloRepositoryImpl) daoFactory.newVeloRepository(entityManager);
        ClientRepositoryImpl clientRepository = (ClientRepositoryImpl) daoFactory.newClientRepository(entityManager);
        LocationRepositoryImpl locationRepository = (LocationRepositoryImpl) daoFactory.newLocationRepository(entityManager);
        NonAbonneRepositoryImpl nonAbonneRepository =(NonAbonneRepositoryImpl) daoFactory.newNonAbonneRepository(entityManager);
        AbonneRepositoryImpl abonneRepository = (AbonneRepositoryImpl) daoFactory.newAbonneRepository(entityManager);
        BornetteRepositoryImpl bornetteRepository = (BornetteRepositoryImpl) daoFactory.newBornetteRepository(entityManager);
        StationRepositoryImpl stationRepository = (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);

        //instantiation des objets
        final var station1 = new Station();
        final var station2 = new Station();
        final var station3 = new Station();
        final var station4 = new Station();


        //initialisation des objets
        station1.setStatus(VNUL);
        station1.setAdresse("Rue de bonheur");
        station2.setStatus(VNUL);
        station2.setAdresse("Rue maréchal foch ");
        station3.setStatus(VPLUS);
        station3.setAdresse("Rue de chimie");
        station4.setStatus(VMOINS);
        station4.setAdresse("Rue de chimie");

        //instantiation bornette
        final var bornette1=new Bornette();
        final var bornette2=new Bornette();
        final var bornette3=new Bornette();
        final var bornette4=new Bornette();
        final var bornette5=new Bornette();
        final var bornette6=new Bornette();
        final var bornette7=new Bornette();
        final var bornette8=new Bornette();
        final var bornette9=new Bornette();
        final var bornette10=new Bornette();
        final var bornette11=new Bornette();
        final var bornette12=new Bornette();
        final var bornette13=new Bornette();
        final var bornette14=new Bornette();
        final var bornette15=new Bornette();
        final var bornette16=new Bornette();
        final var bornette17=new Bornette();
        final var bornette18=new Bornette();
        final var bornette19=new Bornette();
        final var bornette20=new Bornette();

        //initialisation bornette
        bornette1.setEstPresent(true);
        bornette1.setEtat(Etat.OK);
        bornette2.setEstPresent(true);
        bornette2.setEtat(Etat.OK);
        bornette3.setEstPresent(false);
        bornette3.setEtat(Etat.OK);
        bornette4.setEstPresent(false);
        bornette4.setEtat(Etat.OK);
        bornette5.setEstPresent(false);
        bornette5.setEtat(Etat.OK);
        bornette6.setEstPresent(true);
        bornette6.setEtat(Etat.OK);
        bornette7.setEstPresent(true);
        bornette7.setEtat(Etat.OK);
        bornette8.setEstPresent(true);
        bornette8.setEtat(Etat.OK);
        bornette9.setEstPresent(true);
        bornette9.setEtat(Etat.OK);
        bornette10.setEstPresent(true);
        bornette10.setEtat(Etat.OK);
        bornette11.setEstPresent(true);
        bornette11.setEtat(Etat.OK);
        bornette12.setEstPresent(true);
        bornette12.setEtat(Etat.OK);
        bornette13.setEstPresent(true);
        bornette13.setEtat(Etat.OK);
        bornette14.setEstPresent(false);
        bornette14.setEtat(Etat.OK);
        bornette15.setEstPresent(false);
        bornette15.setEtat(Etat.OK);

        //instantiation velo
        Velo velo1=new Velo();
        Velo velo2=new Velo();
        Velo velo3=new Velo();
        Velo velo4=new Velo();
        Velo velo5=new Velo();
        Velo velo6=new Velo();
        Velo velo7=new Velo();
        Velo velo8=new Velo();
        Velo velo9=new Velo();
        Velo velo10=new Velo();
      /*  Velo velo11=new Velo();
        Velo velo12=new Velo();
        Velo velo13=new Velo();*/

        //initialisation velo
        velo1.setModele(Marque.VTT);
        velo1.setEtat(Etat.OK);
        velo2.setModele(Marque.BTWIB);
        velo2.setEtat(Etat.OK);
        velo3.setModele(Marque.LOOK);
        velo3.setEtat(Etat.OK);
        velo4.setModele(Marque.PEUGEOT);
        velo4.setEtat(Etat.OK);
        velo5.setModele(Marque.PEUGEOT);
        velo5.setEtat(Etat.OK);
        velo6.setModele(Marque.VTT);
        velo6.setEtat(Etat.OK);
        velo7.setModele(Marque.BTWIB);
        velo7.setEtat(Etat.OK);
        velo8.setModele(Marque.LOOK);
        velo8.setEtat(Etat.OK);
        velo9.setModele(Marque.PEUGEOT);
        velo9.setEtat(Etat.OK);
        velo10.setModele(Marque.PEUGEOT);
        velo10.setEtat(Etat.OK);
     /*   velo11.setModele(Marque.VTT);
        velo11.setEtat(Etat.OK);
        velo12.setModele(Marque.PEUGEOT);
        velo12.setEtat(Etat.OK);
        velo13.setModele(Marque.PEUGEOT);
        velo13.setEtat(Etat.OK);*/

        //sauvegarde velo dans la BD
        veloRepository.saveVelo(velo1);
        veloRepository.saveVelo(velo2);
        veloRepository.saveVelo(velo3);
        veloRepository.saveVelo(velo4);
        veloRepository.saveVelo(velo5);
        veloRepository.saveVelo(velo6);
        veloRepository.saveVelo(velo7);
        veloRepository.saveVelo(velo8);
        veloRepository.saveVelo(velo9);
        veloRepository.saveVelo(velo10);
       /* veloRepository.saveVelo(velo11);
        veloRepository.saveVelo(velo12);
        veloRepository.saveVelo(velo13);*/


        // bornettes -> velos
        bornette1.setPropose(velo1);
        bornette2.setPropose(velo2);

        bornette6.setPropose(velo3);
        bornette7.setPropose(velo4);
        bornette8.setPropose(velo5);
        bornette9.setPropose(velo6);
        bornette10.setPropose(velo7);
        bornette11.setPropose(velo8);
        bornette12.setPropose(velo9);
        bornette13.setPropose(velo10);
     /*   bornette3.setPropose(velo11);
        bornette4.setPropose(velo12);
        bornette5.setPropose(velo13);*/

        //sauvegarde bornette dans la BD
        bornetteRepository.saveBornette(bornette1);
        bornetteRepository.saveBornette(bornette2);
        bornetteRepository.saveBornette(bornette3);
        bornetteRepository.saveBornette(bornette4);
        bornetteRepository.saveBornette(bornette5);
        bornetteRepository.saveBornette(bornette6);
        bornetteRepository.saveBornette(bornette7);
        bornetteRepository.saveBornette(bornette8);
        bornetteRepository.saveBornette(bornette9);
        bornetteRepository.saveBornette(bornette10);
        bornetteRepository.saveBornette(bornette11);
        bornetteRepository.saveBornette(bornette12);
        bornetteRepository.saveBornette(bornette13);
        bornetteRepository.saveBornette(bornette14);
        bornetteRepository.saveBornette(bornette15);

        //ajouter les bornettes dans une station
        List<Bornette> bornettes1 = new ArrayList<Bornette>();
        bornettes1.add(bornette1);
        bornettes1.add(bornette2);
        bornettes1.add(bornette3);
        bornettes1.add(bornette4);
        bornettes1.add(bornette5);
        station1.setContient(bornettes1);

        List<Bornette> bornettes2 = new ArrayList<Bornette>();
        bornettes2.add(bornette6);
        bornettes2.add(bornette7);
        bornettes2.add(bornette8);
        bornettes2.add(bornette9);
        bornettes2.add(bornette10);
        station2.setContient(bornettes2);

        List<Bornette> bornettes3 = new ArrayList<Bornette>();
        bornettes3.add(bornette11);
        bornettes3.add(bornette12);
        bornettes3.add(bornette13);
        bornettes3.add(bornette14);
        bornettes3.add(bornette15);
        station3.setContient(bornettes3);

        //sauvegarde station dans la BD
        stationRepository.saveStation(station1);
        stationRepository.saveStation(station2);
        stationRepository.saveStation(station3);


        //création abonnés
        Abonne abonne_1 = new Abonne();
        abonne_1.setDateAbonnement(LocalDate.ofEpochDay(2016-07-17));
        abonne_1.setNom("Crivoi");
        abonne_1.setPrenom("Dmitrii");

        abonne_1.setAdresse("Rue des A");
        abonne_1.setSexe(Sexe.HOMME);
        abonneRepository.saveAbonne(abonne_1);

        Abonne abonne_2 = new Abonne();
        abonne_2.setDateAbonnement(LocalDate.ofEpochDay(2017-04-17));
        abonne_2.setNom("Guerbaa");
        abonne_2.setPrenom("Rayan");
        abonne_2.setAdresse("Rue de Vue");
        abonne_2.setSexe(Sexe.HOMME);
        abonneRepository.saveAbonne(abonne_2);

        Abonne abonne_3 = new Abonne();
        abonne_2.setDateAbonnement(LocalDate.ofEpochDay(2017-05-18));
        abonne_3.setNom("Ilyass");
        abonne_3.setAdresse("Rue de Chouette");
        abonne_3.setSexe(Sexe.HOMME);
        abonneRepository.saveAbonne(abonne_3);

        //lancement MENU INTERFACE
        LocalDate todaysDate = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        String reponse1;


        boolean d=true;
        while(d){

            System.out.println("------------------------------------------");
            System.out.println("> MENU PRINCIPAL");
            System.out.println("> Nous sommes le "+todaysDate);
            System.out.println("> ");
            System.out.println("> Que voulez-vous faire?");
            System.out.println("(1) - Entrer dans une station ");
            System.out.println("(2) - Voir l'état de toutes les stations");
            System.out.println("(3) - S'abonner");
            System.out.println("(4) - Quitter");
            System.out.println("------------------------------------------");

            reponse1 = scanner.next();

            switch(reponse1){
    
                //- demander dans quelle station il est?
                case "1":

                    //afficher toutes les stations dispo
                    var stations = stationRepository.getAll();
                    System.out.println("\n> Voici les stations disponibles : ");
                    stations.forEach(station -> System.out.print("("+station.getId()+") - "+station.getAdresse()+" "+station.getStatus()+"\n"));

                    //demander quelle station il est
                    System.out.println("\n> Dans quelle station êtes vous ? \n");
                    long n = scanner.nextInt();
                    stationRepository= (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);
                    var stationSelected = stationRepository.findById(n);

                    //lancement MENU STATION
                    String reponse2;
                    boolean d2=true;
                    while(d2){

                        //Dans le menu station on doit pouvoir :
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

                        //affichage info station entrée
                        System.out.println("----------------------------------------");
                        System.out.println("> MENU STATION \n");
                        System.out.println("> Nous sommes le "+todaysDate);
                        System.out.println(">");
                        Thread.sleep(1000);
                        System.out.println("> Etat station :");
                        System.out.println("    - adresse : "+stationSelected.getAdresse());
                        System.out.println("    - nombre de vélos disponibles : "+stationRepository.getNombreVeloOKByStation(stationSelected));
                        System.out.println("    - nombre de vélos endommagés : "+stationRepository.getNombreVeloEndommageByStation(stationSelected));
                        System.out.println("    - nombre de places vides : "+(stationRepository.getNombrePlaceLibreParBornette(stationSelected)));
                        System.out.println("    - statut : "+stationSelected.getStatus());
                        System.out.println(">");

                        if(stationSelected.getStatus().equals(VPLUS.toString())){
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - si vous RAMENEZ des vélos dans cette station vous aurez une PROMOTION");
                        }
                        else if(stationSelected.getStatus().equals(VMOINS.toString())){
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - si vous EMMENEZ des vélos dans d'AUTRES STATIONS vous aurez une PROMOTION");
                        }else{
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - pas de prime");
                        }                      
                        System.out.println(">");


                        //affiche etat des bornes
                        System.out.println("> Etat des bornes :");
                        stationSelected.getContient().forEach(bornette -> {
                                if(bornette.estPresent()) {
                                   if(bornette.getPropose()==null){
                                       System.out.println("    - B n°"+bornette.getNumeroBorn()+" Vide pour le moment");
                                       System.out.println("        - etat : "+bornette.getEtat());
                                   }
                                   else if(bornette.getPropose().getEtat().equals(Etat.OK) ){
                                        System.out.println("    - B n°"+bornette.getNumeroBorn());
                                        System.out.println("        - etat : "+bornette.getEtat());
                                        System.out.println("        - place : vélo "+ bornette.getPropose().getModele()+" disponible");
                                    }else {
                                        System.out.println("    - B n°"+bornette.getNumeroBorn());
                                        System.out.println("        - etat : "+bornette.getEtat());
                                        System.out.println("        - place : vélo "+ bornette.getPropose().getModele()+" en panne");
                                    }
                                }else {
                                    System.out.println("    - B n°" + bornette.getNumeroBorn());
                                    System.out.println("        - etat : "+ bornette.getEtat());
                                    System.out.println("        - place : vide ");
                                }
                            }
                        );

                        //affiche menu
                        System.out.println(">");
                        System.out.println("> Que voulez-vous faire?");
                        System.out.println("(1) - Emprunter un ou plusieurs vélos");
                        System.out.println("(2) - Rendre un ou plusieurs vélos");
                        System.out.println("(3) - Signaler un vélo");
                        System.out.println("(4) - Quitter");
                        System.out.println("------------------------------------------");
                        reponse2 = scanner.next();

                        switch (reponse2) {

                            ////////////////////////////
                            ///// MENNU EMPRUNTER /////
                            //////////////////////////
                            case "1":

                                System.out.println("\n> Emprunter \n");

                                // Demande si abonné
                                System.out.println("> Etes-vous abonné a notre service ?(oui/non) ");
                                String repAbonnement = scanner.next();

                                //////////////////////
                                /// Cas  abonné   ///
                                ////////////////////
                                if(repAbonnement.equals("oui")) {

                                    // Demande num abonne
                                    System.out.println("> Veuillez saisir votre numero client : Vous avez 3 tentatives");
                                    Long numClient = scanner.nextLong();
                                    Abonne abonneSelected = abonneRepository.findById(numClient);

                                    int compteur_erreur = 1;
                                    while (abonneSelected == null) {
                                        if (compteur_erreur == 3) {
                                            System.out.println("Vous avez depassé le nombre de tentatives ");
                                            Thread.sleep(3000);
                                            repAbonnement = "non";
                                            break;
                                        }
                                        System.out.println("> Pas le bon numéro de client , ressayer svp ");
                                        System.out.println("> Nombre de tentatives " + (3 - compteur_erreur));
                                        numClient = scanner.nextLong();
                                        abonneSelected = abonneRepository.findById(numClient);

                                        compteur_erreur++;
                                    }

                                    //Connexion n'est pas reusite
                                    if (compteur_erreur == 3) {
                                        break;
                                    }
                                    System.out.println("> Connexion réussite");
                                    System.out.println("> Bonjour " + abonneSelected.getPrenom() + " " + abonneSelected.getNom()+"\n");

                                    //verifie que l'abonne a pas deja des locations en cours
                                    List<Location> locs = clientRepository.findLocationByClient(numClient);
                                    if (locs.size()>0) {//abonneSelected.getLoue().size() > 0
                                        System.out.println("Vous pouvez pas emprunter de velos \n" +
                                                "Vous devez rendre votre location en cours");
                                        Thread.sleep(3000);
                                    }else{

                                        // Verifie si y a des velo dispo
                                        if (stationRepository.getNombreVeloOKByStation(stationSelected) != 0) {

                                            // Affichage vélos dispo
                                            System.out.println("> Voici les vélos disponibles : ");
                                            stationSelected.getContient().forEach(bornette -> {
                                                        if ((bornette.getPropose() != null) && (bornette.getEtat().equals(Etat.OK) && bornette.estPresent()) && ((bornette.getPropose().getEtat() == Etat.OK))) {
                                                            System.out.println("(" + bornette.getPropose().getNumeroVelo() + ")  - vélo " + bornette.getPropose().getModele() + " (à la bornette n°" + bornette.getNumeroBorn() + ")");
                                                        }
                                                    }

                                            );

                                            //demander quel velo il veut
                                            System.out.println("> Entrez le numero du velo : ");
                                            long numVelo = scanner.nextInt();
                                            Velo veloSelected = veloRepository.findById(numVelo);


                                            //demande etat velo
                                            System.out.println("> Veuillez informer l'etat du vélo (OK/HS):");
                                            String etatVelo = scanner.next();

                                            switch (etatVelo) {
                                                case "OK":
                                                    veloSelected.setEtat(Etat.OK);
                                                    System.out.println("> Etat vélo modifié");
                                                    veloRepository.saveVelo(veloSelected);


                                                    Bornette bornetteVeloLoue = bornetteRepository.findByIdVelo(numVelo);
                                                    bornetteVeloLoue.setPropose(null);
                                                    bornetteRepository.saveBornette(bornetteVeloLoue);

                                                    // Ajout location dans la bd
                                                    Location location = new Location();

                                                    //On set la prime si VPLUS
                                                    if (stationSelected.getStatus().equals(VMOINS)) {
                                                        System.out.println("Bravo vous contribuez à la mission de régulation citoyen");
                                                        System.out.println("> Vous serez deduis de 10% lors du trajet");
                                                        location.setPrime(true);
                                                    }

                                                    //MAJ de la BD
                                                    Date today = Calendar.getInstance().getTime();
                                                    location.setDateLocation(today);
                                                    location.setNumeroClient(abonneSelected.getCodeSecret());
                                                    veloSelected.setLocation(location);
                                                    abonneSelected.addLoue(location);
                                                    location.setVelos(veloSelected);
                                                    locationRepository.saveLocation(location);
                                                    abonneRepository.saveAbonne(abonneSelected);
                                                    System.out.println("> Vélo loué");
                                                    Thread.sleep(3000);
                                                    break;

                                                case "HS":
                                                    veloSelected.setEtat(Etat.HS);
                                                    System.out.println("> Annulation location veuillez empruntez un autre vélo");
                                                    veloRepository.saveVelo(veloSelected);
                                                    break;

                                                default:
                                                    System.out.println("> Annulation signalement");
                                                    break;
                                            }
                                        }
                                        else {
                                            System.out.println("> Aucun vélo disponible : ");
                                            Thread.sleep(3000);
                                        }
                                    }
                                }

                                //////////////////////
                                /// Cas non abonné //
                                ////////////////////
                                else if(repAbonnement.equals("non")) {

                                    // Demande num CB
                                    System.out.println("> Veuillez saisir le numero de votre CB :");
                                    int numCarte = scanner.nextInt();

                                    // Cree un nonAbonne
                                    Client nonAbonneSelected = new NonAbonne();
                                    nonAbonneSelected.setNumeroCB(numCarte);
                                    System.out.println("> Carte enregistrée");

                                    // Verifie si y a des velo dispo
                                    if(stationRepository.getNombreVeloOKByStation(stationSelected)!=0) {

                                        // Affichage vélos dispo
                                        System.out.println("> Voici les vélos disponibles : ");
                                        stationSelected.getContient().forEach(bornette -> {
                                                    if ((bornette.getPropose()!=null)&&(bornette.getEtat().equals(Etat.OK) && bornette.estPresent())&&((bornette.getPropose().getEtat() == Etat.OK))) {
                                                        System.out.println("(" + bornette.getPropose().getNumeroVelo() + ")  - vélo " + bornette.getPropose().getModele() +" (à la bornette n°" + bornette.getNumeroBorn() + ")");
                                                    }
                                                }
                                        );

                                        //demander quel velos il veut
                                        System.out.println("> Entrez le numero du velo : ");
                                        long numVelo = scanner.nextInt();

                                        //DEMANDE ETAT VELO
                                        System.out.println("> Veuillez informer l'etat du vélo (OK/HS):");
                                        String etatVelo = scanner.next();
                                        Velo velo = veloRepository.findById(numVelo);
                                        switch (etatVelo) {
                                            case "OK":
                                                velo.setEtat(Etat.OK);
                                                veloRepository.saveVelo(velo);


                                                Velo veloSelected = veloRepository.findById(numVelo);
                                                Bornette bornetteVeloLoue = bornetteRepository.findByIdVelo(numVelo);
                                                bornetteVeloLoue.setPropose(null);
                                                bornetteRepository.saveBornette(bornetteVeloLoue);

                                                // Ajout location dans la bd et MAJ BD
                                                Location location = new Location();
                                                location.setNumeroClient( nonAbonneSelected.getCodeSecret() );
                                                Date today = Calendar.getInstance().getTime();
                                                location.setDateLocation(today);
                                                veloSelected.setLocation(location);
                                                location.setVelos(veloSelected);
                                                nonAbonneSelected.addLoue(location);
                                                locationRepository.saveLocation(location);
                                                nonAbonneRepository.save( nonAbonneSelected, nonAbonneSelected.getNumeroCB());

                                                System.out.println("> Vélo loué");
                                                System.out.println("Retenez votre code pour rendre le vélo à la fin : "+nonAbonneSelected.getCodeSecret()) ;

                                                break;

                                            case "HS":
                                                velo.setEtat(Etat.HS);
                                                System.out.println("> Annulation location veuillez prendre un autre velo");
                                                veloRepository.saveVelo(velo);
                                                break;

                                            default:
                                                System.out.println("> Annulation signalement");
                                                break;
                                        }
                                        Thread.sleep(3000);
                                    }
                                    else{
                                        System.out.println("> Aucun vélo disponible : ");
                                        Thread.sleep(3000);
                                    }
                                    // Maj du statut de la station après location
                                    if(
                                            stationRepository.getNombrePlaceLibreParBornette(stationSelected)<=1) {
                                        stationSelected.setStatus(VMOINS);
                                    }
                                    else if(stationRepository.getNombrePlaceLibreParBornette(stationSelected)>=4){
                                        stationSelected.setStatus(VPLUS);
                                    }
                                    else {
                                        stationSelected.setStatus(VNUL);
                                    }

                                }
                                else{
                                    System.out.println("> Erreur identification ");
                                    Thread.sleep(3000);
                                }

                                d2=false;
                                break;

                            // Rendre Velo emprunter
                            case "2":
                                ////////////////////////////
                                ///// MENNU RENDU     /////
                                //////////////////////////

                                // - verifie qu'il ya de la place  dans la sation
                                // - on lui demande à quelle borne il veut ranger son vélo
                                // - on demande le code secret
                                // - vérifie si abonné
                                //          - si abonné on fait la réduction de 30%
                                //          - on vérifie si le statut de la station est VMOINS, alors prime 10%
                                System.out.println("\n> Rendre \n");

                                // - verifie qu'il ya de la place  dans la sation
                                if(stationRepository.getNombrePlaceLibreParBornette(stationSelected) == 0){
                                    System.out.println("La station est pleine , vous pouvez pas rendre le vélo ici");
                                }
                                else {
                                    //Demande Client son code secret
                                    System.out.println("> Veuillez saisir votre code secret :");
                                    long codeClient = scanner.nextInt();
                                    // Verification si client abonné ou non
                                    if(abonneRepository.findById(codeClient)!=null){
                                        Abonne clientEnCours = abonneRepository.findById(codeClient);
                                        ///// CAS ABONNE ////
                                        List<Location> location = new ArrayList<Location>();
                                        for (Location l: clientEnCours.getLoue()) {
                                            if(l.getDateRendu()==null){
                                                location.add(l);
                                            }
                                        }
                                        // Récupère location client
                                        //List<Location> locs = clientRepository.findLocationByClient(codeClient);
                                        // Si on le client n'a pas de location on le sort
                                        if(location.size()>0){
                                            int index = 0;
                                            //Afficher
                                            for (Location l :location) {
                                                System.out.println("("+index+") - Location N°"+l.getId()+" en cours : "+l.getVelos().get(0).getModele());
                                                index++;
                                            }
                                            System.out.println("> Choisisez une location que vous voulez rendre");
                                            int locationSelected = scanner.nextInt();


                                            for (Bornette b : stationSelected.getContient()) {
                                                if(!b.estPresent()){
                                                    System.out.println("(" + b.getNumeroBorn() + ")  - Borne libre ");
                                                }
                                            }
                                            System.out.println("> Choisisez une borne parmis les bornes ci-dessus");
                                            long borneSelected = scanner.nextLong();

                                            //DEMANDE ETAT VELO
                                            System.out.println("> Veuillez informer l'etat du vélo (OK/HS):");
                                            String etatVelo = scanner.next();
                                            Velo velo = veloRepository.findById(location.get(locationSelected).getVelos().get(0).getNumeroVelo());
                                            switch (etatVelo) {
                                                case "OK":
                                                    velo.setEtat(Etat.OK);
                                                    System.out.println("> Etat vélo modifié");
                                                    veloRepository.saveVelo(velo);
                                                    break;

                                                case "HS":
                                                    velo.setEtat(Etat.HS);
                                                    System.out.println("> Etat vélo modifié");
                                                    veloRepository.saveVelo(velo);
                                                    break;

                                                default:
                                                    System.out.println("> Annulation signalement");
                                                    break;
                                            }

                                            //Calcul du prix de la location
                                            Date now = new Date();
                                            var x = now;
                                            location.get(locationSelected).setDateRendu(x);
                                            double prixlocAbonne = location.get(locationSelected).getPrixLoc()*0.7;
                                            location.get(locationSelected).setPrixLoc(prixlocAbonne);

                                            // Si la location à une prime on active la reduction
                                            if((location.get(locationSelected).isPrime())||(stationSelected.getStatus().equals(VPLUS))){
                                                double prixReduc = location.get(locationSelected).getPrixLoc()*0.9;
                                                location.get(locationSelected).setPrixLoc(prixReduc);
                                                System.out.println("> Vous avez été deduis de 10% du prix intial grâce à vos missions de bon citoyens !");
                                            }

                                            //MAJ BORNETTE AVEC AJOUT VELO DANS LA BORNETTE CHOISIS
                                            Velo veloRendu = location.get(locationSelected).getVelos().get(0); // recupere velo emprunter
                                            Bornette bornetteRendu = bornetteRepository.findById(borneSelected);
                                            bornetteRendu.setPropose(veloRendu);
                                            bornetteRepository.saveBornette(bornetteRendu);
                                            // MAJ STATION BORNETTE PRESENTE
                                            if(stationRepository.getNombrePlaceLibreParBornette(stationSelected)<=1) {
                                                stationSelected.setStatus(VMOINS);
                                            }
                                            else if(stationRepository.getNombrePlaceLibreParBornette(stationSelected)>=4){
                                                stationSelected.setStatus(VPLUS);
                                            }
                                            else {
                                                stationSelected.setStatus(VNUL);
                                            }
                                            locationRepository.saveLocation(location.get(0)); // enrengistre dans la bd la date de rendu

                                            System.out.println("Voici le montant de votre location -> "+location.get(0).getPrixLoc());
                                            Thread.sleep(3000);
                                        }
                                        else{
                                            System.out.println("> Vous n'avez pas de location.\n> Sortie.");
                                        }
                                    }
                                    else if(clientRepository.findById(codeClient)!=null){
                                        //// CAS NON ABONNE ////
                                        NonAbonne clientEnCours = nonAbonneRepository.findById(codeClient);
                                        List<Location> location = new ArrayList<Location>();
                                        for (Location l: clientEnCours.getLoue()) {
                                            if(l.getDateRendu()==null){
                                                location.add(l);
                                            }
                                        }
                                        // Récupère location client
                                        //List<Location> locs = clientRepository.findLocationByClient(codeClient);
                                        for (Location l :location) {
                                            System.out.println("---> id location"+l.getId());
                                        }
                                        // Si on le client n'a pas de location on le sort
                                        if(location.size()>0){
                                            for (Bornette b : stationSelected.getContient()) {
                                                if(!b.estPresent()){
                                                    System.out.println("(" + b.getNumeroBorn() + ")  - Borne libre ");
                                                }
                                            }
                                            System.out.println("> Choisisez une borne parmis les bornes ci-dessus");
                                            long borneSelected = scanner.nextLong();


                                            //DEMANDE ETAT VELO
                                            System.out.println("> Veuillez informer l'etat du vélo (OK/HS):");
                                            String etatVelo = scanner.next();
                                            Velo velo = veloRepository.findById(location.get(0).getVelos().get(0).getNumeroVelo());
                                            switch (etatVelo) {
                                                case "OK":
                                                    velo.setEtat(Etat.OK);
                                                    System.out.println("> Etat vélo modifié");
                                                    veloRepository.saveVelo(velo);
                                                    break;

                                                case "HS":
                                                    velo.setEtat(Etat.HS);
                                                    System.out.println("> Etat vélo modifié");
                                                    veloRepository.saveVelo(velo);
                                                    break;

                                                default:
                                                    System.out.println("> Annulation signalement");
                                                    break;
                                            }


                                            //Calcul du prix de la location
                                            Date now = new Date();
                                            //default time zone
                                            var x = now;
                                            location.get(0).setDateRendu(x);
                                            //MAJ BORNETTE AVEC AJOUT VELO DANS LA BORNETTE CHOISIS
                                            Velo veloRendu = location.get(0).getVelos().get(0); // recupere velo emprunter
                                            Bornette bornetteRendu = bornetteRepository.findById(borneSelected);
                                            bornetteRendu.setPropose(veloRendu);
                                            bornetteRepository.saveBornette(bornetteRendu);
                                            // MAJ STATION BORNETTE PRESENTE
                                            if(stationRepository.getNombrePlaceLibreParBornette(stationSelected)<=1) {
                                                stationSelected.setStatus(VMOINS);
                                            }
                                            else if(stationRepository.getNombrePlaceLibreParBornette(stationSelected)>=4){
                                                stationSelected.setStatus(VPLUS);
                                            }
                                            else {
                                                stationSelected.setStatus(VNUL);
                                            }
                                            locationRepository.saveLocation(location.get(0)); // enrengistre dans la bd la date de rendu

                                            System.out.println("Voici le montant de votre location -> "+location.get(0).getPrixLoc());
                                            Thread.sleep(3000);
                                        }
                                        else{
                                            System.out.println("> Vous n'avez pas de location.\n> Sortie.");
                                            Thread.sleep(1000);
                                        }
                                    }
                                    else{
                                        System.out.println("> Code secret invalide");
                                        Thread.sleep(1000);
                                    }

                                }
                                d2=false;
                                break;
                        
                            //Signaler
                            case "3":
                                //demande numero velo
                                System.out.println("> Veuillez saisir le numéro du vélo :");
                                long idVelo = scanner.nextInt();
                                Velo velo = veloRepository.findById(idVelo);

                                //demande etat velo
                                System.out.println("> Veuillez informer l'etat du vélo (OK/HS):");
                                String etatVelo = scanner.next();

                                switch (etatVelo) {
                                    case "OK":
                                        velo.setEtat(Etat.OK);
                                        System.out.println("> Etat vélo modifié");
                                        veloRepository.saveVelo(velo);
                                        break;
                                
                                    case "HS":
                                        velo.setEtat(Etat.HS);
                                        System.out.println("> Etat vélo modifié");
                                        veloRepository.saveVelo(velo);
                                        break;

                                    default:
                                        System.out.println("> Annulation signalement");
                                        break;
                                }

                                break;
                            //Quitter
                            case "4":
                                d2=false;
                                break;

                            default:
                                break;
                        }
                    }
                    break;

                // Voir etat de toutes les stations
                case "2":
                    List<Station>  x = stationRepository.getAll();
                    int index2 = 1;
                    for (Station s : x) {

                        //affichage info station entrée
                        System.out.println("----------------------------------------");
                        System.out.println("> INFO STATION "+index2+"  \n");
                        index2++;
                        System.out.println(">");
                        Thread.sleep(1000);
                        System.out.println("> Etat station :");
                        System.out.println("    - adresse : "+s.getAdresse());
                        System.out.println("    - nombre de vélos disponibles : "+stationRepository.getNombreVeloOKByStation(s));
                        System.out.println("    - nombre de vélos endommagés : "+stationRepository.getNombreVeloEndommageByStation(s));
                        System.out.println("    - nombre de places vides : "+(stationRepository.getNombrePlaceLibreParBornette(s)));
                        System.out.println("    - statut : "+s.getStatus());
                        System.out.println(">");

                        if(s.getStatus().equals(VPLUS.toString())){
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - si vous RAMENEZ des vélos dans cette station vous aurez une PROMOTION");
                        }
                        else if(s.getStatus().equals(VMOINS.toString())){
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - si vous EMMENEZ des vélos dans d'AUTRES STATIONS vous aurez une PROMOTION");
                        }else{
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - pas de prime");
                        }
                        System.out.println(">");


                        //affiche etat des bornes
                        System.out.println("> Etat des bornes :");
                        s.getContient().forEach(bornette -> {
                                    if(bornette.estPresent()) {
                                        if(bornette.getPropose()==null){
                                            System.out.println("    - B n°"+bornette.getNumeroBorn()+" Vide pour le moment");
                                            System.out.println("        - etat : "+bornette.getEtat());
                                        }
                                        else if(bornette.getPropose().getEtat().equals(Etat.OK) ){
                                            System.out.println("    - B n°"+bornette.getNumeroBorn());
                                            System.out.println("        - etat : "+bornette.getEtat());
                                            System.out.println("        - place : vélo "+ bornette.getPropose().getModele()+" disponible");
                                        }else {
                                            System.out.println("    - B n°"+bornette.getNumeroBorn());
                                            System.out.println("        - etat : "+bornette.getEtat());
                                            System.out.println("        - place : vélo "+ bornette.getPropose().getModele()+" en panne");
                                        }
                                    }else {
                                        System.out.println("    - B n°" + bornette.getNumeroBorn());
                                        System.out.println("        - etat : "+ bornette.getEtat());
                                        System.out.println("        - place : vide ");
                                    }
                                }
                        );

                    }
                    break;

                // S'abonner
                case "3":
                    System.out.println("\n> Abonnement \n");
                    // Demande infos personnelles
                    System.out.println("> Veuillez saisir votre nom : ");
                    String nom = scanner.next();
                    System.out.println("> prenom :");
                    String prenom = scanner.next();
                    System.out.println("> adresse : ");
                    String adresse = scanner.next();
                    System.out.println("> date de naissance sous format yyyy-mm-dd");
                    String dateNaisToconvert  = scanner.next();
                    LocalDate dateNais = LocalDate.parse(dateNaisToconvert);
                    Sexe sexe;
                    System.out.println("> sexe (H/F) : ");
                    String rep = scanner.next();
                    if(rep=="H"){
                        sexe = Sexe.HOMME;
                    }else{
                        sexe = Sexe.FEMME;
                    }
                    System.out.println("> numéro de carte bancaire");
                    int numeroCB  = scanner.nextInt();

                    //cree un nouvel abo
                    Abonne abonneRegistered = new Abonne();
                    abonneRegistered.setNumeroCB(numeroCB);
                    //set les infos dans le nouvel objet abo
                    abonneRegistered.setNom(nom);
                    abonneRegistered.setPrenom(prenom);
                    abonneRegistered.setAdresse(adresse);
                    abonneRegistered.setSexe(sexe);
                    abonneRegistered.setDateNaissance(dateNais);
                    abonneRegistered.setDateAbonnement(todaysDate);
                    
                    //save l'abonné
                    abonneRepository.saveAbonne(abonneRegistered);

                    System.out.println("> Retenez bien votre n°client : "+ abonneRegistered.getCodeSecret());
                    Thread.sleep(5000);
                    break;

                case "4":
                    //- quitter
                    d=false;
                    //reponse1.close();
                    //reponse2.close();
                    break;

                default:
                    //- on recommence
                    break;
            }
        }
    }

}

