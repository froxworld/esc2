import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);
        //ATTENTION METTRE LE FICHIER LOG4J.properties à la racine de resources
        BasicConfigurator.configure();


        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();




        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }

}

