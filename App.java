public class App {
    public static void main(String[] args){
        HashTable hashTable = new HashTable(1000);
        hashTable.insertChainHashing(1,"Jing Yang");
        hashTable.insertChainHashing(2,"Test");
        hashTable.insertChainHashing(504,"Kheng");
        hashTable.printChainHashing();
        System.out.println(hashTable.searchChainHashing(504));
        System.out.println(hashTable.searchChainHashing(503));
    }

}