public class App {
    public static void main(String[] args){
        HashTable hashTable = new HashTable(1000);
        hashTable.chainHashingInsert(1,"Jing Yang");
        hashTable.chainHashingInsert(2,"Test");
        hashTable.chainHashingInsert(504,"Kheng");
        hashTable.printChainHashingTable();
    }

}