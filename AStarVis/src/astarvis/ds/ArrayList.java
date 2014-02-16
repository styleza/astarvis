package astarvis.ds;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Own implementation of ArrayList
 * @author Ilari
 */
public class ArrayList<T> implements Iterable<T> {
    private Object[] data;
    private int size;
    
    /**
     * Initialize empty ArrayList
     */
    public ArrayList(){
        size = 0;
        data = new Object[10];
    }
    
    /**
     * Initialize ArrayList from array of objects
     * @param e 
     */
    public ArrayList(Object[] e){
        this();
        for(Object i : e){
            this.add((T)i);
        }
    }
    
    /**
     * Ensure capacity for given size
     * @param minCap 
     */
    public void ensureCapacity(int minCap){
        if(minCap > data.length){
            int newCapa = (data.length * 3)/ 2 +1;
            if(newCapa < minCap){
                newCapa = minCap;
            }
            data = Arrays.copyOf(data, newCapa);
        }
    }
    
    /**
     * Get number of elements in ArrayList
     * @return 
     */
    public int size(){
        return this.size;
    }
    
    /**
     * Get element by index
     * @param index
     * @return 
     */
    public T get(int index){
        if(!rangeCheck(index)){
            return null;
        }
        return (T)data[index];
    }
    
    /**
     * Check wether index is valid or not
     * @param i
     * @return 
     */
    private boolean rangeCheck(int i){
        return i >= 0 && i < size;
    }
    
    /**
     * Add element to ArrayList
     * @param e 
     */
    public void add(T e){
        ensureCapacity(size + 1);
        data[size++] = e;
    }
    
    /**
     * Return element index in ArrayList
     * @param e
     * @return 
     */
    public int indexOf(T e){
        for(int i = 0; i < size; i++){
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Checks wether Object is in ArrayList or not
     * @param e
     * @return 
     */
    public boolean contains(T e){
        return indexOf(e) != -1;
    }
    
    /**
     * Returns Array from index 0 to index c in ArrayList
     * @param c
     * @return 
     */
    public Object[] subList(int c){
        return Arrays.copyOf(data, c);
    }

    /**
     * Iterator for foreach loops
     * @return 
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int ci = 0;
            
            /**
             * Checks if ArrayList has next element 
             * @return 
             */
            public boolean hasNext(){
                return ci < size;
            }
            
            /**
             * Returns next element and moves iterator forward
             * @return 
             */
            public T next(){
                return (T)data[ci++];
            }
            
            /**
             * Does nothing
             */
            public void remove(){
                
            }
        };
    }
    
    /**
     * Sets element to position i if i is valid
     * @param i
     * @param e 
     */
    public void set(int i,T e){
        if(rangeCheck(i)){
            data[i] = e;
        }
    }
    
    /**
     * Checks if ArrayList is empty
     * @return 
     */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /**
     * Remove i-th element
     * @param i 
     */
    public void remove(int i){
        if(!rangeCheck(i)) return;
        for(int i2 = i; i2 < size -1; i2++){
            data[i2] = data[i2+1];
        }
        data[size - 1] = null;
        size--;
    }
    
}
