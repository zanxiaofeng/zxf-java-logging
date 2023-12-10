package zxf.logging.slf4japi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import zxf.logging.slf4japi.utils.FileUtils;

import java.io.IOException;
import java.util.UUID;

public class Slf4jApiLoggingService {

    public void checkConfiguration() throws IOException {
        System.out.println("Checking SLF4J API Configuration.............");
        System.out.println("1.0 Check config file setting.............");
        String providerFromSysProp = System.getProperty("slf4j.provider");
        System.out.println("1.1 Check provider from system property slf4j.provider, " + providerFromSysProp);
        System.out.println("1.2 Check provider from classpath:META-INF/services/org.slf4j.spi.SLF4JServiceProvider, " + FileUtils.findClassPathFiles("META-INF/services/org.slf4j.spi.SLF4JServiceProvider"));
       }

    public void testLogging() {
        System.out.println("Testing SLF4J API logging.............");
        MDC.put("TraceId", UUID.randomUUID().toString());
        Logger logger = LoggerFactory.getLogger(Slf4jApiLoggingService.class);
        logger.trace("SLF4J API TRACE message by {}", logger.getClass().getName());
        logger.debug("SLF4J API DEBUG message by {}", logger.getClass().getName());
        logger.info("SLF4J API INFO message by {}", logger.getClass().getName());
        logger.warn("SLF4J API WARN message by {}", logger.getClass().getName());
        logger.error("SLF4J API ERROR message by {}", logger.getClass().getName());
    }
}
