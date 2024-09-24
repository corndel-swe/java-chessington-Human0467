package com.corndel.exercises;

public class Circle implements Shape{
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double getArea() {
    return Maths.PI * this.radius * this.radius;
  }

  @Override
  public double getPerimeter() {
    return Maths.PI * 2 * this.radius;
  }
}
