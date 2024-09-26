package com.corndel.exercises;

public class Maths {
    public static double PI = 3.14;

    public static double max(double a, double b){
        return a > b ? a : b;
    }

    public static double round(double number){
        double result;
        double decimal = number % 1;

        if(decimal < 0.5){
            result = number - decimal;
        } else {
            result = number + (1 - decimal);
        }
        return result;
    }
}
