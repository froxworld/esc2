package fr;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        //ATTENTION METTRE LE FICHIER LOG4J.properties à la racine de resources
        BasicConfigurator.configure();

        //exemple de log dans diiférents niveau de log
        logger.info("Hello World");
        logger.info("Entering application.");
        logger.warn("Exiting application.");
        logger.error("error");


        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        // cree un objet qui est en attente d'etre placé dans la base de donnée


        //creation d'une transaction pour tout mettre en base de donnée
        EntityTransaction tx = entityManager.getTransaction();

        tx.begin();
        try {
            Utilisateur grimpeur1 = creationUtilisateur("auxietre", "francois", 1972, 9, 18);
            Utilisateur grimpeur2 = creationUtilisateur("weyl", "adrien", 1998, 1, 18);


            if (grimpeur1 != null && grimpeur2 != null) {
                entityManager.persist(grimpeur1);
                entityManager.persist(grimpeur2);
                listerUtilisateur(entityManager, logger);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();


    }

    public static Utilisateur creationUtilisateur(String nom, String prenom, int annee, int mois, int jour) {
        Utilisateur grimpeur = new Utilisateur();
        grimpeur.setPrenom(prenom);
        grimpeur.setNom(nom);
        //pattern builder
        LocalDate date = LocalDate.of(annee, mois, jour);
        Date naissance = Date.valueOf(date);
        grimpeur.setDate_de_naissance(naissance);
        return grimpeur;
    }

    //demande a olivier si existe un pattern ou un moeyn plus approprie

    /**
     * methode qui donne la liste des utilisateur de la base hsql
     *
     * @param entityManager
     * @param logger
     * @return la liste des grimpeurs
     */
    public static List<Utilisateur> listerUtilisateur(EntityManager entityManager, Logger logger) {
        List<Utilisateur> liste = entityManager.createNativeQuery("select * from UTILISATEUR", Utilisateur.class)
                .getResultList();
        logger.info("nombre d'utilisateur:" + liste.size());
        for (Utilisateur utilisateur : liste) {
            //System.out.println("grimpeur: " + utilisateur);
            logger.info(utilisateur.toString());
        }
        return liste;
    }
}
