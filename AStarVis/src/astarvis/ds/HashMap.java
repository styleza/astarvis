package astarvis.ds;

/**
 * Implementation of hashmap, uses static size data array to store data
 * 
 * @author Ilari
 * @param <T>
 * @param <T2>
 */
public class HashMap<T extends Hashable,T2 extends Object> {
    private static final int DEFAULT_CAPACITY = 15000;
    private Pair<T,T2>[] values;
    
    /**
     * Creates new hashmap with default capacity
     */
    public HashMap(){
        values = new Pair[DEFAULT_CAPACITY];
    }
    
    /**
     * Puts key with value to hashmap, returns true if operation was successful, 
     * false otherwise
     * @param key
     * @param value
     * @return 
     */
    public boolean put(T key, T2 value){
        int i_current = locate(key);
        if(i_current != -1){
            values[i_current] = new Pair<T,T2>(key,value);
            return true;
        }
        int i = hash(key.hashKey());
        for(int i2 = i; i2 < i + DEFAULT_CAPACITY; i2++){
            if(values[i2 % DEFAULT_CAPACITY] == null || values[i2 % DEFAULT_CAPACITY] == key){
                values[i2 % DEFAULT_CAPACITY] = new Pair<T,T2>(key,value);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns value for key if it's in hashmap.
     * Returns null if key was not found
     * @param key
     * @return 
     */
    public T2 get(T key){
        int location = locate(key);
        if(location != -1){
            return values[location].getSecond();
        }
        return null;
    }
    
    /**
     * distributes hashkey to data array
     * @param hashKey
     * @return 
     */
    private int hash(int hashKey){
        return hashKey % DEFAULT_CAPACITY;
    }
    
    /**
     * Locates key, returns index if it was found, otherwise returns -1
     * @param key
     * @return 
     */
    private int locate(T key){
        if(key == null){
            return -1;
        }
        int i = hash(key.hashKey());
        for(int i2 = i; i2 < i + DEFAULT_CAPACITY; i2++){
            if(values[i2 % DEFAULT_CAPACITY] == null){
                break;
            }
            if(values[i2 % DEFAULT_CAPACITY].getFirst() == key){
                return i2 % DEFAULT_CAPACITY;
            }
        }
        return -1;
    }
    
    /**
     * Checks wether key exists in hashmap or not
     * @param key
     * @return 
     */
    public boolean containsKey(T key){
        return locate(key) != -1;
    }
}
