package com.example.filter.network;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class NetworkClientTest {
    @Test
    public void lifeCycleTest() {

 //       InitializingBean, DisposableBean 인터페이스
//        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
//        NetworkClient client = ac.getBean(NetworkClient.class);

//        init(), close() 메서드
//          ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
//          NetworkClient2 client = ac.getBean(NetworkClient2.class);

          ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
          NetworkClient3 client = ac.getBean(NetworkClient3.class);

          ac.close();

        //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요

          ac.close();

    }

    @Configuration
    static class LifeCycleConfig {
//        InitializingBean, DisposableBean 인터페이스
//        @Bean
//        public NetworkClient networkClient() {
//            NetworkClient networkClient = new NetworkClient();
//            networkClient.setUrl("http://hello-spring.dev");
//            return networkClient;
//        }

//        init(), close() 메서드
//        @Bean (initMethod = "choi", destroyMethod = "choiclose")
//        public NetworkClient2 networkClient2() {
//            NetworkClient2 networkClient2 = new NetworkClient2();
//            networkClient2.setUrl("http://hello-spring.dev");
//            return networkClient2;
//        }

//        @Bean
        @Bean
        public NetworkClient3 networkClient3() {
            NetworkClient3 networkClient3 = new NetworkClient3();
            networkClient3.setUrl("http://hello-spring.dev");
            return networkClient3;
        }
    }
}