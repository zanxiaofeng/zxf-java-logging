package zxf.logging.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Slf4jService {

    public void logLevel() {
        Logger logger = LoggerFactory.getLogger("my.app");
        log.info("Slf4j Log Level, debug={}, info={}, error={}", logger.isDebugEnabled(), logger.isInfoEnabled(), logger.isErrorEnabled());
    }

    public void setLevel() {
        Logger logger = LoggerFactory.getLogger("my.app");
        log.info("Slf4j Log Level, can not set leveldebug={}, info={}, error={}", logger.isDebugEnabled(), logger.isInfoEnabled(), logger.isErrorEnabled());
    }
}
