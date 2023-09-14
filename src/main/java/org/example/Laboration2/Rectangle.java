package org.example.Laboration2;

public class Rectangle extends Shape {

    private float width;
    private float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(float width){
        if(width < 0.0){
            this.width = 0.0f;
        }else
            this.width = width;
    }

    public void setHeight(float height){
        if(height < 0.0){
            this.height = 0.0f;
        }else
            this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    double getArea() {
        return 0;
    }

    @Override
    double getPerimeter() {
        return 0;
    }
}
