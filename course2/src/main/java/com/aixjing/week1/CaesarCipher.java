package com.aixjing.week1;

import com.google.common.base.Preconditions;

public class CaesarCipher {
    public static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";

    /**
     * This method encrypt input string with an int key
     * @param key an int between 0 to 25
     * @param input a String
     * @return
     */
    public static String encryptString(int key, final String input) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            char newChar = encryptChar(currChar, key);
            encrypted.append(newChar);
        }
        return encrypted.toString();
    }

    public static String encryptTwoKeys(int key1, int key2, final String input) {
        StringBuilder encrypted = new StringBuilder();
        char newChar;
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (i % 2 == 0) {
                newChar = encryptChar(currChar, key1);
            } else {
                newChar = encryptChar(currChar, key2);
            }
            encrypted.append(newChar);
        }
        return encrypted.toString();
    }


    // encrypt a single char including both uppercase and lowercase
    private static char encryptChar(char currChar, int keyRaw) {
        Preconditions.checkArgument(keyRaw >=0, "Key must not be negative.", keyRaw);

        char newChar;
        String shiftedAlphabet;
        int index;
        int key = keyRaw % 26;

        if (Character.isAlphabetic(currChar)) {
            if (Character.isLowerCase(currChar)) {
                shiftedAlphabet = ALPHABETS.substring(key) + ALPHABETS.substring(0, key);
                index = ALPHABETS.indexOf(currChar);
            } else {
                String alphabetUpperCase = ALPHABETS.toUpperCase();
                shiftedAlphabet = alphabetUpperCase.substring(key) + alphabetUpperCase.substring(0, key);
                index = alphabetUpperCase.indexOf(currChar);
            }
            newChar = shiftedAlphabet.charAt(index);
        } else {
            newChar = currChar;
        }
        return newChar;
    }
}
