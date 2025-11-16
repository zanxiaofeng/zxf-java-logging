package zxf.logging.slf4japi;

import zxf.logging.slf4japi.service.Slf4jApiLoggingService;

public class Tests {
    public static void main(String[] args) throws Exception {
        new Slf4jApiLoggingService().checkConfiguration();
        new Slf4jApiLoggingService().testLogging(true);
        new Slf4jApiLoggingService().testSetLevel();
    }
}
