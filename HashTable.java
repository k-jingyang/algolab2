//Class for hash table
import java.util.Arrays;
import java.util.ArrayList;
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
   public ArrayList insertDoubleHashing(int key, String value){
      ArrayList result = new ArrayList(); //[0] = result, [1] = number of searches
      int count = 1;
      int start = HashMapFunction.hashMap(key);
      int hashIncr = HashMapFunction.incrHash(key);
      int index = start;
      while(slots[index]!=null){
         index = HashMapFunction.reHash(index, hashIncr);
         count++;
         if(index == start){
            result.add(0);
            result.add(count);
            return result;
         }
      }
      slots[index] = new HashTableSlot(key, value);
      result.add(1);
      result.add(count);
      return result;
   }

   public ArrayList searchDoubleHashing(int key){
      ArrayList result = new ArrayList(); //[0] = result (String), [1] = number of searches
      int count = 1;
      int start = HashMapFunction.hashMap(key);
      int hashIncr = HashMapFunction.incrHash(key);
      int index = start;
      try{
        while(slots[index].getKey()!=key){
            //
            index = HashMapFunction.reHash(index, hashIncr);
            count++;
            if(index == start){
                result.add(null);
                result.add(count);
                return result;
            }
        }
      }catch(Exception e){
          count++;
          result.add(null);
          result.add(count);
          return result;
      }
      result.add(slots[index].getValue());
      result.add(count);
      return result;
   }



   //Below arer Chain Hashing functions

   //Returns 1 if successful, returns 0 if failure
   public ArrayList insertChainHashing(int key, String value){
      ArrayList result = new ArrayList(); //[0] = result, [1] = number of searches
      int count = 1;
      int index = HashMapFunction.hashMap(key);
      if(slots[index] == null){
         slots[index] = new HashTableSlotChain(key, value, null);
      }
      else{
         HashTableSlotChain p = (HashTableSlotChain)slots[index];
         while(p.getNext()!=null){
            count++;
            p = p.getNext();
         }
         p.setNext(new HashTableSlotChain(key, value, null));
         result.add(1);
         result.add(count);
         return result;
      }
      result.add(0);
      result.add(count);
      return result;
   }

   public ArrayList searchChainHashing(int key){
      ArrayList result = new ArrayList(); //[0] = result (string), [1] = number of searches
      int count = 1;
      int index = HashMapFunction.hashMap(key);
      if(slots[index].getKey()==key){
         result.add(slots[index].getValue());
         result.add(count);
         return result;
      }
      else{
         HashTableSlotChain p = ((HashTableSlotChain)slots[index]).getNext();
         while(p!=null){
            count++;
            if(p.getKey() == key){
                result.add(p.getValue());
                result.add(count);
                return result;
            }
            p = p.getNext();
         }
      }
      result.add(null);
      result.add(count);
      return result;
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