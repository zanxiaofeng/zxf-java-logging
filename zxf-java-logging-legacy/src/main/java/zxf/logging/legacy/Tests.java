package zxf.logging.legacy;

import org.apache.commons.logging.impl.SimpleLog;
import zxf.logging.legacy.service.JCLLoggingService;
import zxf.logging.legacy.service.JULLoggingService;
import zxf.logging.legacy.service.Log4jV1LoggingService;
import zxf.logging.legacy.service.Log4jV2LoggingService;

import java.io.IOException;

public class Tests {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperties());
        testJUL();
        testJCL();
        testLog4jV1();
        testLog4jV2();
    }

    private static void testJUL() {
        System.setProperty("java.util.logging.config.file", "./zxf-java-logging-legacy/src/main/resources/jul.logging.properties");
        new JULLoggingService().checkConfiguration();
        new JULLoggingService().testLogging(true);
        new JULLoggingService().testSetLevel();
    }

    private static void testJCL() throws Exception {
        //System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        new JCLLoggingService().checkConfiguration();
        new JCLLoggingService().testLogging(true);
        new JCLLoggingService().testSetLevel();
    }

    private static void testLog4jV1() throws IOException {
        new Log4jV1LoggingService().checkConfiguration();
        new Log4jV1LoggingService().testLogging(true);
        new Log4jV1LoggingService().testSetLevel();
    }

    private static void testLog4jV2() throws IOException {
        new Log4jV2LoggingService().checkConfiguration();
        new Log4jV2LoggingService().testLogging(true);
        new Log4jV2LoggingService().testSetLevel();
    }
}
