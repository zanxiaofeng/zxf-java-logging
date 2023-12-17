package zxf.logging.legacy.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import zxf.logging.legacy.utils.FileUtils;

import java.io.IOException;
import java.util.UUID;

public class Log4jV1LoggingService {
    public void checkConfiguration() throws IOException {
        System.out.println("Checking Log4j V1 Configuration.............");
        System.out.println("1.0 Check config file setting.............");
        String configFileFromSysProp = System.getProperty("log4j.configuration");
        System.out.println("1.1 Check config file setting from system property log4j.configuration, as url path or classpath:, " + configFileFromSysProp);
        System.out.println("1.2 Check config file from classpath:log4j.xml, " + FileUtils.findClassPathFiles("log4j.xml"));
        System.out.println("1.3 Check config file from classpath:log4j.properties, " + FileUtils.findClassPathFiles("log4j.properties"));

        System.out.println("2.0 Check config class setting.............");
        String configClassFromSysProp = System.getProperty("log4j.configuratorClass");
        System.out.println("2.1 Check config class setting from system property log4j.configuratorClass, " + configClassFromSysProp);
        System.out.println("2.2 Log4j V1 will select config class by config file automatically");
    }

    public void testLogging(Boolean debug) {
        System.out.println(String.format("Testing Log4j V1 logging, debug=%s.............", debug));
        MDC.put("TraceId", UUID.randomUUID().toString());
        Logger logger = LogManager.getLogger(Log4jV1LoggingService.class);
        logger.trace("Log4j V1 TRACE message by " + logger.getClass().getName());
        logger.debug("Log4j V1 DEBUG message by " + logger.getClass().getName());
        logger.info("Log4j V1 INFO message by " + logger.getClass().getName());
        logger.warn("Log4j V1 WARN message by " + logger.getClass().getName());
        logger.error("Log4j V1 ERROR message by " + logger.getClass().getName());
        logger.fatal("Log4j V1 FATAL message by " + logger.getClass().getName());
    }
}
