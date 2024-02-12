package utility;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class generateLog {
      public static Logger logger;
    public static void log(String logLevel, String message){
         logger = (Logger) LogManager.getLogger();

        logger.log(Level.valueOf(logLevel), message);
    }
}
