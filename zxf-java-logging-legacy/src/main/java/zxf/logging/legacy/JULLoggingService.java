package zxf.logging.legacy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JULLoggingService {
    private static Logger logger = Logger.getLogger(JULLoggingService.class.getName());

    public void execute() {
        logger.log(Level.FINEST, "JUL FINEST message");
        logger.log(Level.FINER, "JUL FINER message");
        logger.log(Level.FINE, "JUL FINE message");
        logger.log(Level.INFO, "JUL INFO message");
        logger.log(Level.CONFIG, "JUL CONFIG message");
        logger.log(Level.WARNING, "JUL WARING message");
        logger.log(Level.SEVERE, "JUL SEVERE message");
    }
}
