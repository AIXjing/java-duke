package com.aixjing.week2;

public class occurence {

//    public int findA (String a, String s, int where){
//        int indexA = s.indexOf(a, where);
//        return indexA;
//    }

    public int howMany (String a, String s){
        int startIndex = 0;
        int count = 0;
        while(true){
            startIndex = s.indexOf(a, startIndex);
            if (startIndex == -1){ break; }
            count += 1;
            startIndex = startIndex + a.length();
        }
        return count;
    }
}
