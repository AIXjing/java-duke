package com.aixjing.week2;

public class Part3 {
    public boolean twoOccurrences(String a, String s){
        int firstIndex = s.indexOf(a);
        int secondIndex = s.indexOf(a, firstIndex + a.length());
        if (secondIndex != -1){
            return true;
        }
        return false;
    }

    public String lastPart(String a, String s) {
        int firstIndex = s.indexOf(a);
        if (firstIndex == -1){
            return s;
        }
        else {
            return s.substring(firstIndex + a.length());
        }
    }
}
