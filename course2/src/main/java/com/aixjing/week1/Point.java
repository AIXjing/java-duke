package com.aixjing.week1;

public class Point {
    // Declaration of two fields: x and y
    // It is also called instance variable.
    private int x;
    private int y;

    // Declaration of a constructor
    // The constructor specifies how to create the object in this class
    public Point(int startx, int starty) {
        this.x = startx;
        this.y = starty;
    }

    // Methods are functions inside the classes.
    public int getX() { return x; }
    public int getY() { return y; }
    public double distance(Point otherPt) {
        int dx = x - otherPt.getX();   // call getX() method on otherPt object
        int dy = y - otherPt.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Declaration of a static method which belongs to this class
    // Excution starts with main before other objects even created.
    public static void main(String[] args) {
        Point p1 = new Point(3,4); // data is created in the heap anytime using 'new'
        Point p2 = new Point(6,8); // Data in the heap will not go away when a function returns destroying its frame.
        System.out.println(p1.distance(p2));
    }
}
