package zxf.logging.slf4j2logback.service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import zxf.logging.slf4japi.utils.FileUtils;
import ch.qos.logback.classic.Logger;

import java.io.IOException;

public class LogbackLoggingService {
    public void checkConfiguration() throws IOException {
        System.out.println("Checking Logback Configuration.............");
        System.out.println("1.0 Check config setting.............");
        String configurationFileFromSysProp = System.getProperty("logback.configurationFile");
        System.out.println("1.1 Check config file setting from system property, logback.configurationFile=" + configurationFileFromSysProp);
        System.out.println("1.2 Check config file from classpath:logback.xml, " + FileUtils.findClassPathFiles("logback.xml"));
        System.out.println("1.3 Check config file from classpath:logback-test.xml, " + FileUtils.findClassPathFiles("logback-test.xml"));
    }

    public void testSetLevel() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        System.out.println("Testing Logback set level.............");
        Logger rootLogger = loggerContext.getLogger("ROOT");
        System.out.println("Logback Logger Level(root): " + rootLogger.getLevel());
        Logger packageLogger = loggerContext.getLogger("zxf.logging.slf4j2logback");
        System.out.println("Logback Logger Level(zxf.logging.slf4j2logback: " + packageLogger.getLevel());
        Logger serviceLogger = loggerContext.getLogger(LogbackLoggingService.class);
        System.out.println("Logback Logger Level(zxf.logging.slf4j2logback.service.LogbackLoggingService): " + serviceLogger.getLevel());

        System.out.println();
        serviceLogger.setLevel(Level.INFO);
        System.out.println("Logback Logger Level after set(zxf.logging.slf4j2logback.service.LogbackLoggingService): " + serviceLogger.getLevel());
        rootLogger.setLevel(Level.INFO);
        System.out.println("Logback Logger Level after set(root): " + rootLogger.getLevel());
        System.out.println("Logback Logger Level after set(zxf.logging.slf4j2logback): " + packageLogger.getLevel());
    }
}
