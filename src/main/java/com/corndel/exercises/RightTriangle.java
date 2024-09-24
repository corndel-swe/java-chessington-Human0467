package com.corndel.exercises;

public class RightTriangle implements Shape{
  private double base;
  private double height;

  RightTriangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  public double getBase() {
    return this.base;
  }

  public double getHeight() {
    return this.height;
  }

  public double getHypotenuse() {
    return Math.sqrt(base * base + height * height);
  }

  @Override
  public double getArea() {
    return 0.5*this.base*this.height;
  }

  @Override
  public double getPerimeter() {
    return this.base + this.height +
            Math.sqrt(Math.pow(this.base,2) +
                    Math.pow(this.height,2));
  }
}
