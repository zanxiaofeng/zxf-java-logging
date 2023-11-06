package zxf.logging.legacy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JCLLoggingService {
    private static Log log = LogFactory.getLog(JCLLoggingService.class);

    public void execute() {
        log.trace("JCL TRACE message");
        log.debug("JCL DEBUG message");
        log.info("JCL INFO message");
        log.warn("JCL WARN message");
        log.error("JCL ERROR message");
        log.fatal("JCL FATAL message");
    }
}
