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

    public int chainHashingInsert(int key, String value){
        int start = HashMapFunction.hashMap(key);
        int index = start;
        if(slots[index] == null){
            slots[index] = new HashTableSlotChain(key, value, null);
        }
        else{
            HashTableSlotChain p = (HashTableSlotChain)slots[index];
            while(p.getNext()!=null){
                p = p.getNext();
            }
            p.setNext(new HashTableSlotChain(key, value, null));
            return 1;
        }
        return 0;
    }

    public void printChainHashingTable(){
        for(int i = 0; i< slots.length; i++){
            HashTableSlotChain p = (HashTableSlotChain)slots[i];
            while(p!=null){
                System.out.print(p.getKey() + "-" + p.getValue() + "  ");
                p = p.getNext();
            }
            System.out.println();
        }
    }
}