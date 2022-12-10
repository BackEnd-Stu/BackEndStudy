package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class LogDemoService {

    // 2. 프록시 사용
    private final MyLogger myLogger;

    // 1. Provider 사용
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    public void logic(String id) {
        // 1.
        // 서비스 객체 내에서, 이 시점에 최초로 생성된다.
//        MyLogger myLogger = myLoggerProvider.getObject();
        // log를 찍는다. 컨트롤러에서 MyLogger에 넣어 놓은 uuid와 url이 모두 있어서 함께 찍힐 수 있다.
        myLogger.log("service id = " + id);
    }
}
