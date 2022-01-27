package com.aixjing.week1;

import edu.duke.FileResource;
import edu.duke.Shape; // https://www.dukelearntoprogram.com//course2/doc/javadoc/index.html?course=2
// can I import my own Point class?
import edu.duke.Point;

public class PerimeterRunner {
    // Declare getPerimeter() PerimeterRunner object
    public double getPerimeter (Shape s) {
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();

        for(Point currPt: s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }

        return totalPerim;
    }

    // Declare testPerimeter() for PerimeterRunner object
    public void testPerimeter () {
        FileResource fr = new FileResource("week1/example-2.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }

}


