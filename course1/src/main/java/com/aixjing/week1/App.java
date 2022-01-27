package com.aixjing.week1;

import edu.duke.FileResource;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {

        // Declare a Cat object/instance variable
        Cat hugo = new Cat("Hugo");
        hugo.run();
        hugo.say();

        Dog jing = new Dog("Jing");
        jing.run();
        jing.say();

        App hello = new App();
        hello.sayHello();

        // System.out.println(hello);
    }


    public void sayHello() {
        FileResource res = new FileResource("week1/hello_unicode.txt");
        for (String line : res.lines()) {
            System.out.println(line);
        }
    }
}

