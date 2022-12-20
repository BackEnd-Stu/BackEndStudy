package com.example.solid.OCP;

import com.example.solid.SRP.Student;
import com.example.solid.SRP.Workman;

public class Wrong {
    public static void main(String[] args) {
        Student student = new Student();
        student.routine();

        Workman workman = new Workman();
        workman.routine();
    }
}


