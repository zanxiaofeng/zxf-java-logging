package zxf.logging.springboot.app;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zxf.logging.springboot.service.CommonsLogService;
import zxf.logging.springboot.service.JulService;
import zxf.logging.springboot.service.Log4j2Service;
import zxf.logging.springboot.service.Slf4jService;

import java.util.UUID;

@Log
@RestController
@RequestMapping("/logging")
public class LoggingController {
    @Autowired
    private JulService julService;
    @Autowired
    private Slf4jService slf4jService;
    @Autowired
    private Log4j2Service log4j2Service;
    @Autowired
    private CommonsLogService commonsLogService;

    @GetMapping("/level")
    public void logLevel() {
        MDC.put("TraceId", UUID.randomUUID().toString());
        julService.logLevel();
        slf4jService.logLevel();
        log4j2Service.logLevel();
        commonsLogService.logLevel();
    }

    @GetMapping("/level/set")
    public void index() {
        MDC.put("TraceId", UUID.randomUUID().toString());
        julService.setLevel();
        slf4jService.setLevel();
        log4j2Service.setLevel();
        commonsLogService.setLevel();
    }
}
