package com.corndel.exercises;

public class Counter{

    private int count;

    // constructor no parameters
    public Counter(){
        this.count = 0;
    }
    // constructor with initialCount parameter
    public Counter(int initialCount ){
        this.count = initialCount;
    }

    public void increment(){
        this.count++;
    }

    public void reset(){
        this.count = 0;
    }

    public int getCount(){
        return this.count;
    }

//    public static void main(String[] args) {
//        Counter counter1 = new Counter();
//        Counter counter2 = new Counter(5);
//        System.out.println(counter1.getCount());
//        System.out.println(counter2.getCount());
//    }

}