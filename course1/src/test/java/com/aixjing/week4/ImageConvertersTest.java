package com.aixjing.week4;

import edu.duke.FileResource;
import edu.duke.ImageResource;
import org.junit.Test;

public class ImageConvertersTest {
    // ImageConverters imageConverters = new ImageConverters(new ImageResource());

//    ImageResource inImage = new ImageResource("src/main/resources/week4/babydata/images/astrachan.jpg");

    @Test
    public void makeGaryTest(){
        ImageConverters imageConverters = ImageConverters.openFromPop();
        imageConverters.makeGary();
    }

    @Test
    public void grayBatchTest(){
        ImageConverters.convertBatchToGray();
    }

    @Test
    public void inverseBatchTest(){
        ImageConverters.inverseBatch();
    }
}