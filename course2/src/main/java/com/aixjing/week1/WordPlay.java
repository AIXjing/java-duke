package com.aixjing.week1;

public class WordPlay {
    private String phrase;

    public WordPlay (String phrase){
        this.phrase = phrase;
    }
    // check whether the char is vowel
    public boolean isVowel(char ch){
        String vowelsLowercase = "aeiou";
        String vowelsUppercase = "AEIOU";
        if ((vowelsLowercase.indexOf(ch) != -1) || (vowelsUppercase.indexOf(ch) != -1)){ return true; }
        return false;
    }

    // all the vowels in the phrases replaced by ch
    public String replaceVowels(char ch){
        StringBuilder newPhrase = new StringBuilder("");
        char newChar;
        for (int i = 0; i < this.phrase.length(); i++) {
            char currChar = this.phrase.charAt(i);
            if(this.isVowel(currChar)){
                newChar = ch;
            }
            else { newChar = currChar; }

            newPhrase.append(newChar);
        }
        return newPhrase.toString();
    }

    // all the ch in the phrases replaced under conditions
    public String replaceVowelsConditions(char ch){
        StringBuilder newPhrase = new StringBuilder("");
        char newChar;
        for (int i = 0; i < this.phrase.length(); i++) {
            char currChar = this.phrase.charAt(i);
            if(currChar == ch){
                if(i % 2 == 0){
                    newChar = '*';
                }
                else { newChar = '+'; }
            }
            else { newChar = currChar; }
            newPhrase.append(newChar);
        }
        return newPhrase.toString();
    }
}
