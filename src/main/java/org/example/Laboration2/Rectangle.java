package org.example.Laboration2;

import java.util.Objects;

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
        return width * height;
    }

    @Override
    double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(width, rectangle.width) == 0 && Float.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }


}
