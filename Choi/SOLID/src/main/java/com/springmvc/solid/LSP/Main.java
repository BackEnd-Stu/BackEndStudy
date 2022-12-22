package com.springmvc.solid.LSP;

public class Main {
    public static void main(String[] args) {


        WrongRectangle wrongsquare = new WrongSquare();

        wrongsquare.setWidth(10);
        wrongsquare.setHeight(5);

        System.out.println(wrongsquare.getArea());

        Shape rectangle = new Rectangle(10, 5);
        Shape square = new Square(5);

        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());
    }
}
