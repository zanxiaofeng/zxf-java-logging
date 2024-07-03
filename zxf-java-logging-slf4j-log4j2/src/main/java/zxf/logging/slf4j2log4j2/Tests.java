package zxf.logging.slf4j2log4j2;

import org.slf4j.MDC;
import org.slf4j.bridge.SLF4JBridgeHandler;
import zxf.logging.legacy.service.JCLLoggingService;
import zxf.logging.legacy.service.JULLoggingService;
import zxf.logging.legacy.service.Log4jV1LoggingService;
import zxf.logging.legacy.service.Log4jV2LoggingService;
import zxf.logging.slf4japi.service.Slf4jApiLoggingService;

import java.io.IOException;
import java.util.UUID;

public class Tests {
    public static void main(String[] args) throws Exception {
        MDC.put("GlobalId", "slf4j-" + UUID.randomUUID());
        testJUL();
        testJCL();
        testLog4jV1();
        testLog4jV2();
        testSLF4j();
        MDC.remove("GlobalId");
        //MDC.clear();
    }

    private static void testJUL() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        //Set jul level by JUL logger: FINEST == TRACE
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("zxf.logging.legacy");
        logger.setLevel(java.util.logging.Level.FINEST);

        new JULLoggingService().checkConfiguration();
        new JULLoggingService().testLogging(false);
    }

    private static void testJCL() throws Exception {
        new JCLLoggingService().checkConfiguration();
        new JCLLoggingService().testLogging(false);
    }

    private static void testLog4jV1() throws IOException {
        new Log4jV1LoggingService().checkConfiguration();
        new Log4jV1LoggingService().testLogging(false);
    }

    private static void testLog4jV2() throws IOException {
        new Log4jV2LoggingService().checkConfiguration();
        new Log4jV2LoggingService().testLogging(false);
    }

    private static void testSLF4j() throws IOException {
        new Slf4jApiLoggingService().checkConfiguration();
        new Slf4jApiLoggingService().testLogging(false);
    }
}