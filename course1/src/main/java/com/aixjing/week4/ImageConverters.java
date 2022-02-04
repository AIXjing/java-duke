package com.aixjing.week4;

import edu.duke.*;

import java.awt.*;
import java.io.File;

public class ImageConverters {
    // create a field
    private ImageResource image;

    // create a constructor
//    public ImageConverters(ImageResource image) {
//        this.image = image;
//    }
//
//    public static ImageConverters openFromPop() {
//        return new ImageConverters(new ImageResource());
//    }
//
//    public static ImageConverters openFromFile(File file) {
//        ImageResource image = new ImageResource(file);
//        return new ImageConverters(image);
//    }

    // method to convert image to gray
    public ImageResource makeGary(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel p : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(p.getX(), p.getY());
            int avgPixel = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            p.setRed(avgPixel);
            p.setBlue(avgPixel);
            p.setGreen(avgPixel);
        }
        return outImage;
    }
}
