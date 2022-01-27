package com.aixjing.week1;

public class Animal {
    // Declare a field for this class
    private String name;
    // xxx = new Animal("hugo")

    // class constructor
    public Animal(String name) {
        this.name = name;
    }

    // Define a method for this class
    // This function returns string type
    public String getName() {
        return "Fancy-name-" + this.name;
    }

    // Define a method for this class
    // This function returns nothing -> void
    public void run() {
        System.out.println(this.name + " am running :)");
    }

    public void say() {
        System.out.println("...");
    }

    public void eat() {
        System.out.println(this.name + "am eating...");
    }
}
