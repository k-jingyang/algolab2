public class App {
    public static void main(String[] args){
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
        System.out.println(hashTable2.searchDoubleHashing(504));
    }

}