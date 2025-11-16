package zxf.logging.legacy.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.ThreadContext;
import zxf.logging.legacy.utils.FileUtils;

import java.io.IOException;
import java.util.UUID;

public class Log4jV2LoggingService {
    public void checkConfiguration() throws IOException {
        System.out.println("Checking Log4j V2 Configuration.............");
        System.out.println("1.0 Check config setting.............");
        String debugFromSysProp = System.getProperty("log4j2.debug");
        String loggerContextFactoryFromSysProp = System.getProperty("log4j2.loggerContextFactory");
        String log4jContextSelectorFromSysProp = System.getProperty("Log4jContextSelector");
        String configurationFactoryFromSysProp = System.getProperty("log4j.configurationFactory");
        String configurationFileFromSysProp = System.getProperty("log4j.configurationFile");
        System.out.println("1.1 Check config from system property, log4j2.debug=" + debugFromSysProp);
        System.out.println("1.1 Check config from system property, log4j2.loggerContextFactory=" + loggerContextFactoryFromSysProp);
        System.out.println("1.1 Check config from system property, Log4jContextSelector=" + log4jContextSelectorFromSysProp);
        System.out.println("1.1 Check config from system property, log4j.configurationFactory=" + configurationFactoryFromSysProp);
        System.out.println("1.1 Check config from system property, log4j.configurationFile=" + configurationFileFromSysProp);
        System.out.println("1.2 Check config from classpath:log4j2.system.properties, " + FileUtils.findClassPathFiles("log4j2.system.properties"));
        System.out.println("1.3 Check config from classpath:log4j2.component.properties, " + FileUtils.findClassPathFiles("log4j2.component.properties"));
        System.out.println("1.4 Check config file classpath:log4j2.properties, " + FileUtils.findClassPathFiles("log4j2.properties"));
        System.out.println("1.4 Check config file classpath:log4j2.xml, " + FileUtils.findClassPathFiles("log4j2.xml"));
        System.out.println("1.4 Check config file classpath:log4j2.json, " + FileUtils.findClassPathFiles("log4j2.json"));
        System.out.println("1.4 Check config file classpath:log4j2.jsn, " + FileUtils.findClassPathFiles("log4j2.jsn"));
        System.out.println("1.4 Check config file classpath:log4j2.yml, " + FileUtils.findClassPathFiles("log4j2.yml"));
        System.out.println("1.4 Check config file classpath:log4j2.yaml, " + FileUtils.findClassPathFiles("log4j2.yaml"));
    }

    public void testLogging(Boolean debug) {
        if (debug) {
            System.setProperty("log4j2.debug", "true");
        }
        System.out.println(String.format("Testing Log4j V2 logging, debug=%s.............", debug));
        ThreadContext.put("TraceId", "log4j2-" + UUID.randomUUID().toString());
        Logger logger = LogManager.getLogger(Log4jV2LoggingService.class);
        System.out.println("Log4j V2 Log level " + logger.getLevel());
        logger.trace("Log4j V2 TRACE message by " + logger.getClass().getName());
        if (logger.isDebugEnabled()) {
            logger.debug("Log4j V2 DEBUG message by {}", logger.getClass().getName(), new RuntimeException("Log4j2 debug"));
        }
        logger.info("Log4j V2 INFO message by {}", logger.getClass().getName());
        logger.warn("Log4j V2 WARN message by {}", logger.getClass().getName());
        RuntimeException error = new RuntimeException("Log4j2 error");
        logger.error("Log4j V2 ERROR message by {}, ex: {}", logger.getClass().getName(), error, error);
        logger.fatal("Log4j V2 FATAL message by {}", logger.getClass().getName(), new RuntimeException("Log4j2 fatal"));
        ThreadContext.remove("TraceId");
        //ThreadContext.clearAll();
    }

    public void testSetLevel() {
        Configurator.setLevel(Log4jV2LoggingService.class, Level.DEBUG);
        Configurator.setRootLevel(Level.DEBUG);
    }
}
