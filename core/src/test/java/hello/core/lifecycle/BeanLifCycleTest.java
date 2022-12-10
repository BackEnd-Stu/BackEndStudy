package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

public class BeanLifCycleTest {

    @Test
    public void lifeCycleTest() {
        // close를 하려면 ApplicationContext로는 안된다
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Controller
    public static class LifeCycleConfig {
        // 2. 빈 등록시 초기화, 소멸 메서드로 등록
//        @Bean(initMethod = "init", destroyMethod = "close")
        // 3. @PostConstruct, @PreDestroy 어노테이션 방식
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }

}
