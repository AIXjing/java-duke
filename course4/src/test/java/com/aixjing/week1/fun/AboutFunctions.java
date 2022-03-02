package com.aixjing.week1.fun;


import java.util.Locale;
import java.util.function.Function;

public class AboutFunctions {
  public static void main(String[] args) {
    ClassA a = new ClassA("A");
    a.aFunction();
    a.bFunction(input -> {
      System.out.println("Input " + input + " has len: " + input.length());
      return "" + input.length();
    });
    a.bFunction(new PrintStringToUpperFunc());
  }
}

class ClassA {
  String name;

  public ClassA(String name) {
    this.name = name;
  }

  public String aFunction() { // function = method
    System.out.println("aFunction called");
    return name;
  }

  public String bFunction(Function<String, String> func) {
    return func.apply(name);
  }
}

//interface F {
//  String justANameButUnique(String input);
//}

class PrintStringLenFunc implements Function<String, String> {
  @Override
  public String apply(String input) {
    System.out.println("Input " + input + " has len: " + input.length());
    return "" + input.length();
  }
}

class PrintStringToUpperFunc implements Function<String, String>  {
  @Override
  public String apply(String input) {
    System.out.println("Input " + input + " reverse:" + input.toUpperCase());
    return "" + input.length();
  }
}
