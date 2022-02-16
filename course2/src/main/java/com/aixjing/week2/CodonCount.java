package com.aixjing.week2;

import java.util.HashMap;
import java.util.Locale;

public class CodonCount {
  private String dna;
  public HashMap<String, Integer> codonMap;

  public CodonCount(String s) {
    this.codonMap = new HashMap<String, Integer>();
    this.dna = s;
  }

  public void buildCodonMap(int start) {
    codonMap.clear();
    dna = dna.toUpperCase();
    String currCodon;
    for (int i = start; i < dna.length(); i += 3) {
      if ((dna.length() - i) >= 3) {
        currCodon = dna.substring(i, i + 3);
      } else {
        break;
      }
      if (!codonMap.containsKey(currCodon)) {
        codonMap.put(currCodon, 1);
      } else {
        codonMap.put(currCodon, codonMap.get(currCodon) + 1);
      }
    }
  }

  public String getMostCommonCodon () {
    int max = 0;
    String commonCodon = "";
    for (String codon: codonMap.keySet()) {
      if (codonMap.get(codon) > max) {
        max = codonMap.get(codon);
        commonCodon = codon;
      }
    }
    return commonCodon;
  }

  public void printedWithin (int num1, int num2) {
    System.out.println("Counts of codons between " + num1 + " and " + num2 + " inclusive are:");
    for (String s: this.codonMap.keySet()) {
      if (this.codonMap.get(s) >= num1 && this.codonMap.get(s) <= num2) {
        System.out.println(s + " " + this.codonMap.get(s));
      }
    }
  }

  public void printOut(int start) {
    this.buildCodonMap(start);
//    for (String codon: this.codonMap.keySet()) {
//      System.out.println(codon + " " + this.codonMap.get(codon));
//    }

    String commonCodon = this.getMostCommonCodon();
    int count = this.codonMap.get(commonCodon);
    System.out.println("The most common codon is " + commonCodon + " for " + count + " occurrences.");

    this.printedWithin(1,5);
  }
}
