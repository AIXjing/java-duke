package com.aixjing.week1;

import com.google.common.base.Preconditions;

public class CaeserCipherComb {
    private static int mainKey;
    private static String alph = "abcdefghijklmnopqrstuvwxyz";
    private static String shiftedAlph;

    CaeserCipherComb(int key) {
        Preconditions.checkArgument(key >=0, "Key must not be negative.", key);
        key = key % 26;
        this.mainKey = key;
        this.shiftedAlph = this.alph.substring(key) + this.alph.substring(0,key);
    }

    // to encrypt an input with a given key
    public static String encrypt (String input) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            char newChar = encryptChar(currChar);
            encrypted.append(newChar);
        }
        return encrypted.toString();
    }

    // to decrypt an encrypted method
    public String decrypt (String encrypted) {
        CaeserCipherComb cc = new CaeserCipherComb(26 - mainKey);
        String decrypted = cc.encrypt(encrypted);
        return decrypted;
    }

    // break an encrypted string without knowing key
    public String breakCipher(String encrypted) {
        int key = getKey(encrypted);
        CaeserCipherComb cc = new CaeserCipherComb(26 - key);
        String decrypted = cc.encrypt(encrypted);
        return decrypted;
    }


    // find the index of the most letter in the input
    public static int getKey (String input) {
        int[] counts = countLetters(input);
        int max = 0;
        int indexOfMax = 0;
        for (int index = 0; index < counts.length; index++) {
            if (max < counts[index]) {
                max = counts[index];
                indexOfMax = index;
            }
        }
        int key = (26 + (indexOfMax - 4)) % 26;
        return key;
    }

    // encrypt a single char including both uppercase and lowercase
    private static char encryptChar(char currChar) {
        char newChar;
        int index;
        if (Character.isAlphabetic(currChar)) {
            if (Character.isLowerCase(currChar)) {
                index = alph.indexOf(currChar);
                newChar = shiftedAlph.charAt(index);
            }
            else {
                char currCharLowCase = Character.toLowerCase(currChar);
                index = alph.indexOf(currCharLowCase);
                char newCharLowCase = shiftedAlph.charAt(index);
                newChar = Character.toUpperCase(newCharLowCase);
            }
        } else {
            newChar = currChar;
        }
        return newChar;
    }

    // a method to count the most letters and find key
    private static int[] countLetters (String input) {
        String text = input.toLowerCase();
        int[] counts = new int[26];
        for (int k = 0; k < text.length(); k++){
            char currChar = text.charAt(k);
            int index = alph.indexOf(currChar);
            if (index != -1){ counts[index] += 1; }
        }
        return counts;
    }


}
