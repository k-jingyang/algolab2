import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
   public static void main(String[] args){
      testRun(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
      //testRun(300, 150);
      //testRun(500, 250);
      //testRun(700, 350);
      //testRun(1000, 555);
   }
   
   public static void testRun(int size, int searchInt){
      String csvFile = System.getProperty("user.dir") + "\\namelist.csv";
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";
   
      HashTable hashTable1 = new HashTable(1000);
      HashTable hashTable2 = new HashTable(1000);
      long startTime;
      int count=1000;        //number of loops
      //int searchInt= 355;  //key to be searched
      int timeTaken1=0;
      int timeTaken2=0;
      int searchTaken1=0;
      int searchTaken2=0;
      int timeTaken=0;
      int j=0;
      for(int i =0; i <count; i ++){
         hashTable1.clearTable();
         hashTable2.clearTable();
         try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null && j<size) {
            
               String[] list = line.split(cvsSplitBy);
               startTime = System.nanoTime();
               hashTable1.insertChainHashing(Integer.parseInt(list[0]), list[1]);
               timeTaken += (System.nanoTime()-startTime);
               j++;
            }
         }
         catch (FileNotFoundException e) {e.printStackTrace();}
         catch (IOException e) { e.printStackTrace(); } 
         finally {
            if (br != null) {
               try { br.close(); }  
               catch (IOException e) {e.printStackTrace(); }}
         }
         j=0;
         timeTaken1+=timeTaken;
         //System.out.println("Chain Hashing set-up time= " +timeTaken/1000 + " microseconds");
         timeTaken =0;
         try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null && j<size) {
               String[] list = line.split(cvsSplitBy);
               startTime = System.nanoTime();
               hashTable2.insertDoubleHashing(Integer.parseInt(list[0]), list[1]);
               timeTaken += (System.nanoTime()-startTime);
               j++;
            }
         }
         catch (FileNotFoundException e) {e.printStackTrace();}
         catch (IOException e) { e.printStackTrace(); } 
         finally {
            if (br != null) {
               try { br.close(); }  
               catch (IOException e) {e.printStackTrace(); }}
         }
         j=0;
         timeTaken2+=timeTaken;
         //System.out.println("Double Hashing set-up time= " +timeTaken/1000 + " microseconds");
         timeTaken=0;
               
      //hashTable1.printChainHashing();
      }
      timeTaken1/=count;
      timeTaken2/=count;
      System.out.println("Time stats for " +size + " sized data set, with search term " +searchInt);
      System.out.println("Chain Hashing set-up time=\t " +timeTaken1/1000 + " MICROseconds");
      System.out.println("Double Hashing set-up time=\t " +timeTaken2/1000 + " MICROseconds");
      timeTaken = timeTaken1 = timeTaken2 = 0;
      //String chain;// doubleh;
      ArrayList doubleh = new ArrayList();
      ArrayList chain = new ArrayList();
      boolean errorFlag1 = false;
      boolean errorFlag2 = false;
      for(int i =0; i <count; i ++){
         startTime = System.nanoTime();
         chain = hashTable1.searchChainHashing(searchInt);
         searchTaken1 = (int)chain.get(1);
         if(chain.get(0)==null){
               errorFlag1 = true;
         }
         timeTaken1 += (System.nanoTime()-startTime);
         startTime = System.nanoTime();
         doubleh = hashTable2.searchDoubleHashing(searchInt);
         searchTaken2+= (int)doubleh.get(1);
         if(doubleh.get(0)==null){
               errorFlag2 = true;
         }
         timeTaken2 += (System.nanoTime()-startTime);
      }
      timeTaken1/=count;
      timeTaken2/=count;
      searchTaken2/=count;
      if(errorFlag1==true){
            System.out.println("\nCHAIN HASHING SEARCH FAIL");
      }
	  else{
		  System.out.println("\nCHAIN HASHING SEARCH SUCCESSFUL");
	  }
      System.out.println("Chain Hashing search time=\t " +timeTaken1 + " NANOseconds");
      System.out.println("Chain Hashing searches count=\t " +searchTaken1+ " times");
      if(errorFlag2==true){
           System.out.println("\nDOUBLE HASHING SEARCH FAIL");
      }
	  else{
		  System.out.println("\nDOUBLE HASHING SEARCH SUCCESSFUL");
	  }
      System.out.println("Double Hashing search time=\t " +timeTaken2+ " NANOseconds");
      System.out.println("Double Hashing searches count=\t " +searchTaken2+ " times");
   }
}
