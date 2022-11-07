package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // 1. 순수 자바로 개발
//        MemberService memberService = new MemberServiceImpl();
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//        Member findMember = memberService.findMember(1L);

        // 2. AppConfig를 활용해 개발
//        AppConfig appConfig = new AppConfig();
                                        // AppCofig에서 직접 찾아옴
//        MemberService memberService = appConfig.memberService();

        // 3.spring framework 사용 버전

        // spring 컨테이너, 모든것을 관리(객체들, @Bean들)
        ApplicationContext applicationContext =
            // 이녀석을 사용하면 AppConfig에 있는 환경 설정 정보를 가지고 스프링 컨테이너에 객체 생성 한것들을 집어넣고 관리 해 준다.
            new AnnotationConfigApplicationContext(AppConfig.class);
        // 스프링 컨테이너를 통해 Bean으로 등록된 필요한 객체를 찾아옴
                                    // 기본적으로, config클래스에 적어놓은 메서드 이름으로 등록된다
                                                        // 반환 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
