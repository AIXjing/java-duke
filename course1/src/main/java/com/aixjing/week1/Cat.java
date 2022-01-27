package com.aixjing.week1;

public class Cat extends Animal{
	public Cat(String inputName) {
		super(inputName);
	}

	@Override
	public void say() {
		System.out.println(getName() + " says Miao.miao...");
	}
}
