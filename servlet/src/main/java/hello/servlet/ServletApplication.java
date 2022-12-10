package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan // 서블릿을 직접 등록해서 사용할 수 있게 해줌
@SpringBootApplication
public class ServletApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
