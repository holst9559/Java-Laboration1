package org.example.Laboration2;

import java.awt.image.CropImageFilter;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Shape> shapeList = new ArrayList<>();

        shapeList.add(new Rectangle(2, 4));
        shapeList.add(new Rectangle(4, 8));
        shapeList.add(new Rectangle(8, 12));
        shapeList.add(new Rectangle(10, 14));

        shapeList.add(new Circle(2));
        shapeList.add(new Circle(4));
        shapeList.add(new Circle(7));
        shapeList.add(new Circle(10));

        System.out.println("Unsorted: " + shapeList);
        shapeList.sort(null);
        System.out.println("Sorted: " + shapeList);




    }
}
