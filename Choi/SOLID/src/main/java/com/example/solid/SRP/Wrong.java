package com.example.solid.SRP;

public class Wrong {
    public String student;
    public String workman;
    public String people;

    void routine() {
        if (this.people == student) {
            System.out.println("공부한다");
        } else if (this.people == workman){
            System.out.println("일한다");
        }
    }

    public static void main(String[] args) {
        new Wrong().routine();
    }
}
