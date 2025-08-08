package zxf.logging.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommonsLogService {
    public void logLevel() {
        Log logger = LogFactory.getLog("my.app");
        log.info("Commons Log Level, debug={}, info={}, fatal={}", logger.isDebugEnabled(), logger.isInfoEnabled(), logger.isFatalEnabled());
    }

    public void setLevel() {
        Log logger = LogFactory.getLog("my.app");
        log.info("Commons Log Level, can not set level, debug={}, info={}, fatal={}", logger.isDebugEnabled(), logger.isInfoEnabled(), logger.isFatalEnabled());
    }
}