package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


                                        // 1. 인터페이스 사용 방식
public class NetworkClient /*implements InitializingBean, DisposableBean*/ {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    // 1. 인터페이스 사용 방식
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }

        // 2. 빈 등록시 초기화, 소멸 메서드로 등록
        // 3. 어노테이션 방식
        @PostConstruct
        public void init() {
            System.out.println("NetworkClient.init");
            connect();
            call("초기화 연결 메시지");
        }

   // 1. 인터페이스 사용 방식
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    // 2. 빈 등록시 초기화, 소멸 메서드로 등록
    // 3. 어노테이션 방식
        @PreDestroy
        public void close() {
            System.out.println("NetworkClient.close");
            disconnect();
        }
}
