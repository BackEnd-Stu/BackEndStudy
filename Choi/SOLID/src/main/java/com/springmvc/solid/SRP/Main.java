package com.springmvc.solid.SRP;

public class Main {
    public static void main(String[] args) {
        People student = new Student(); // 자식 객체가 부모 객체를 완전히 대체 가능하다.
        People workman = new Workman(); // 자식 객체가 부모 객체를 완전히 대체 가능하다.

        student.routine();
        workman.routine();

    }
}
