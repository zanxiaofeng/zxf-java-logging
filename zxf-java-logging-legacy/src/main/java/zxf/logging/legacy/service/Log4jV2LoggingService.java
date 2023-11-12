package zxf.logging.legacy.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jV2LoggingService {
    public void checkConfiguration() {
        System.out.println("Checking Log4j V2  Configuration.............");
//        System.out.println("1.0 Check config setting.............");
//        String configClassFromSysProp = System.getProperty("java.util.logging.config.class");
//        System.out.println("1.1 Check config class setting from system property java.util.logging.config.class, " + configClassFromSysProp);
//        String configFileFromSysProp = System.getProperty("java.util.logging.config.file");
//        System.out.println("1.2 Check config file setting from system property java.util.logging.config.file, " + configFileFromSysProp);
//        String configFileDefault = Paths.get(System.getProperty("java.home"), "conf", "logging.properties").toString();
//        System.out.println("1.3 Check default config file {java.home}/conf/logging.properties, " + configFileDefault);
    }

    public void testLogging() {
        System.out.println("Testing Log4j V2 logging.............");
        Logger logger = LogManager.getLogger(Log4jV2LoggingService.class);
        logger.trace("Log4j V2 TRACE message by " + logger.getClass().getName());
        logger.debug("Log4j V2 DEBUG message by " + logger.getClass().getName());
        logger.info("Log4j V2 INFO message by " + logger.getClass().getName());
        logger.warn("Log4j V2 WARN message by " + logger.getClass().getName());
        logger.error("Log4j V2 ERROR message by " + logger.getClass().getName());
        logger.fatal("Log4j V2 FATAL message by " + logger.getClass().getName());
    }
}
