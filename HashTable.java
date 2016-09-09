//Class for hash table
import java.util.Arrays;
public class HashTable {
   private HashTableSlot slots[];

   public HashTable(int size){
      slots = new HashTableSlot[size];
      //for(int i = 0; i<size; i++){
      //    slots[i] = new HashTableSlot();
      //}
   }
   public void clearTable(){
      Arrays.fill(slots, null);
   }
   public HashTableSlot[] getHashTable(){
      return this.slots;
   }

   //Does not print the chained keys and values
   public void printHashTable(){
      for(int i = 0; i< slots.length; i++){
         if(slots[i]!=null){
            System.out.println(slots[i].getKey() + "-" + slots[i].getValue() + "  ");
         }
      }
   }

   //Below are Double Hashing functions

   //Returns 1 if successful, returns 0 if failure
   public int insertDoubleHashing(int key, String value){
      int start = HashMapFunction.hashMap(key);
      int hashIncr = HashMapFunction.incrHash(key);
      int index = start;
      while(slots[index]!=null){
         index = HashMapFunction.reHash(index, hashIncr);
         if(key == 505){
         }
         if(index == start){
            return 0;
         }
      }
      slots[index] = new HashTableSlot(key, value);
      return 1;
   }

   public String searchDoubleHashing(int key){
      int start = HashMapFunction.hashMap(key);
      int hashIncr = HashMapFunction.incrHash(key);
      int index = start;
      while(slots[index].getKey()!=key){
         index = HashMapFunction.reHash(index, hashIncr);
         if(index == start){
            return null;
         }
      }
      return slots[index].getValue();
   }



   //Below arer Chain Hashing functions

   //Returns 1 if successful, returns 0 if failure
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