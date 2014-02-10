package astarvis.ds;

/**
 *
 * @author Ilari
 * @param <T>
 * @param <T2>
 */
public class HashMap<T extends Hashable,T2 extends Object> {
    private static final int DEFAULT_CAPACITY = 2048;
    private Pair<T,T2>[] values;
    
    public HashMap(){
        values = new Pair[DEFAULT_CAPACITY];
    }
    
    public boolean put(T key, T2 value){
        int i = hash(key.hashKey());
        for(int i2 = i; i2 < i + DEFAULT_CAPACITY; i2++){
            if(values[i2 % DEFAULT_CAPACITY] == null || values[i2 % DEFAULT_CAPACITY] == key){
                values[i2 % DEFAULT_CAPACITY] = new Pair<T,T2>(key,value);
                return true;
            }
        }
        return false;
    }
    public T2 get(T key){
        int i = hash(key.hashKey());
        for(int i2 = i; i2 < i + DEFAULT_CAPACITY; i2++){
            if(values[i2 % DEFAULT_CAPACITY] == null){
                break;
            }
            if(values[i2 % DEFAULT_CAPACITY].getFirst() == key){
                return values[i2 % DEFAULT_CAPACITY].getSecond();
            }
        }
        return null;
    }
    
    private int hash(int hashKey){
        return hashKey % DEFAULT_CAPACITY;
    }
}
