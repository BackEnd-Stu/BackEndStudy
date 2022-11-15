package com.example.springstarterdemo.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    /*    public void order(String name, int price){
            System.out.println("name = " + name + " price = " + price);
            this.price = price; //여기가 문제
        }*/

    //무상태로 설계한 버전
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price; //공유 필드를 사용하지 않음
    }

/*
    public int getPrice() {
        return price;
    }*/
}
