package org.example.Laboration2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(Shape.newRectangle(2, 4));
        shapeList.add(Shape.newRectangle(4, 8));
        shapeList.add(Shape.newRectangle(8, 12));
        shapeList.add(Shape.newRectangle(10, 14));

        shapeList.add(Shape.newCircle(2));
        shapeList.add(Shape.newCircle(4));
        shapeList.add(Shape.newCircle(7.5f));
        shapeList.add(Shape.newCircle(10));

        System.out.println("Unsorted: " + shapeList);
        shapeList.sort(null);
        System.out.println("Sorted: " + shapeList);




    }
}
