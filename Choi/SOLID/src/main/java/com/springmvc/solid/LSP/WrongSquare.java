package com.springmvc.solid.LSP;

public class WrongSquare extends WrongRectangle {

    @Override
    public void setWidth(int Width) {
        super.setWidth(width);
        super.setHeight(getWidth());
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(getHeight());
    }

}
