package zxf.logging.legacy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jV2LoggingService {
    public void execute() {
        Logger logger = LogManager.getLogger(Log4jV1LoggingService.class);
        logger.trace("Log4j V2 TRACE message by " + logger.getClass().getName());
        logger.debug("Log4j V2 DEBUG message by " + logger.getClass().getName());
        logger.info("Log4j V2 INFO message by " + logger.getClass().getName());
        logger.warn("Log4j V2 WARN message by " + logger.getClass().getName());
        logger.error("Log4j V2 ERROR message by " + logger.getClass().getName());
        logger.fatal("Log4j V2 FATAL message by " + logger.getClass().getName());
    }
}
