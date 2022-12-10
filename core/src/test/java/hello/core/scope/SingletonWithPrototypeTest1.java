package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import hello.core.scope.PrototypeTest.PrototypeBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        // 1.
//        assertThat(count2).isEqualTo(2);
        // 2.
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean {
        // 1. 생성 시점에 주입 되어버림 -> 계속 같은것을 사용
//        private final PrototypeBean prototypeBean; // 1. 이미 주입되어 있다

        // 4. ObjectProvider, 생성자 주입 방식으로 해도 되지만 테스트니까 필드 주입 사용
        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider;
        // 5. JSR-330 Provider 사용
        private Provider<PrototypeBean> prototypeBeanProvider;

        // 2. prototypeBean을 주입 시점에만 새로 생성하는것이 아니라 싱글톤 안에서 사용할 때마다 새로 생성해서 쓰는 것을 원한다면
        // 클래스의 final 멤버변수로 두지 말고 logic()안에서 ApplicationContext로 주입받아

        // 2. 무식하게 주입받아(?) 사용
//        @Autowired
//        ApplicationContext applicationContext;
        // 하지만 이렇게 클라이언트 단에서 싱글톤 빈 객체가 스프링 ApplicationContext를 주입받아 사용하는 코드는 지저분하다.
        // -> 스프링 컨테이너에 종속적인 코드가 되고, 단위 테스트도 어려워진다.
        // 지정한 프로토타입 빈을 컨테이너에서 대신 찾아주는 DL(Dependency Lookup)과 같은 기능이 필요
        // => 4. ObjectFactory, ObjectProvider 사용
        // ObjectFactory : 더 오래된 클래스, 기능이 단순하고 별도의 라이브러리가 필요하지 않음
        // ObjectProvider : ObjectFactory를 상속, 스트림 처리 등 편의 기능과 다양한 옵션 제공, 별도의 라이브러리 필요 없음
        // 스프링 코드를 그대로 가져다 사용하는 것이기 때문에 둘 다 스프링에 의존적이다.
        // => 스프링에 의존하지 않는 새로운 기술의 대두
        // 5. JSR-330 Provider
        // javax.inject.Provider라는 java표준을 사용하는 방법

        // 1. 싱글톤 빈인 ClientBean의 생성 시점에 PrototypeBean을 주입받음
//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean) {
//            this.prototypeBean = prototypeBean;
//        }

        public int logic() {
            // 2. ApplicationContext를 사용해 PrototypeBean을 직접 주입받아 사용
//            PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
            // 4. Provider가 2 역할을 해서 필요한 의존성을 대신 찾아준다.
            // AppplicationContext를 사용해서 스프링의 기능을 다 사용하는 것이 아니라 필요한 부분만 가볍게 사용할 수 있다.
            // 스프링이 제공하는 기능을 사용하지만, 단순한 기능만을 갖고 있기 때문에 단위테스트를 만들거나 mock코드를 만들기 쉽다.
//            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    // 3. 여러 빈에서 같은 프로토타입 빈을 주입 받게 되면 주입 받는 시점에 각각 새로운 프로토타입 빈이 생성된다.
    // 하지만, 이렇게 한다고 해서 사용할 때마다 새로 생성되는 것은 아니다. 각각 다른 싱글톤에서 따로 주입받은것 뿐
    // Q. 결국 싱글톤 써서 해결하지 이렇게까지 해서 사용할 일은 없었다?
    @Scope("singleton")
    static class ClientBean2 {
        // ClientBean의 protoTypeBean이 x01이라면
        private final PrototypeBean prototypeBean; // x02

        // 1. 싱글톤 빈인 ClientBean의 생성 시점에 PrototypeBean을 주입받음
        @Autowired
        public ClientBean2(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }


    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
