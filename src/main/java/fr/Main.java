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
import java.util.Calendar;
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
            Utilisateur grimpeur1 = creationUtilisateur("fa", "auxietre");
            entityManager.persist(grimpeur1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();


    }

    public static Utilisateur creationUtilisateur(String nom, String prenom) {
        Utilisateur grimpeur1 = new Utilisateur();
        grimpeur1.setPrenom("fa");
        grimpeur1.setNom("auxietre");
        //pattern builder
        LocalDate date = LocalDate.of(1972, Month.SEPTEMBER, 18);

        Date naissance = Date.valueOf(date);


        grimpeur1.setDate_de_naissance(naissance);
        return grimpeur1;
    }
}
