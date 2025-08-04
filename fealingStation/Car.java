package oop;

public class Car {

    public int tankSize = 50;

    public Car (String color) {
        this.color = color; // initializing instance field
    }

    public Car () {

    }

    public String color; // instance field

    public static String brand; // static/class field

    public void printColor() {
        System.out.println("Instance method Printing car color : " + color);
        System.out.println("Instance method Printing car brand : " + brand);
    }

    public static void printBrand() {
        System.out.println("Static method Printing car brand : " + brand);
    }
}
