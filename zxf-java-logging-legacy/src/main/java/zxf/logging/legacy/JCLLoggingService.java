package zxf.logging.legacy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JCLLoggingService {
    public void execute() {
        if (false) {
            executeBySystem();
        } else {
            executeBySimpleLog();
        }
    }

    private void executeBySystem() {
        Log log = LogFactory.getLog(JCLLoggingService.class.getName());
        log.trace("JCL TRACE message by " + log.getClass().getName());
        log.debug("JCL DEBUG message by " + log.getClass().getName());
        log.info("JCL INFO message by " + log.getClass().getName());
        log.warn("JCL WARN message by " + log.getClass().getName());
        log.error("JCL ERROR message by " + log.getClass().getName());
        log.fatal("JCL FATAL message by " + log.getClass().getName());
    }

    private void executeBySimpleLog() {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        Log log = LogFactory.getLog(JCLLoggingService.class.getName());
        log.trace("JCL TRACE message by " + log.getClass().getName());
        log.debug("JCL DEBUG message by " + log.getClass().getName());
        log.info("JCL INFO message by " + log.getClass().getName());
        log.warn("JCL WARN message by " + log.getClass().getName());
        log.error("JCL ERROR message by " + log.getClass().getName());
        log.fatal("JCL FATAL message by " + log.getClass().getName());
    }
}
