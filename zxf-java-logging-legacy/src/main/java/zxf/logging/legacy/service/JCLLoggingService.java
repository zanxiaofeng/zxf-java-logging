package zxf.logging.legacy.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import zxf.logging.legacy.utils.FileUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class JCLLoggingService {

    public void checkConfiguration() throws IOException {
        System.out.println("Checking JCL Configuration.............");
        System.out.println("1.0 Check org.apache.commons.logging.LogFactory setting.............");
        String logFactoryFromSysProp = System.getProperty("org.apache.commons.logging.LogFactory");
        System.out.println("1.1 Check org.apache.commons.logging.LogFactory setting from system property, " + logFactoryFromSysProp);
        System.out.println("1.2 Check org.apache.commons.logging.LogFactory setting from classpath:META-INF/services/org.apache.commons.logging.LogFactory, " + FileUtils.findClassPathFiles("META-INF/services/org.apache.commons.logging.LogFactory"));
        System.out.println("1.3 Check org.apache.commons.logging.LogFactory setting from classpath:commons-logging.properties, " + FileUtils.findClassPathFiles("commons-logging.properties"));


        System.out.println("2.0 Check org.apache.commons.logging.Log setting.............");
        String configLogFromSysProp = System.getProperty("org.apache.commons.logging.Log");
        System.out.println("2.1 Check org.apache.commons.logging.Log setting from system property, " + configLogFromSysProp);
        System.out.println("2.2 Check org.apache.commons.logging.Log setting from classpath:commons-logging.properties, " + FileUtils.findClassPathFiles("commons-logging.properties"));

        System.out.println("3.0 Check org.apache.commons.logging.diagnostics.dest setting.............");
        String diagnosticsFromSysProp = System.getProperty("org.apache.commons.logging.diagnostics.dest");
        System.out.println("3.1 Check org.apache.commons.logging.diagnostics.dest setting from system property, " + diagnosticsFromSysProp);

        System.out.println("4.0 Check Other setting.............");
        System.out.println("4.1 Check Other setting from classpath:commons-logging.properties, " + FileUtils.findClassPathFiles("commons-logging.properties"));
    }

    public void testLogging(Boolean debug) {
        if (debug) {
            System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT");
        }
        System.out.println(String.format("Testing JCL logging, debug=%s.............", debug));
        Log log = LogFactory.getLog(JCLLoggingService.class.getName());
        log.trace("JCL TRACE message by " + log.getClass().getName());
        log.debug("JCL DEBUG message by " + log.getClass().getName());
        log.info("JCL INFO message by " + log.getClass().getName());
        log.warn("JCL WARN message by " + log.getClass().getName());
        log.error("JCL ERROR message by " + log.getClass().getName());
        log.fatal("JCL FATAL message by " + log.getClass().getName());
    }
}
