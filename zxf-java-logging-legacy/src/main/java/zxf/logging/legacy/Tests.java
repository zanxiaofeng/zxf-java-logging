package zxf.logging.legacy;

public class Tests {
    public static void main(String[] args) {
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

    private static void testJCL() {
        System.out.println("Testing JCL logging.............");
        //System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT");
        new JCLLoggingService().execute();
    }

    private static void testLog4jV1() {
        System.out.println("Testing Log4j V1 logging.............");
        new Log4jV1LoggingService().execute();
    }

    private static void testLog4jV2() {
        System.out.println("Testing Log4j V2 logging.............");
        new Log4jV2LoggingService().execute();
    }
}
