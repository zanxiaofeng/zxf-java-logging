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
        System.out.println("1.0 Check config setting.............");
        System.out.println("1.1 Check StaticMDCBinder from classpath:org/slf4j/impl/StaticMDCBinder.class, " + FileUtils.findClassPathFiles("org/slf4j/impl/StaticMDCBinder.class"));
        System.out.println("1.2 Check StaticLoggerBinder from classpath:org/slf4j/impl/StaticLoggerBinder.class, " + FileUtils.findClassPathFiles("org/slf4j/impl/StaticLoggerBinder.class"));
    }

    public void testLogging(Boolean debug) {
        System.out.println(String.format("Testing SLF4J API logging, debug=%s.............", debug));
        MDC.put("TraceId", "slf4j-" + UUID.randomUUID().toString());
        Logger logger = LoggerFactory.getLogger(Slf4jApiLoggingService.class);
        logger.trace("SLF4J API TRACE message by {}", logger.getClass().getName());
        if (logger.isDebugEnabled()) {
            logger.debug("SLF4J API DEBUG message by {}", logger.getClass().getName(), new RuntimeException("SLF4J debug"));
        }
        logger.info("SLF4J API INFO message by {}", logger.getClass().getName());
        logger.warn("SLF4J API WARN message by {}", logger.getClass().getName());
        RuntimeException exception = new RuntimeException("SLF4J error");
        logger.error("SLF4J API ERROR message by {}, ex: {}", logger.getClass().getName(), exception, exception);
        MDC.remove("TraceId");
        //MDC.clear();
    }
}
