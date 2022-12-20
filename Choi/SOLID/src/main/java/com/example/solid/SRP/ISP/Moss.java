package com.example.solid.SRP.ISP;

public class Moss implements MarineLife{
    @Override
    public void swim() {
        System.out.println("이끼가 수영을 합니다????");  // ISP 원칙 위배
    }

    @Override
    public void eat() {
        System.out.println("이끼가 음식 섭취를 합니다");
    }
}
