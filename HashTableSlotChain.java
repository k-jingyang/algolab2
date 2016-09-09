//Linked list
public class HashTableSlotChain extends HashTableSlot{
    private HashTableSlotChain next;
    public HashTableSlotChain(int key, String value, HashTableSlotChain next) {
        super(key, value);
        this.next = next;
    }

    public HashTableSlotChain getNext(){
        return next;
    }

    public void setNext(HashTableSlotChain next){
        this.next = next;
    }

}