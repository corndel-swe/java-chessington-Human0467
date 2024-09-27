package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {

    @Test
    public void RectangleAreaCorrect(){
        Rectangle rectangle = new Rectangle(4, 5);
        double area = rectangle.getArea();
        assertEquals(20, area);
    }

    @Test
    public void RectanglePerimeterCorret(){
        Rectangle rectangle = new Rectangle(1, 8);
        double perimeter = rectangle.getPerimeter();
        assertEquals(18, perimeter);
    }
}
