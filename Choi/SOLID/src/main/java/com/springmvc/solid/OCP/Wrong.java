package com.springmvc.solid.OCP;

import com.springmvc.solid.SRP.Student;
import com.springmvc.solid.SRP.Workman;

public class Wrong {
    public static void main(String[] args) {
        Student student = new Student();
        student.routine();

        Workman workman = new Workman();
        workman.routine();
    }
}


