package com.aixjing.week3;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.List;
import java.util.stream.Collectors;

public class Export {
    // Declare a field for this class
    private List<CSVRecord> csvRecords;

    // Construct the field to the class
    public Export(CSVParser parser) {
        this.csvRecords = parser.stream().collect(Collectors.toList());
    }

    public void listExporters(String good){
        for(CSVRecord record : csvRecords){ // parser consumed
            String export = record.get("Exports");
            if(export.contains(good)){
                System.out.println("Country: " + record.get("Country"));
            }
        }
    }

    public String countryInfo(String country){
        for(CSVRecord record: csvRecords){
            if(record.get("Country").equals(country)){
                String goods = record.get("Exports");
                String value = record.get("Value (dollars)");
                if(!goods.isEmpty() || !value.isEmpty()){
                    return country + ": " + goods + ", " + value;
                }
                return "NOT FOUND";
            }
        }
        return "No such country";
    }

    public void twoItems(String item1, String item2){
        for(CSVRecord record : csvRecords){
            String exports = record.get("Exports");
            if(exports.contains(item1) && exports.contains(item2)){
                System.out.println("Country: " + record.get("Country"));
            }
        }
    }

    public int numCountries(String item){
        int count = 0;
        for(CSVRecord record: csvRecords){
            if(record.get("Exports").contains(item))
                count += 1;
        }
        return count;
    }

    public void bigExporters(String amount){
        System.out.println("Countries exports more than " + amount + ": ");
        for(CSVRecord record : csvRecords){
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length()){
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }
}
