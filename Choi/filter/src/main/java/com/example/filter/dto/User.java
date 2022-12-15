package com.example.filter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
//@Getter  // getter method
//@Setter  // setter method
@Data // getter, setter, toString ... 등의 메소드를 갖는 어노테이션
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
public class User {
    private String name;
    private int age;
}