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


        //instantiation bornette
        final var bornette1=new Bornette();
        final var bornette2=new Bornette();
        final var bornette3=new Bornette();
        final var bornette4=new Bornette();
        final var bornette5=new Bornette();

        //initialisation bornette
        bornette1.setEstPresent(true);
        bornette1.setEtat(Etat.OK);
        bornette2.setEstPresent(true);
        bornette2.setEtat(Etat.OK);


        //instantiation velo
        Velo velo1=new Velo();
        Velo velo2=new Velo();
        Velo velo3=new Velo();
        Velo velo4=new Velo();

        //initialisation velo
        velo1.setModele(Marque.VTT);
        velo1.setEtat(Etat.OK);
        velo2.setModele(Marque.BTWIB);
        velo2.setEtat(Etat.OK);
        velo3.setModele(Marque.LOOK);
        velo3.setEtat(Etat.HS);
        velo4.setModele(Marque.PEUGEOT);
        velo4.setEtat(Etat.OK);


        //sauvegarde velo dans la BD
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

        //sauvegarde bornette dans la BD
        entityManager.getTransaction().begin();
        entityManager.persist(bornette1);
        entityManager.getTransaction().commit();
        entityManager.detach(bornette1);
        entityManager.getTransaction().begin();
        entityManager.persist(bornette2);
        entityManager.getTransaction().commit();
        entityManager.detach(bornette2);

        //ajouter les bornettes dans une station
        List<Bornette> bornettes = new ArrayList<Bornette>();
        bornettes.add(bornette1);
        bornettes.add(bornette2);
        station1.setContient(bornettes);

        //sauvegarde station dans la BD
        entityManager.getTransaction().begin();
        entityManager.persist(station1);
        entityManager.getTransaction().commit();
        entityManager.detach(station1);


        //repositpries
        VeloRepositoryImpl veloRepository = (VeloRepositoryImpl) daoFactory.newVeloRepository(entityManager);
        ClientRepositoryImpl clientRepository = (ClientRepositoryImpl) daoFactory.newClientRepository(entityManager);
        LocationRepositoryImpl locationRepository = (LocationRepositoryImpl) daoFactory.newLocationRepository(entityManager);
        NonAbonneRepositoryImpl nonAbonneRepository =(NonAbonneRepositoryImpl) daoFactory.newNonAbonneRepository(entityManager);
        AbonneRepositoryImpl abonneRepository = (AbonneRepositoryImpl) daoFactory.newAbonneRepository(entityManager);
        
        
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

                    StationRepositoryImpl stationRepository= (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);

                    //afficher toutes les stations dispo
                    var stations = stationRepository.getAll();
                    System.out.println("\n> Voici les stations disponibles : ");
                    stations.forEach(station -> System.out.print("("+station.getId()+") - "+station.getAdresse()+" "+station.getStatut()+"\n"));

                    //demander quelle station il est
                    System.out.println("\n> Dans quelle station êtes vous ? \n");
                    long n = scanner.nextInt();
                    stationRepository= (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);
                    var stationSelected = stationRepository.findById(n);
                    System.out.println("\n> Station : "+stationSelected.toString());



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
                        System.out.println("    - statut : "+stationSelected.getStatut());
                        System.out.println(">");

                        if(stationSelected.getStatut()==Statut.VMOINS.toString()){
                            System.out.println("> Pour les abonnées :");
                            System.out.println("    - si vous RAMENEZ des vélos dans cette station vous aurez une PROMOTION");
                        }
                        else if(stationSelected.getStatut()==Statut.VPLUS.toString()){
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
                                    if(bornette.getPropose().getEtat()==Etat.OK){
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

                            //Emprunter
                            case "1":
                                System.out.println("\n> Emprunter \n");
                                boolean d3=true;

                                //verifie si y a des velo disoi
                                if(stationRepository.getNombreVeloOKByStation(stationSelected)!=0){
                                    
                                    //affichage vélos dispo
                                    System.out.println("> Voici les vélos disponibles : ");
                                    stationSelected.getContient().forEach(bornette -> {
                                            if(bornette.getEtat().equals(Etat.OK) && bornette.isEstPresent()) {
                                                if(bornette.getPropose().getEtat()==Etat.OK){
                                                    System.out.println("("+bornette.getPropose().getNumeroVelo()+")  - vélo "+ bornette.getPropose().getModele()+" (à la bornette n°"+bornette.getNumeroBorn()+")");
                                                }
                                            }
                                        }
                                    );

                                    //demander quel velos il veut
                                    System.out.println("> Veuillez choisir un velo en entrant le numéro de la borne: ");
                                    long numVelo = scanner.nextInt();
                                    

                                    //demande si abonné
                                    System.out.println("> Etes-vous abonné a notre service ?(oui/non) ");
                                    String repAbonnement = scanner.next();

                                    //cas abonné
                                    if(repAbonnement.equals("oui")){

                                        //demande num abonne
                                        System.out.println("> Veuillez saisir votre numero client :");
                                        int numClient = scanner.nextInt();
                                        Abonne abonneSelected = abonneRepository.findById(numClient);
                                        System.out.println("> Connexion réussite");

                                        //ajoute location dans la bd
                                        clientRepository.clientLoueUnVelo(abonneSelected, veloRepository.findById(numVelo));
                                        entityManager.getTransaction().begin();
                                        entityManager.persist(abonneSelected);
                                        entityManager.getTransaction().commit();
                                        entityManager.detach(abonneSelected);
                                        System.out.println("> vélo loué");
                                    
                                    }

                                    //cas non abonné
                                    else if(repAbonnement.equals("non")) {

                                        //demande num CB
                                        System.out.println("> Veuillez saisir le numero de votre CB :");
                                        int numCarte = scanner.nextInt();

                                        //cree un nonAbonne
                                        Client nonAbonneSelected = new NonAbonne(numCarte);
                                        //nonAbonneSelected.setNumeroCB(numCarte);
                                        System.out.println("> Carte enregistrée");

                                        //ajoute location dans la bd
                                        clientRepository.clientLoueUnVelo(nonAbonneSelected, veloRepository.findById(numVelo));
                                        entityManager.getTransaction().begin();
                                        entityManager.persist(nonAbonneSelected);
                                        entityManager.getTransaction().commit();
                                        entityManager.detach(nonAbonneSelected);
                                        System.out.println("> vélo loué");

                                    }

                                    else{
                                        System.out.println("> Erreur identification ");

                                    }

                                }else{
                                    System.out.println("> Aucun vélo disponible : ");

                                }

                                break;


                            //Rendre
                            case "2":

                                System.out.println("\n> Rendre \n");
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


                //voir etat de toutes les stations
                case "2":
                    break;


                //S'abonner
                case "3":

                    System.out.println("\n> Abonnement \n");

                    //demande infos personnelles
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


