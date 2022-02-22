package com.aixjing.week4;

import edu.duke.FileResource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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

    // return a key (int array) if key length is known
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++) {
            String slice = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(slice);
        }
        return key;
    }

    public void breakVigenere (FileResource fileResource) {
        //WRITE YOUR CODE HERE

//      // Add to do //
        String encrypted = fileResource.asString();
        int[] key = tryKeyLength(encrypted,38, 'e'); // for known key length and most common letters
        VigenereCipher vigenereCipher = new VigenereCipher(key);
        System.out.println(vigenereCipher.decrypt(encrypted));
    }

    public String breakForAll (String encrypted) {
        HashMap<String, HashSet<String>> languages = readLanguages();
        String decryption = "";
        int wordCountMax = 0;
        String detectedLanguage = "";
        // iterate over all language dictionaries
        for (String language: languages.keySet()) {
            System.out.print(language + " - ");
            HashSet<String> dict = languages.get(language);
            int wordCount = countWordInLanguage(encrypted, dict);
            System.out.print(" - words count " + wordCount);
            breakForLanguage(encrypted,dict);
            if (wordCountMax < wordCount) {
                wordCountMax = wordCount;
                decryption = breakForLanguage(encrypted,dict);
                detectedLanguage = language;
            }
            System.out.println();
        }
        System.out.println("Detected language is " + detectedLanguage);
        System.out.println("Total word count is " + wordCountMax);
        System.out.println();
        return decryption;
    }


    public String breakForLanguage(String encrypted, HashSet<String> dict){
        char mostCommonLetter = mostCommonCharIn(dict);
        int wordCountMax = 0;
        String decryption = "";
        int[] optimalKey = new int[100];
        int optimalKeyLength = 0;
        // try keyLen between 1 and 99
        for (int keyLen = 1; keyLen < 100; keyLen++) {
            int[] key = tryKeyLength(encrypted, keyLen, mostCommonLetter);
            VigenereCipher vigenereCipher = new VigenereCipher(key);
            String decrypted = vigenereCipher.decrypt(encrypted);
            int wordCount = countWords(decrypted, dict);
            if (wordCount > wordCountMax) {
                decryption = decrypted;
                wordCountMax = wordCount;
                optimalKey = key;
                optimalKeyLength = keyLen;
            }
        }
//        System.out.print(" - words count " + wordCountMax + " - ");
        System.out.print(" - key Length = " + optimalKeyLength);
        System.out.print(" - key: " + Arrays.toString(optimalKey));
        return decryption;
    }

    // the same method as breakForLanguage but returns the word count
    public int countWordInLanguage(String encrypted, HashSet<String> dict){
        char mostCommonLetter = mostCommonCharIn(dict);
        int wordCountMax = 0;
        // try keyLen between 1 and 99
        for (int keyLen = 1; keyLen < 100; keyLen++) {
            int[] key = tryKeyLength(encrypted, keyLen, mostCommonLetter);
            VigenereCipher vigenereCipher = new VigenereCipher(key);
            String decrypted = vigenereCipher.decrypt(encrypted);
            int wordCount = countWords(decrypted, dict);
            if (wordCount > wordCountMax) {
                wordCountMax = wordCount;
            }
        }
        return wordCountMax;
    }

    public char mostCommonCharIn (HashSet<String> dict) {
        String alphabet = CaesarCipher.alphabet.toLowerCase();
        int[] countChar = new int[26];
        for (String word : dict) {
            word = word.toLowerCase();
            for (char ch : word.toCharArray()) {
                int index = alphabet.indexOf(ch);
                if (index != -1) countChar[index]++;
            }
        }
        int max = 0;
        int indexOfMax = 0;
        for (int i = 0; i < countChar.length; i++) {
            if (countChar[i] > max) {
                max = countChar[i];
                indexOfMax = i;
            }
        }
        return alphabet.charAt(indexOfMax);
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

    public HashMap<String, HashSet<String>> readLanguages () {
        HashMap<String, HashSet<String>> languageDict = new HashMap<>();
        String[] labels = {"Danish","Dutch", "English", "French", "German", "Italian", "Portuguese", "Spanish"};
        String dir = "week4/dictionaries/";
        for (String label : labels) {
            FileResource fr = new FileResource(dir + label);
            languageDict.put(label, readDictionary(fr));
//            System.out.println(label);
        }
        return languageDict;
    }
    
}
