//Class for hash table

public class HashTable {
    private HashTableSlot slots[];

    public HashTable(int size){
        slots = new HashTableSlot[size];
        //for(int i = 0; i<size; i++){
        //    slots[i] = new HashTableSlot();
        //}
    }

    public HashTableSlot[] getHashTable(){
        return this.slots;
    }

    public void doubleHashingInsert(int key, int value){
        
    }

    public void chainHashingInsert(int key, String value){
        HashTableSlotChain slotChain  = new HashTableSlotChain(key, value, null);
        slots[0] = slotChain;
        System.out.println(((HashTableSlotChain) slots[0]).getValue());
    }
}