/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.ds;

/**
 * Pair data strcture
 * @author Ilari
 */
public class Pair<T, T2> {
    private T t;
    private T2 t2;
    
    /**
     * Initializes pair with two datatypes
     * @param t
     * @param t2 
     */
    public Pair(T t, T2 t2){
        this.t = t;
        this.t2 = t2;
    }
    
    /**
     * Returns first data
     * @return 
     */
    public T getFirst(){
        return t;
    }
    
    /**
     * returns second data
     * @return 
     */
    public T2 getSecond(){
        return t2;
    }
    
    /**
     * sets first data
     * @param t 
     */
    public void setFirst(T t){
        this.t = t;
    }
    
    /**
     * sets second data
     * @param t2 
     */
    public void setSecond(T2 t2){
        this.t2 = t2;
    }
}
