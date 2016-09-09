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

    public void insertDoubleHashing(int key, int value){
        
    }

    public int insertChainHashing(int key, String value){
        int index = HashMapFunction.hashMap(key);
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

    public String searchChainHashing(int key){
        int index = HashMapFunction.hashMap(key);
        if(slots[index].getKey()==key){
            return slots[index].getValue();
        }
        else{
            HashTableSlotChain p = ((HashTableSlotChain)slots[index]).getNext();
            while(p!=null){
                if(p.getKey() == key){
                    return p.getValue();
                }
                p = p.getNext();
            }
        }
        return null; 
    }

    public void printChainHashing(){
        for(int i = 0; i< slots.length; i++){
            HashTableSlotChain p = (HashTableSlotChain)slots[i];
            while(p!=null){
                System.out.print(p.getKey() + "-" + p.getValue() + "  ");
                p = p.getNext();
            }
            if(slots[i]!=null){
                System.out.println();
            }
        }
    }
}