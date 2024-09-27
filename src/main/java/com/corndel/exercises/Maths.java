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

    public static double floor(double number){
        double result;
        double decimal = number % 1;

        if(number < 0){
            result = number - (1 + decimal);
        } else {
            result = number - decimal;
        }
        return result;
    }

    public static double ceil(double number){
        double decimal = number % 1;
        double result;

        if (number < 0){
            result = number - decimal;
        } else {
            result = (number + (1 - decimal));
        }
        return decimal == 0.0 ? number : result;
    }

    public static double abs(double number){
        if(number == -0.0){ return 0.0; }
        return number < 0 ? -number : number;
    }
}
