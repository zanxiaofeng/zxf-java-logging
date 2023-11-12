package zxf.logging.legacy;

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
        new JULLoggingService().testLogging();
    }

    private static void testJCL() throws Exception {
        //System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT");
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        new JCLLoggingService().checkConfiguration();
        new JCLLoggingService().testLogging();
    }

    private static void testLog4jV1() throws IOException {
        new Log4jV1LoggingService().checkConfiguration();
        new Log4jV1LoggingService().testLogging();
    }

    private static void testLog4jV2() {
        //System.setProperty("log4j2.debug", "true");
        new Log4jV2LoggingService().checkConfiguration();
        new Log4jV2LoggingService().testLogging();
    }
}
