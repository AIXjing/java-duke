package com.aixjing.week4;

import edu.duke.ImageResource;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrayScaleConverterTest {
    GrayScaleConverter converter = new GrayScaleConverter();

    @Test
    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = converter.makeGray(ir);
        gray.draw();
        gray.save();
    }

}