package com.example.springstarterdemo.beanfind;

import com.example.springstarterdemo.AppConfig;
import com.example.springstarterdemo.discount.DiscountPolicy;
import com.example.springstarterdemo.discount.FixDiscountPolicy;
import com.example.springstarterdemo.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회 시 자식타입의 bean이 2개 이상이면 오류 발생")
    void findBeanByParentTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,
                ()->ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("역시나 bean 이름을 지정하면됨")
   void findBeanByParentTypeBeanName(){
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("구체적인 자식타입으로 조회해도됨")
   void findBeanBySubType(){
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기 - Object")
    void findBeanByParentType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        int cnt = 0;
        for (String s : beansOfType.keySet()) {
            cnt++;

        }
        assertThat(beansOfType.size()).isEqualTo(cnt);

    }



    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }
}
