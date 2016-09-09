public class HashMapFunction {
    
    //Hash map function takes in a key and returns the index of the slot in the hash table
    public static int hashMap(int key){
        return key % 503;
    }

    public static int incrHash(int key){
        return key % 13;
    }

    public static int reHash(int j, int d){
        return (j + d) % 997;
    }
}