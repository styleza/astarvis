package astarvis.ds;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import astarvis.ds.HashMap;


/**
 *
 * @author Ilari
 */
public class HashMapTest {
    HashMap<Node,Integer> hm;
    public HashMapTest() {
    }
    
    @Before
    public void setUp() {
        hm = new HashMap<Node,Integer>();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    private Node g(int x,int y){
        Point p = new Point(x,y);
        return new Node(p,x+y);
    }
    
    @Test
    public void testSimple(){
        Node A = g(0,0);
        hm.put(A, 1337);
        assertEquals(new Integer(1337),hm.get(A));
    }
    
    @Test
    public void testCollision(){
        Node A = g(0,0);
        Node B = g(0,0);
        hm.put(A, 1337);
        hm.put(B, 715517);
        assertEquals(new Integer(1337),hm.get(A));
        assertEquals(new Integer(715517),hm.get(B));
    }
    
    @Test
    public void testOverflow(){
        for(int i = 0; i < 1000;i++){
            Node tmp = g(i,i);
            assertTrue("HashMap insert failed at #"+i,hm.put(tmp, i));
        }
        
    }
}
