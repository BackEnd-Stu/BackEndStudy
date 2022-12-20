package com.example.solid.LSP;

public class Shape {

    public int width;
    public int height;

    // 너비 반환, Width Getter
    public int getWidth() {
        return width;
    }
    // 너비 할당, Width Setter
    public void setWidth(int width) {
        this.width = width;
    }

    // 높이 반환, Height Getter
    public int getHeight() {
        return height;
    }
    // 높이 할당, Height Setter
    public void setHeight(int height) {
        this.height = height;
    }

    // 사각형 넓이 반환
    public int getArea() {
        return width * height;
    }
}
