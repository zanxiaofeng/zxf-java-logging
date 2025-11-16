package zxf.logging.legacy.service;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JULLoggingService {

    public void checkConfiguration() {
        System.out.println("Checking JUL Configuration.............");
        System.out.println("1.0 Check config setting.............");
        String configClassFromSysProp = System.getProperty("java.util.logging.config.class");
        System.out.println("1.1 Check config class setting from system property java.util.logging.config.class, " + configClassFromSysProp);
        String configFileFromSysProp = System.getProperty("java.util.logging.config.file");
        System.out.println("1.2 Check config file setting from system property java.util.logging.config.file, as local path, " + configFileFromSysProp);
        String configFileDefault = Paths.get(System.getProperty("java.home"), "conf", "logging.properties").toString();
        System.out.println("1.3 Check default config file {java.home}/conf/logging.properties, as local path, " + configFileDefault);
    }

    public void testLogging(Boolean debug) {
        System.out.println(String.format("Testing JUL logging, debug=%s.............", debug));
        Logger logger = Logger.getLogger(JULLoggingService.class.getName());
        if (logger.isLoggable(Level.FINEST)) {
            logger.log(Level.FINEST, "JUL FINEST message by " + logger.getClass().getName(), new RuntimeException("JUL finest"));
        }
        logger.log(Level.FINER, "JUL FINER message by " + logger.getClass().getName());
        logger.log(Level.FINE, "JUL FINE message by " + logger.getClass().getName());
        logger.log(Level.INFO, "JUL INFO message by " + logger.getClass().getName());
        logger.log(Level.CONFIG, "JUL CONFIG message by " + logger.getClass().getName());
        logger.log(Level.WARNING, "JUL WARING message by " + logger.getClass().getName());
        logger.log(Level.SEVERE, "JUL SEVERE message by " + logger.getClass().getName(), new RuntimeException("JUL severe"));
    }

    public void testSetLevel() {
        System.out.println("Testing JUL set level.............");
        Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        System.out.println("JUL Logger Level(global): " + globalLogger.getLevel());
        Logger packageLogger = Logger.getLogger("zxf.logging.legacy");
        System.out.println("JUL Logger Level(zxf.logging.legacy): " + packageLogger.getLevel());
        Logger serviceLogger = Logger.getLogger(JULLoggingService.class.getName());
        System.out.println("JUL Logger Level(zxf.logging.legacy.service.JULLoggingService): " + serviceLogger.getLevel());

        System.out.println();
        serviceLogger.setLevel(Level.FINEST);
        System.out.println("JUL Logger Level after set(zxf.logging.legacy.service.JULLoggingService): " + serviceLogger.getLevel());
        globalLogger.setLevel(Level.FINEST);
        System.out.println("JUL Logger Level after set(global): " + globalLogger.getLevel());
        System.out.println("JUL Logger Level after set(zxf.logging.legacy): " + packageLogger.getLevel());
    }
}
