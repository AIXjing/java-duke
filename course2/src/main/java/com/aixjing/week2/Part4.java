package com.aixjing.week2;

import edu.duke.URLResource;

import java.util.Locale;

public class Part4 {
    public String findYT(URLResource ur){
        for (String line : ur.lines()){
            String lineLower = line.toLowerCase();
            int ytIndex = lineLower.indexOf("youtube");
            if(ytIndex != -1){
                int firstQuoteIndex = lineLower.lastIndexOf("\"", ytIndex);
                int lastQuoteIndex = lineLower.indexOf("\"", ytIndex + 1);
                System.out.println(line.substring(firstQuoteIndex + 1, lastQuoteIndex));
            }

        }
        return "";
    }
}
