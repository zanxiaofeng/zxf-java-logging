package zxf.logging.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Log4j2Service {

    public void logLevel() {
        Logger logger = LogManager.getLogger("my.app");
        log.info("Log4j2 Logger Level: {}", logger.getLevel());
    }

    public void setLevel() {
        Logger logger = LogManager.getLogger("my.app");
        log.info("Log4j2 Log Level, can not set level, {}", logger.getLevel());
    }
}
