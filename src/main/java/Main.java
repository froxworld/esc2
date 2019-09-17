import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


        }


    }
