package com.springmvc.solid.SRP;

public class Student implements People {
    @Override
    public void routine() {
        System.out.println("공부한다");
    }

    @Override
    public void eat() {
        System.out.println("밥먹는다.");
    }

    @Override
    public void laugh() {
        System.out.println("웃는다");
    }
}
