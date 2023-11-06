package zxf.logging.legacy;

public class Tests {
    public static void main(String[] args) {
        System.out.println(System.getProperties());
    }

    private static void testJUL() {
        System.setProperty("", "");
        new JULLoggingService().execute();
    }
}
