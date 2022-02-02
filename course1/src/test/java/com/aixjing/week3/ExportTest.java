package com.aixjing.week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.junit.Before;
import org.junit.Test;

public class ExportTest {
    static FileResource fr = new FileResource("src/main/resources/week3/exportdata.csv");
    Export export;

    @Before
    public void setup() {
        export = new Export(fr.getCSVParser());
    }

    @Test
    public void exportTests() {
        export.listExporters("coffee");
        System.out.println();

        String result = export.countryInfo("Malawi");
        System.out.println(result);

        export.twoItems("gold", "diamonds");

        int numCountries = export.numCountries("gold");
        System.out.println("number of countries export gold: " + numCountries);
        System.out.println(" ");
    }

    @Test
    public void contryInfoTest() {
        String result = export.countryInfo("Malawi");
        System.out.println(result);
    }

    @Test
    public void twoItemsTest() {
        export.twoItems("cotton", "flowers");
    }

    @Test
    public void numCountriesTest() {
        int numCountries = export.numCountries("cocoa");
        System.out.println("number of countries export gold: " + numCountries);
    }

    @Test
    public void bigExportersTest() {
        export.bigExporters("$999,999,999,999");
    }
}
