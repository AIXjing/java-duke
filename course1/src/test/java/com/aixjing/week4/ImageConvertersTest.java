package com.aixjing.week4;

import edu.duke.FileResource;
import edu.duke.ImageResource;
import org.junit.Test;

public class ImageConvertersTest {
    // ImageConverters imageConverters = new ImageConverters(new ImageResource());


    @Test
    public void makeGaryTest(){
        ImageConverters imageConverters = new ImageConverters();
        ImageResource inImage = new ImageResource("src/main/resources/week4/babydata/images/astrachan.jpg");
        ImageResource gray = imageConverters.makeGary(inImage);
        String fileName = inImage.getFileName();
        String newFileName = "gray-" + fileName;
        gray.setFileName(newFileName);
        gray.draw();
        gray.save();
    }

}