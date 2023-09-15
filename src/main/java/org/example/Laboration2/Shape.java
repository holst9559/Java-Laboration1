package org.example.Laboration2;


public abstract class Shape implements Comparable<Shape>{
    abstract double getArea();
    abstract double getPerimeter();

    @Override
    public int compareTo(Shape o) {
        return Double.compare(this.getArea(), o.getArea());
    }

    public static Circle newCircle(float radius){
        return new Circle(radius);
    }

    public static Rectangle newRectangle(float width, float height){
        return new Rectangle(width, height);
    }


}


