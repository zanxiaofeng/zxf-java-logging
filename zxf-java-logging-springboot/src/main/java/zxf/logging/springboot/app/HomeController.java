package zxf.logging.springboot.app;

import lombok.extern.log4j.Log4j2;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        MDC.put("TraceId", UUID.randomUUID().toString());
        log.debug("Hello World!");
        log.info("Hello World!");
        return "Hello World!";
    }
}
