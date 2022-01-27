package com.aixjing.week1;

import edu.duke.DirectoryResource;
import edu.duke.Point;
import edu.duke.Shape;
import edu.duke.FileResource;

import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter(Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints(Shape s) {
        // Put code here
        int totalPt = 0;
        for(Point p: s.getPoints()){
            totalPt += 1;
        }
        return totalPt;

        // more advanced programming approach
//        return StreamSupport.stream(s.getPoints().spliterator(), false)
//                .count();

    }

    public double getAverageLength(Shape s) {
        // Put code here
        double totLen = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currLen = currPt.distance(prevPt);
            totLen = totLen + currLen;
            prevPt = currPt;
        }
        return totLen / getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double maxLen = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currLen = currPt.distance(prevPt);
            if (currLen > maxLen) {
                maxLen = currLen;
            }
            prevPt = currPt;
        }
        return maxLen;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double prev_x = prevPt.getX();
            double curr_x = currPt.getX();
            if (curr_x > prev_x) {
                largestX = curr_x;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPeri = 0;

        // Create a DirectoryResource
        DirectoryResource folder = new DirectoryResource();
        for (File currFile : folder.selectedFiles()) {
            // Convert the file into a FileResource
            FileResource currFr = new FileResource(currFile);
            // Create a shape object from the FileResource object
            Shape currS = new Shape(currFr);
            // Calculate the shape's perimeter
            double currPeri = getPerimeter(currS);
            if (currPeri > largestPeri) {
                largestPeri = currPeri;
            }
        }
        return largestPeri;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        // Create a DirectoryResource
        double largestPeri = 0;
        File temp = null;
        // Create a DirectoryResource
        DirectoryResource folder = new DirectoryResource();
        for (File currFile : folder.selectedFiles()) {
            // Convert the file into a FileResource
            FileResource currFr = new FileResource(currFile);
            // Create a shape object from the FileResource object
            Shape currS = new Shape(currFr);
            // Calculate the shape's perimeter
            double currPeri = getPerimeter(currS);
            if (currPeri > largestPeri) {
                largestPeri = currPeri;
                temp = currFile;
            }
        }
        return temp.getName();
    }

    public void testPerimeter() {
        FileResource fr = new FileResource("week1/datatest4.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int ptNum = getNumPoints(s);
        double avgLen = getAverageLength(s);
        double maxLen = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("points number = " + ptNum);
        System.out.println("avg side length = " + avgLen);
        System.out.println("The largest side = " + maxLen);
        System.out.println("The largest X = " + largestX);
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        // Call getLargestPerimeterMultipleFiles() method
        double perimeterMultipleFiles = getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter in multiple files: " + perimeterMultipleFiles);

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName = getFileWithLargestPerimeter();
        System.out.println("The largest perimeter is in " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0, 0));
        triangle.addPoint(new Point(6, 0));
        triangle.addPoint(new Point(3, 6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = " + peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();

        PerimeterAssignmentRunner pr2 = new PerimeterAssignmentRunner();
        pr2.testPerimeterMultipleFiles();

//        PerimeterAssignmentRunner pr3 = new PerimeterAssignmentRunner();
//        pr3.testFileWithLargestPerimeter();
    }
}
