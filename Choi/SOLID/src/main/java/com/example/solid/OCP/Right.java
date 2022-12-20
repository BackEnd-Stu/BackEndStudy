package com.example.solid.OCP;

import com.example.solid.SRP.People;
import com.example.solid.SRP.Student;
import com.example.solid.SRP.Workman;

public class Right {
    public static void main(String[] args) {

//        People[] classArray = new People[2];
//
//        classArray[0] = new Student();
//        classArray[1] = new Workman();
//
//        for (int i = 0; i < classArray.length; i++) {
//            classArray[i].routine();
//        }

        People people1 = new Student();
        People people2 = new Workman();
    }
}
