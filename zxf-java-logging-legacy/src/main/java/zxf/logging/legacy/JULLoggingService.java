package zxf.logging.legacy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JULLoggingService {
    public void execute() {
        Logger logger = Logger.getLogger(JULLoggingService.class.getName());
        logger.log(Level.FINEST, "JUL FINEST message by " + logger.getClass().getName());
        logger.log(Level.FINER, "JUL FINER message by " + logger.getClass().getName());
        logger.log(Level.FINE, "JUL FINE message by " + logger.getClass().getName());
        logger.log(Level.INFO, "JUL INFO message by " + logger.getClass().getName());
        logger.log(Level.CONFIG, "JUL CONFIG message by " + logger.getClass().getName());
        logger.log(Level.WARNING, "JUL WARING message by " + logger.getClass().getName());
        logger.log(Level.SEVERE, "JUL SEVERE message by " + logger.getClass().getName());
    }
}
