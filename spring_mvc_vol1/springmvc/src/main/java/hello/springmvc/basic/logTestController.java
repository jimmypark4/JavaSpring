package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestAPI
public class logTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        //중요한 수준에 따라 로그를 남길 수 있음.
        //밑으로 갈수록 중요한 로그임
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log= {}",name);
        log.warn("warn log={}", name);
        log.error("error log={}",name);
        return "ok";

    }
}

