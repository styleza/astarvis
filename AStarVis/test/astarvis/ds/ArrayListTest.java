/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.ds;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import astarvis.ds.ArrayList;

/**
 *
 * @author Ilari
 */
public class ArrayListTest {
    ArrayList<Object> t;
    
    public ArrayListTest() {
    }
    
    @Before
    public void setUp() {
        t = new ArrayList();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testBasic(){
        assertEquals(0,t.size());
        
        Object a = new Object();
        t.add(a);
        
        assertSame(a,t.get(0));
    }
    
    @Test
    public void testOutOfRange(){
        assertNull(t.get(0));
    }
    
    @Test
    public void testNotFilling(){
        for(int i = 0; i < 1000; i++){
            Object o = new Object();
            t.add(o);
            assertSame(o,t.get(i));
        }
    }
    
    @Test
    public void testArrayConstructor(){
        Object[] l = {new Object(),new Object(),new Object()};
        ArrayList<Object> a = new ArrayList<Object>(l);
        assertSame(l[0],a.get(0));
        assertSame(l[1],a.get(1));
        assertSame(l[2],a.get(2));
    }
    
    @Test
    public void testSubList(){
        Object[] l = new Object[10];
        for(int i = 0; i < 10; i++){
            Object o = new Object();
            t.add(o);
            l[i] = o;
        }
        Object[] l2 = t.subList(5);
        for(int i = 0; i < 5; i++){
            assertSame(l[i],l2[i]);
        }
    }
}
