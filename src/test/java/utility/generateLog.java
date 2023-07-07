package utility;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class generateLog {

    public static void log(String logLevel, String message){
        Logger log = (Logger) LogManager.getLogger(generateLog.class);
        log.log(Level.valueOf(logLevel), message);
    }
}
