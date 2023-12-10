package zxf.logging.slf4j2logback;

import zxf.logging.slf4japi.service.Slf4jApiLoggingService;

import java.io.IOException;

public class Tests {
    public static void main(String[] args) throws IOException {
        new Slf4jApiLoggingService().checkConfiguration();
        new Slf4jApiLoggingService().testLogging();
    }
}