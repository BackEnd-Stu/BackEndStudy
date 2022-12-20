package com.example.solid.LSP;

import lombok.Data;

@Data
public class WrongRectangle {

    public int width;
    public int height;

    //직사각형 넓이 반환 함수
    public int getArea() {
        return width * height;
    }
}