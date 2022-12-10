package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 4. spring, 컴포넌트 스캔 : 스프링부트를 사용하면 이 어노테이션을 사용할 일이 없다 : @SpringBootApplication에서 상속받아서 다 해주니까
@Configuration
@ComponentScan( // 범위를 지정하지 않으면 해당 어노테이션을 붙인 패키지에서 시작해서 하위 패키지까지 스캔한다.
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
