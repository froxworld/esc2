package fr;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {

        /**
         * @param args
         */
        public static void main(String[] args) {

            Logger logger = LoggerFactory.getLogger(Main.class);
            //ATTENTION METTRE LE FICHIER LOG4J.properties à la racine de resources
            BasicConfigurator.configure();

            EntityManager entityManager = EntityManagerHelper.getEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();


            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
            entityTransaction.commit();


            entityManager.close();
            EntityManagerHelper.closeEntityManagerFactory();
            //factory.close();
        }


    }
