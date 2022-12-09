package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // HelloData 클래스 형태로 객체 생성
        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        // json도 결국 문자열, helloData를 문자로 바꿔주기
        // 객체를 json으로 바꾸려면 Jackson의 ObjectMapper가 필요함
        String result = objectMapper.writeValueAsString(helloData);// 객체를 가지고 값을 써서 문자로 바꿔줌
        response.getWriter().write(result);

        // ** spring을 사용할 수 있게 되면 객체를 그대로 반환할 수 있어서 아래와 같이 간단하게 처리할 수 있다.
        // return helloData;

    }
}
