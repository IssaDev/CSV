import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
import java.util.Scanner;

/**
 * Write a description of CSV here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSV {
    public void testCountryInfo(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser);
    }
    public void testListofExporters(){
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
      listExportersTwoProducts(parser);
    }
    public void testNumberOfExporters(){
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
      numOfExporters(parser);
    }
    public void testBigExporters(){
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
      bigExporters(parser);
    }
    //Displays export information about selectedcountry
    public void countryInfo(CSVParser c){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Country your want Info for");
        String country = reader.next();
        reader.close();
        boolean found =false;
        for(CSVRecord record : c){
            String aCountry = record.get("Country");
            if(record.get("Country").equals(country)){
                found = true;
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.println(country + ":" + "Major export(s): " + exports + ":" + "valued at " + value);
            }
        }
        if(!found){
                System.out.println("NOT FOUND. Try again with different value");
                testCountryInfo();
            }
    }
    //Outputs country that exports the two items entered
    public void listExportersTwoProducts(CSVParser parser){
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter first export item");
      String exportItem1 = reader.next();
      System.out.println("Enter second export item");
      String exportItem2 = reader.next();
      reader.close();
      boolean found =false;
        for (CSVRecord record : parser){
         String exports  = record.get("Exports");
         if(exports.contains(exportItem1) && exports.contains(exportItem2)){
           found = true;
             System.out.println("Country that exports " + exportItem1  +" and " +" " + exportItem2 + " " +record.get("Country"));
            }
        }
        if(!found){
                System.out.println("NOT FOUND. Try again with different value");
                testListofExporters();
            }
    }
    //Outputs number of countries that exports entered item
    public void numOfExporters(CSVParser parser){
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter export item");
      String exportItem = reader.next();
      boolean found =false;
      reader.close();
        int count = 0;
     for(CSVRecord record : parser){
         String exports  = record.get("Exports");
         if(exports.contains(exportItem)){
           found = true;
             count++;
            }
        }
        if(!found){
                System.out.println("NOT FOUND. Try again with different value");
                testNumberOfExporters();
            }
            else{
              System.out.println("Number of countries that exports " + exportItem + ":" + " " + count);
            }
    }
    //Outputs countries that make more than the amount entered from exports
    public void bigExporters(CSVParser parser){
      Scanner reader= new Scanner(System.in);
      System.out.println("Enter export value");
      String exportvalue = reader.next();
      reader.close();
      boolean found = false;
        for (CSVRecord record : parser){
           String value = record.get("Value (dollars)");
           if(value.length() > exportvalue.length()){
             found = true;
             System.out.println(record.get("Country") + " " +value);
            }
        }
        if(!found){
                System.out.println("No country on this list makes more than " + exportvalue + " " +  "Try again with different value");
                testBigExporters();
            }
    }

}
