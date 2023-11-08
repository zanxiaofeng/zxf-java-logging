package zxf.logging.legacy;

public class Tests {
    public static void main(String[] args) {
        System.out.println(System.getProperties());
        testJCL();
        testJUL();
    }

    private static void testJUL() {
        System.out.println("Testing JUL logging.............");
        //System.setProperty("", "");
        new JULLoggingService().execute();
    }

    private static void testJCL() {
        System.out.println("Testing JCL logging.............");
        System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT");
        new JCLLoggingService().execute();
    }
}