package com.example.projetspring;

import com.example.projetspring.repository.RepositoryFactory;
import com.example.projetspring.repository.impl.*;
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
        bornette3.setEstPresent(true);
        bornette3.setEtat(Etat.OK);
        bornette4.setEstPresent(true);
        bornette4.setEtat(Etat.OK);
        bornette5.setEstPresent(true);
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
        bornette14.setEstPresent(true);
        bornette14.setEtat(Etat.OK);
        bornette15.setEstPresent(true);
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
            //System.out.println("(1) - Emprunter un velo ");
            //System.out.println("(2) - Rendre un velo");
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

                        System.out.println("> Etat station :");
                        System.out.println("    - adresse : "+stationSelected.getAdresse());
                        System.out.println("    - nombre de vélos disponibles : "+stationRepository.getNombreVeloOKByStation(stationSelected));
                        System.out.println("    - nombre de vélos endommagés : "+stationRepository.getNombreVeloEndommageByStation(stationSelected));
                        System.out.println("    - nombre de places vides : "+(stationSelected.getContient().size()-stationRepository.getNombreVeloParStation(stationSelected)));
                        System.out.println("    - statut : "+stationSelected.getStatus());
                        System.out.println(">");

                        if(stationSelected.getStatus().equals(VMOINS.toString())){
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - si vous RAMENEZ des vélos dans cette station vous aurez une PROMOTION");
                        }
                        else if(stationSelected.getStatus().equals(VPLUS.toString())){
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - si vous EMMENEZ des vélos dans d'AUTRES STATIONS vous aurez une PROMOTION");
                        }else{
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - pas de prime");
                        }                      
                        System.out.println(">");
                        
                        System.out.println("> Etat des bornes :");
                        stationSelected.getContient().forEach(bornette -> {
                                if(bornette.isEstPresent()) {
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
                        System.out.println(">");
                        System.out.println("> Que voulez-vous faire?");
                        System.out.println("(1) - Emprunter un ou plusieurs vélos");
                        System.out.println("(2) - Rendre un ou plusieurs vélos");
                        System.out.println("(3) - Signaler un vélo");
                        System.out.println("(4) - Quitter");
                        System.out.println("------------------------------------------");
                        reponse2 = scanner.next();

                        switch (reponse2) {
                            // Emprunter
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
                                    int compteur_erreur = 1 ;
                                    while(abonneSelected == null){
                                        System.out.println("Pas le bon numéro de client , ressayer svp ");
                                        System.out.println("Nombre de tentatives "+compteur_erreur);
                                         numClient = scanner.nextLong();
                                         abonneSelected = abonneRepository.findById(numClient);
                                         if(compteur_erreur==3){

                                         }
                                         compteur_erreur++;
                                    }
                                    System.out.println("> Connexion réussite");
                                    System.out.println("Bonjour "+abonneSelected.getPrenom()+" "+abonneSelected.getNom());
                                    // Verifie si y a des velo dispo
                                    if(stationRepository.getNombreVeloOKByStation(stationSelected)!=0) {
                                        // Affichage vélos dispo
                                        System.out.println("> Voici les vélos disponibles : ");
                                        stationSelected.getContient().forEach(bornette -> {

                                                    if ( (bornette.getPropose()!=null) &&(bornette.getEtat().equals(Etat.OK) && bornette.isEstPresent())&&((bornette.getPropose().getEtat() == Etat.OK))) {
                                                        System.out.println("(" + bornette.getPropose().getNumeroVelo() + ")  - vélo " + bornette.getPropose().getModele() + " (à la bornette n°" + bornette.getNumeroBorn() + ")");
                                                    }
                                                }
                                        );

                                        //demander quel velo il veut
                                        System.out.println("> Entrez le numero du velo : ");
                                        long numVelo = scanner.nextInt();
                                        Velo veloSelected = veloRepository.findById(numVelo);
                                        Bornette bornetteVeloLoue = bornetteRepository.findByIdVelo(numVelo);
                                        bornetteVeloLoue.setPropose(null);
                                        bornetteRepository.saveBornette(bornetteVeloLoue);

                                        // Ajout location dans la bd
                                        Location location = new Location();
                                        if(stationSelected.getStatus().equals(VPLUS)){
                                            System.out.println("> Vous serez deduis de 10% lors du trajet");
                                            location.setPrime(true);
                                        }
                                        Date today = Calendar.getInstance().getTime();
                                        location.setDateLocation(today);
                                        veloSelected.setLocation(location);
                                        abonneSelected.setLoue(location);
                                        locationRepository.saveLocation(location);
                                        System.out.println("> Vélo loué");
                                }
                                else{
                                    System.out.println("> Aucun vélo disponible : ");
                                }}

                                //////////////////////
                                /// Cas non abonné //
                                ////////////////////
                                else if(repAbonnement.equals("non")) {
                                    // Demande num CB
                                    System.out.println("> Veuillez saisir le numero de votre CB :");
                                    int numCarte = scanner.nextInt();

                                    // Cree un nonAbonne
                                    Client nonAbonneSelected = new NonAbonne(numCarte);
                                    System.out.println("> Carte enregistrée");

                                    // Verifie si y a des velo dispo
                                    if(stationRepository.getNombreVeloOKByStation(stationSelected)!=0) {
                                        // Affichage vélos dispo
                                        System.out.println("> Voici les vélos disponibles : ");
                                        stationSelected.getContient().forEach(bornette -> {
                                                    if ((bornette.getEtat().equals(Etat.OK) && bornette.isEstPresent())&&((bornette.getPropose().getEtat() == Etat.OK))) {
                                                        System.out.println("(" + bornette.getPropose().getNumeroVelo() + ")  - vélo " + bornette.getPropose().getModele() + " (à la bornette n°" + bornette.getNumeroBorn() + ")");
                                                    }
                                                }
                                        );

                                        //demander quel velos il veut
                                        System.out.println("> Entrez le numero du velo : ");
                                        long numVelo = scanner.nextInt();
                                        Velo veloSelected = veloRepository.findById(numVelo);
                                        Bornette bornetteVeloLoue = bornetteRepository.findByIdVelo(numVelo);
                                        bornetteVeloLoue.setPropose(null);
                                        bornetteRepository.saveBornette(bornetteVeloLoue);
                                        System.out.println("Retenez votre code pour rendre le vélo à la fin : "+nonAbonneSelected.getCodeSecret()) ;
                                        // Ajout location dans la bd
                                        Location location = new Location();
                                        Date today = Calendar.getInstance().getTime();
                                        location.setDateLocation(today);
                                        veloSelected.setLocation(location);
                                        nonAbonneSelected.setLoue(location);
                                        locationRepository.saveLocation(location);
                                        System.out.println("> Vélo loué");
                                    }
                                    else{
                                        System.out.println("> Aucun vélo disponible : ");
                                    }

                                    // Maj du statut de la station après location
                                    //if(stationRepository.getNombreVeloOKByStation(stationSelected)>=stationRepository.)

                                }
                                else{
                                    System.out.println("> Erreur identification ");
                                }
                                break;

                            // Rendre Velo emprunter
                            case "2":

                                // - verifie qu'il ya de la place  dans la sation
                                // - on lui demande à quelle borne il veut ranger son vélo
                                // - on demande le code secret
                                // - vérifie si abonné
                                //          - si abonné on fait la réduction de 30%
                                //          - on vérifie si le statut de la station est VMOIS, alors prime 10%

                                    //


                                System.out.println("\n> Rendre \n");
                                System.out.println("Introduisez le numéro de station où vous vous situez");
                                boolean prime = false ; //Si statut Vmoins alors prime = true

                                long codeStation = scanner.nextInt();
                                var Station = stationRepository.findById(codeStation);
                                if(stationRepository.getNombreVeloParStation(Station) == Station.getContient().size()){
                                    System.out.println("La station est pleine , vous pouvez pas rendre le vélo ici");
                                }

                                else if(Station.getStatus()== VMOINS){
                                    System.out.println("Vous avez gagnez une prime");
                                    prime=true;
                                }
                                //TODO calculer prime + rendu velo avec maj bornette place vide diminuer et dispo ajouter
                                System.out.println("> Veuillez saisir votre code secret :");

                                long codeClient = scanner.nextInt();
                                List<Location> locs = clientRepository.findLocationByClient(codeClient);
                                for( Location l : locs) {
                                    System.out.println(l.toString());
                                }
                                System.out.println("> Veuillez choisir la location que vous voulez deposer : ");
                                long idLoc = scanner.nextInt();
                                Location locationSelected = locationRepository.findById(idLoc);
                                Date now = Calendar.getInstance().getTime();
                                locationSelected.setDateRendu(now);
                                if(prime){
                                System.out.println("Vous dever payer "+locationSelected.getPrixLoc()*0.7*0.9 );
                                }
                                System.out.println("> Vous avez payé :"+locationSelected.getPrixLoc());

                                //save location dans la bd
                                locationRepository.saveLocation(locationSelected);

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
                                        velo.setEtat(Etat.HS);
                                        System.out.println("> Etat vélo modifié");
                                        veloRepository.saveVelo(velo);
                                        break;
                                
                                    case "HS":
                                        velo.setEtat(Etat.OK);
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
                    String adresse = scanner.nextLine();
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
                    Abonne abonneRegistered = new Abonne(numeroCB);

                    //set les infos dans le nouvel objet abo
                    abonneRegistered.setNom(nom);
                    abonneRegistered.setPrenom(prenom);
                    abonneRegistered.setAdresse(adresse);
                    abonneRegistered.setSexe(sexe);
                    abonneRegistered.setDateNaissance(dateNais);
                    abonneRegistered.setDateAbonnement(todaysDate);
                    
                    //save l'abonné
                    abonneRepository.saveAbonne(abonneRegistered);

                    //cree un nouveau client
                        //long codeSecret = abonneRegistered.getCodeSecret();
                        //Client clientRegistered = new Abonne();
                        //clientRegistered.setNumeroCB(numeroCB);
                        //clientRepository.saveClient(clientRegistered);
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

