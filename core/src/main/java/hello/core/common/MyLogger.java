package hello.core.common;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// reuqest scope가 적용된 MyLogger를 사용하지 않고 request url, uuid등의 정보를 서비스 계층에 넘긴다면 파라미터가 많아서 코드가 지저분해지고
// 웹과 관련된 정보가 서비스 계층까지 넘어가게 되는데, 서비스 계층은 사실 웹과 관련된 정보가 필요가 없고, 설계 자체를 웹 기술에 종속되지 않고
// 순수하게 유지하는 것이 유지보수 관점에서 좋다.
// 웹과 관련된 부분은 컨트롤러까지만 사용하도록 하자.
// ✧*。request scope의 장점 : 동시에 여러 요청이 온다고 하더라도 각각의 요청마다 객체를 따로 관리해 준다.
@Component
// 1.
//@Scope(value = "request")
// 그냥 원래 하던 방식처럼 객체 생성 순간에 주입 받게 하면 안되나??
// 2. 프록시 사용 : 가짜, 프록시를 만드는 것
// 프록시 객체가 프로바이더처럼 동작하게 된다.
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        // init이 호출되면서 http request와 uuid를 연결시킨다.
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}
