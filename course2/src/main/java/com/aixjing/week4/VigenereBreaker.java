package com.aixjing.week4;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {

    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder slidedText = new StringBuilder();
        char[] messageChars = message.toCharArray();
        for (int i = whichSlice; i < messageChars.length; i = i + totalSlices) {
            slidedText.append(messageChars[i]);
        }
        return slidedText.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++) {
            String slice = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(slice);
        }
        return key;
    }

    public void breakVigenere (FileResource encrypted) {
        //WRITE YOUR CODE HERE
        String text = encrypted.asString();
        int[] key = tryKeyLength(text,38, 'e'); // for known key length and most common letters
        VigenereCipher vigenereCipher = new VigenereCipher(key);
        System.out.println(vigenereCipher.decrypt(text));
    }

    public String breakForLanguage (String encrypted, HashSet<String> dict){
        int wordCountMax = 0;
        String decryption = "";
        int[] keyDecry = new int[100];
        int keyLength = 0;
        for (int keyLen = 1; keyLen < 100; keyLen++) {
            int[] key = tryKeyLength(encrypted, keyLen,'e');
            VigenereCipher vigenereCipher = new VigenereCipher(key);
            String decrypted = vigenereCipher.decrypt(encrypted);
            int wordCount = countWords(decrypted, dict);
            if (wordCount > wordCountMax) {
                decryption = decrypted;
                wordCountMax = wordCount;
                keyDecry = key;
                keyLength = keyLen;
            }
        }
        System.out.println("words count = " + wordCountMax);
        System.out.println("key Length = " + keyLength);
        System.out.println(Arrays.toString(keyDecry));
        return decryption;
    }

    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> dictionary = new HashSet<>();
        for (String line : fr.lines()) {
            dictionary.add(line.toLowerCase());
        }
        return dictionary;
    }

    public int countWords(String message, HashSet<String> dict) {
        int count = 0;
        String[] wordsInMessage = message.split("\\W+");
        for (String word : wordsInMessage) {
            if (dict.contains(word.toLowerCase())) count++;
        }
        return count;
    }
    
}
