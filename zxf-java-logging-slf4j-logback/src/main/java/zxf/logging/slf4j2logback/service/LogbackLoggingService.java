package zxf.logging.slf4j2logback.service;

import zxf.logging.slf4japi.utils.FileUtils;

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
}
