package com.example.bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.choi.AppConfig;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.repository.MemberRepository;
import com.example.repository.MemoryMemberRepository;

public class BeanFindTest {
	
	AnnotationConfigApplicationContext ac = new
			AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBean() {
	String[] beanDefinitionNames = ac.getBeanDefinitionNames();
	for (String beanDefinitionName : beanDefinitionNames) {
	Object bean = ac.getBean(beanDefinitionName);
	System.out.println("name=" + beanDefinitionName + " object=" + bean);
	   }
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	void findApplicationBean() {
			String[] beanDefinitionNames = ac.getBeanDefinitionNames();
			for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition =	ac.getBeanDefinition(beanDefinitionName);

			//Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
			//Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("name=" + beanDefinitionName + " object=" +
			bean);
			}
		}
	}
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
	MemberService memberService = ac.getBean("memberService",
	MemberService.class);
	assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("이름 없이 타입만으로 조회")
	void findBeanByType() {
	MemberService memberService = ac.getBean(MemberService.class);
	assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByName1() {
	MemberServiceImpl memberService = ac.getBean("memberService",
	MemberServiceImpl.class);
	assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("빈 이름으로 조회X")
	void findBeanByNameX() {
	//ac.getBean("xxxxx", MemberService.class);
	Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
	ac.getBean("xxxxx", MemberService.class));
	}
	
	AnnotationConfigApplicationContext ac2 = new
			AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
	void findBeanByTypeDuplicate() {
	//DiscountPolicy bean = ac.getBean(MemberRepository.class);
	assertThrows(NoUniqueBeanDefinitionException.class, () ->
	ac2.getBean(MemberRepository.class));
	}

	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
	void findBeanByName2() {
	MemberRepository memberRepository = ac2.getBean("memberRepository1", MemberRepository.class);
	assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}

	@Test
	@DisplayName("특정 타입을 모두 조회하기")
	void findAllBeanByType() {
	Map<String, MemberRepository> beansOfType =
			ac2.getBeansOfType(MemberRepository.class);
	for (String key : beansOfType.keySet()) {
	System.out.println("key = " + key + " value = " +
	beansOfType.get(key));
	}
	System.out.println("beansOfType = " + beansOfType);
	assertThat(beansOfType.size()).isEqualTo(2);

	}

	@Configuration
	static class SameBeanConfig {

	@Bean
	public MemberRepository memberRepository1() {
	return new MemoryMemberRepository();
	}

	@Bean
	public MemberRepository memberRepository2() {
	return new MemoryMemberRepository();
	}
	}

	}
