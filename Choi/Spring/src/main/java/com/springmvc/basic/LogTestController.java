package com.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  // 이 어노테이션을 달면 롬복이 로그코드를 생략해준다. private final Logger log = LoggerFactory.getLogger(getClass());
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // application.properties에서 'logging.level.com.springmvc=trace' 설정.
        // 보통 개발 서버는 debug, 운영 서버는 info로 출력
        // default값: info

        log.trace("trace log = {},", name);
        log.debug("debug log = {},", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "ok";
    }
}
