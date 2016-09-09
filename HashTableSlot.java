//Scenario: ID (key) returns a serial number of an item

//Class for each slot in the hash table
public class HashTableSlot {
    private int key;
    private String value;

    public HashTableSlot(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

    public void setKey(int key){
        this.key = key;
    }

    public void setValue(String value){
        this.value = value;
    }
} 