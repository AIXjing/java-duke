package com.aixjing.week4;

import edu.duke.*;

import java.awt.*;
import java.io.File;

public class ImageConverters {
    // create a field
    ImageResource image;

    // create a constructor
    public ImageConverters(ImageResource image) {
        this.image = image;
    }

    public static ImageConverters openFromPop() {
        return new ImageConverters(new ImageResource());
    }

    public static ImageConverters openFromFile(File file) {
        ImageResource image = new ImageResource(file);
        return new ImageConverters(image);
    }

    // method to convert image to gray
    public void makeGary() {
        ImageResource outImage = new ImageResource(this.image.getWidth(), this.image.getHeight());
        for (Pixel p : outImage.pixels()) {
            Pixel inPixel = this.image.getPixel(p.getX(), p.getY());
            int avgPixel = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            p.setRed(avgPixel);
            p.setBlue(avgPixel);
            p.setGreen(avgPixel);
        }
        setNewName(this.image, outImage, "gray-");
        outImage.draw();
        outImage.save();
    }

    // set new name with prefix
    public void setNewName(ImageResource inImage, ImageResource outImage, String prefix) {
        String inName = inImage.getFileName();
        String outName = prefix + inName;
        outImage.setFileName(outName);
    }

    // to convert a batch of images into gray scale
    public static void convertBatchToGray() {
        DirectoryResource Dr = new DirectoryResource();
        for (File file : Dr.selectedFiles()) {
            ImageConverters singleImageConverter = ImageConverters.openFromFile(file);
            singleImageConverter.makeGary();
        }
    }

    // inverse image color
    public void imageInverse() {
        ImageResource outImage = new ImageResource(this.image.getWidth(), this.image.getHeight());
        for (Pixel p : outImage.pixels()) {
            Pixel inPixel = this.image.getPixel(p.getX(), p.getY());
            p.setRed(255 - inPixel.getRed());
            p.setGreen(255 - inPixel.getGreen());
            p.setBlue(255 - inPixel.getBlue());
        }
        setNewName(this.image, outImage, "Inv-");
        outImage.draw();
        outImage.save();
    }

    // inverse color for image batch
    public static void inverseBatch() {
        DirectoryResource Dr = new DirectoryResource();
        for (File file : Dr.selectedFiles()) {
            ImageConverters singleImageConverter = ImageConverters.openFromFile(file);
            singleImageConverter.imageInverse();
        }
    }
}
