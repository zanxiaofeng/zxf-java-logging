package zxf.logging.slf4j2logback;

import zxf.logging.legacy.service.JCLLoggingService;
import zxf.logging.legacy.service.JULLoggingService;
import zxf.logging.legacy.service.Log4jV1LoggingService;
import zxf.logging.legacy.service.Log4jV2LoggingService;
import zxf.logging.slf4japi.service.Slf4jApiLoggingService;

import java.io.IOException;

public class Tests {
    public static void main(String[] args) throws Exception {
        testJUL();
        testJCL();
        testLog4jV1();
        testLog4jV2();
        testSLF4j();
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

    private static void testLog4jV2() throws IOException {
        System.setProperty("log4j2.debug", "true");
        new Log4jV2LoggingService().checkConfiguration();
        new Log4jV2LoggingService().testLogging();
    }

    private static void testSLF4j() throws IOException {
        new Slf4jApiLoggingService().checkConfiguration();
        new Slf4jApiLoggingService().testLogging();
    }
}