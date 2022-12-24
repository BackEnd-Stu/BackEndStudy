package com.springmvc.basic;

import lombok.Data;

// Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor를 자동으로 만들어줌.
@Data
public class HelloData {
    private String username;
    private int age;
}
