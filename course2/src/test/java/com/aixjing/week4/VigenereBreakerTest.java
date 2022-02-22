package com.aixjing.week4;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.HashSet;

public class VigenereBreakerTest {
  VigenereBreaker vBreaker = new VigenereBreaker();

  @Test
  public void sliceStringTest() {
    String slice = vBreaker.sliceString("abcdefghijklm", 4, 5);
    System.out.println(slice);
  }

  @Test
  public void tryKeyLengthTest() {
    FileResource fr = new FileResource("week4/messages/secretmessage1.txt");
    String testText = fr.asString();
    int keyLen = 4;
    int[] key = vBreaker.tryKeyLength(testText, keyLen, 'e');
    for (int i = 0; i < keyLen; i++) {
      System.out.print(key[i] + " ");
    }
  }

  @Test
  public void breakVigenereTest() {
      vBreaker.breakVigenere(new FileResource("week4/messages/secretmessage1.txt"));
  }

  @Test
  public void dictTest() {
    HashSet<String> dict = vBreaker.readDictionary(new FileResource("week4/dictionaries/English"));
    FileResource fr = new FileResource("week4/VigenereTestData/athens_keyflute.txt");
    String message = fr.asString();
    int count = vBreaker.countWords(message, dict);
    System.out.println(count);
  }

  @Test
  public void breakForLanguageTest () {
    HashSet<String> dict = vBreaker.readDictionary(new FileResource("week4/dictionaries/English"));
    FileResource fr = new FileResource("week4/messages/secretmessage2.txt");
    String decryption = vBreaker.breakForLanguage(fr.asString(), dict);
    System.out.println(decryption);
  }

  @Test
  public void countWordsTest() {
    HashSet<String> dict = vBreaker.readDictionary(new FileResource("week4/dictionaries/English"));
    FileResource fr = new FileResource("week4/messages/secretmessage2.txt");
    String encrypted = fr.asString();
    int[] key = vBreaker.tryKeyLength(encrypted,38,'e');
    VigenereCipher vigenereCipher = new VigenereCipher(key);
    String decrypted = vigenereCipher.decrypt(encrypted);
    int count = vBreaker.countWords(decrypted, dict);
    System.out.println(count);
  }

  @Test
  public void mostCommonCharInTest () {
    HashSet<String> dict = vBreaker.readDictionary(new FileResource("week4/dictionaries/English"));
    char commonCharInEnglish = vBreaker.mostCommonCharIn(dict);
    System.out.println("The most common letter in English is " + commonCharInEnglish);
  }

  @Test
  public void readLanguagesTest() {
    vBreaker.readLanguages();
  }

  @Test
  public void breakForAllTest() {
    FileResource fr = new FileResource("week4/messages/secretmessage4.txt");
    String message = fr.asString();
    System.out.println(vBreaker.breakForAll(message));
  }

}
