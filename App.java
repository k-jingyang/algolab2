import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
   public static void main(String[] args){
      String csvFile = System.getProperty("user.dir") + "\\namelist.csv";
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";
   
      HashTable hashTable1 = new HashTable(1000);
      HashTable hashTable2 = new HashTable(1000);
      long startTime = System.nanoTime();
   
      try {
      
         br = new BufferedReader(new FileReader(csvFile));
         while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] list = line.split(cvsSplitBy);
           // System.out.println("Namelist [id= " + list[0] + ", name= " + list[1] + "]");
            hashTable1.insertChainHashing(Integer.parseInt(list[0]), list[1]);
         
         }
      
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      } 
      catch (IOException e) {
         e.printStackTrace();
      } 
      finally {
         if (br != null) {
            try {
               br.close();
            } 
            catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      System.out.println("Chain Hashing set-up time= " +((System.nanoTime()-startTime)/1000) + " microseconds");
      startTime = System.nanoTime();
   
      try {
      
         br = new BufferedReader(new FileReader(csvFile));
         while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] list = line.split(cvsSplitBy);
           // System.out.println("Namelist [id= " + list[0] + ", name= " + list[1] + "]");
            hashTable2.insertDoubleHashing(Integer.parseInt(list[0]), list[1]);
         
         }
      
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      } 
      catch (IOException e) {
         e.printStackTrace();
      } 
      finally {
         if (br != null) {
            try {
               br.close();
            } 
            catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      System.out.println("Chain Hashing set-up time= " +((System.nanoTime()-startTime)/1000) + " microseconds");
      startTime = System.nanoTime();
      System.out.println(hashTable1.searchChainHashing(504)); 
      System.out.println("Chain Hashing search time= " +((System.nanoTime()-startTime)/1000) + " microseconds");
      startTime = System.nanoTime();
     System.out.println(hashTable1.searchDoubleHashing(505)); // <---error line
      System.out.println("Double Hashing search time= " +((System.nanoTime()-startTime)/1000) + " microseconds");

      //hashTable2.printHashTable();
       //System.out.println("Printing Table:");
      //hashTable1.printChainHashing();
   /*
      System.out.println("CHAINED HASHING");
      System.out.println("===============");
      HashTable hashTable1 = new HashTable(1000);
      hashTable1.insertChainHashing(1,"Jing Yang");
      hashTable1.insertChainHashing(2,"Test");
      hashTable1.insertChainHashing(504,"Hello");
      System.out.println("Printing Table:");
      hashTable1.printChainHashing();
      System.out.println("Searching Table:");
      System.out.println(hashTable1.searchChainHashing(504));
   
      System.out.println();
   
      System.out.println("DOUBLE HASHING");
      System.out.println("==============");
      HashTable hashTable2 = new HashTable(1000);
      hashTable2.insertDoubleHashing(1,"Jing Yang");
      hashTable2.insertDoubleHashing(2,"MOMOMO");
      hashTable2.insertDoubleHashing(504,"HELLLOOOO");
      System.out.println("Printing Table:");
      hashTable2.printHashTable();
      System.out.println("Searching Table:");
      System.out.println(hashTable2.searchDoubleHashing(504));*/
   }

}