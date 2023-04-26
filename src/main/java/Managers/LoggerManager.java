package Managers;

//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {
    //private static Logger logger;
    private static final Logger logger = LogManager.getLogger(LoggerManager.class);

    //public static void initLogger(){
    // logger = Logger.getLogger(LoggerManager.class.getName());
    public void myMehtod() {
        logger.debug("Aceasta este o inregistrare de nivel DEBUG");
        logger.info("Aceasta este o inregistrare de nivel INFO");
        logger.warn("Aceasta este o inregistrare de nivel WARNING");
        logger.error("Aceasta este o inregistrare de nivel ERROR");
    }
}
