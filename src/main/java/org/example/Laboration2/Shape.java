package org.example.Laboration2;

public abstract class Shape {
    abstract double getArea();
    abstract double getPerimeter();

    public static Circle newCircle(float radius){
        return new Circle(radius);
    }

    public static Rectangle newRectangle(float width, float height){
        return new Rectangle(width, height);
    }
}
