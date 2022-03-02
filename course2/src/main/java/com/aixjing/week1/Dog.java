package com.aixjing.week1;

public class Dog extends Animal{
    public Dog(String inputName) {
        super(inputName);
    }

    @Override
    public void say() {
        System.out.println(this.getName() + " says Wong....");
    }
}
