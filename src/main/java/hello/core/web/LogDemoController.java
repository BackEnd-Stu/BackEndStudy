package hello.core.web;

import hello.core.common.MyLogger;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    // 1. Provider 사용
    // MyLogger를 주입받는 것이 아니라 MyLogger를 찾을 수 있는 DL가능 객체를 주입받게 된다.
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    // CoreApplication을 실행시키면 스프링 컨테이너가 뜨게 되고 스프링 컨테이너가 뜨면서 LogDemoController객체도 생성된다.
    // 객체가 생성되면서 의존관계 주입이 일어나면 LogDemoController가 스프링 컨테이너에게 MyLogger를 내놔라!하는데
    // MyLogger는 request scope이라 아직 request가 없는 상태에서는 MyLogger를 찾을 수 없다.
    // -> Provider를 사용해 문제 해결

    // 2. 프록시 사용
    // request요청이 들어오기 전에는 MyLogger가 생성되지 않아서 컨트롤러에서 멤버로 넣어 줘도 비어있게 되는 것이 문제였는데,
    // LogDemoController가 생성될 때 MyLogger를 프록시 객체로 생성해서 넣어줬기 때문에 에러가 발생하지 않는다.
    // 이 시점에 주입되는 것은 진짜 MyLogger가 아니다. 껍데기, 가짜 MyLogger를 집어넣는 것이다.
    private final MyLogger myLogger;

    // 이전 강의에서는 화면으로 렌더링 해서 응답해 줬었는데,
    // ReseponseBody를 사용하면 문자를 그대로 응답으로 보낼 수 있다
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException { // java에서 제공하는 표준 서블릿 규약이 있는데, 그것에 의한 http요청정보를 받을 수 있다.
                            // 고객이 어떤 url로 요청했는지 알 수 있다.
        // 1.
        // MyLogger가 정말로 필요한 시점(request요청이 들어온 시점)으로 주입을 지연시켰다.
        // (정확히는 스프링 컨테이너에게 요청하는 행위  지연시킨것)
        // init이 호출되면서 http request와 uuid를 연결시킨다.
//        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();
        // requestURL을 MyLogger에 저장하는 부분은 컨트롤러보다는 공통 처리가 가능한 스프링 인터셉터나 서블릿 필터 같은 곳을 활용하는 것이 좋다.
        // 인터셉터 : http request요청을 컨트롤러 호출 직전에 공통화해서 처리할 수 있게 해주는 녀석

        // 2. 프록시 객체 실습
        // 프록시 : 앞에서 뭔가 요청을 받아서 대신 뭔가 처리해 주는 개념, 간단한 조작 + 위임하는 역할
        // 가짜는 request scope와는 아무 관계가 없고, 싱글톤처럼 등록이 된다. (가짜기 때문에 다같이 공유해도 됨)
        // myLogger = class hello.core.common.MyLogger$$EnhancerBySpringCGLIB$$5fd3fa31
        // CGLIB라는 라이브러리로 MyLogger클래스를 상속받은 가짜 프록시 객체를 만들어서 스프링 컨테이너에 등록
        // 스프링 컨테이너에 내부적으로 MyLogger도 등록되긴 하지만 다른 이름으로 등록됨
        // 가짜 프록시 객체는 진짜 클래스 객체를 참조하는 요청이 들어오면 그때 진짜를 찾아서 호출해 주는데,
        // 그런 위임 로직이 프록시 객체 내부에 들어 있다.
        System.out.println("myLogger = " + myLogger.getClass());

        // setRequestURL을 호출하면서 url을 MyLogger에 담는다.
        // 2. 기능을 실제로 호출하는 시점에 진짜를 찾아서 동작한다. 마치 프로바이더를 통해 객체를 찾아 받았던 것처럼
        // 사실은 가짜 프록시 객체의 메서드를 호출하고 있다.
        // 가짜 프록시 객체가 진짜 myLogger를 찾는 방법을 프록시 객체 내부에 갖고 있기 때문에, 이런 식의 호출이 발생하면
        // request Scope 빈인 진짜 myLogger의 메서드를 호출한다.
        // 가짜 프록시 객체는 원본 클래스를 상속받아서 만들어졌기 때문에 이것을 사용하는 클라이언트 입장에서는
        // 원본인지 아닌지 모르고 동일하게 사용할 수 있다(다형성).
        myLogger.setRequestURL(requestURL);

        // log를 찍는다. 이 시점에는 이미 uuid와 url이 모두 있어서 함께 찍힐 수 있다.
        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }

}
