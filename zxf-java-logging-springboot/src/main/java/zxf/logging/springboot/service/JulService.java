package zxf.logging.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Slf4j
@Service
public class JulService {
    public void logLevel() {
        Logger logger = Logger.getLogger("my.app");
        log.info("Jul Logger Level: {}", logger.getLevel());
    }

    public void setLevel() {
        Logger logger = Logger.getLogger("my.app");
        logger.setLevel(Level.FINEST);
        log.info("Jul Logger Level: {}", logger.getLevel());
    }
}
