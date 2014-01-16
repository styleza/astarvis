/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.ds;

/**
 *
 * @author Ilari
 */
public class Pair<T, T2> {
    private T t;
    private T2 t2;
    
    public Pair(T t, T2 t2){
        this.t = t;
        this.t2 = t2;
    }
    
    public T getFirst(){
        return t;
    }
    
    public T2 getSecond(){
        return t2;
    }
    
    public void setFirst(T t){
        this.t = t;
    }
    
    public void setSecond(T2 t2){
        this.t2 = t2;
    }
}
