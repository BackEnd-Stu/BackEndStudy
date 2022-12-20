package com.example.solid.SRP.ISP;

public class Fish implements MarineLife{
    @Override
    public void swim() {
        System.out.println("물고기가 수영을 합니다.");
    }

    @Override
    public void eat() {
        System.out.println("물고기가 음식 섭취를 합니다");
    }
}
