package hello.core.scan.filter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// MyExcludeComponent가 붙은 클래스는 config파일을 통해 컴포넌트스캔에서 제외해서 사용할 예정
// TYPE : 클래스 레벨에 붙는것
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}
