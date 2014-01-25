/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.ds;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ilari
 */
public class MinimumHeapTest {
    private MinimumHeap mh;
    private static final int TEST_MAX = 10000;
    
    public MinimumHeapTest() {
    }
    
    @Before
    public void setUp() {
        mh = new MinimumHeap();
    }

    
    private void addAll(int[] x){
        for(int i : x){
            Point p = new Point(i,i);
            Node t = new Node(p,i);
            mh.add(t, i);
        }
    }
    @Test
    public void basicTest(){
        int[] x = {1,5,2,7};
        addAll(x);
        assertEquals(new Point(1,1),mh.poll().getLocation());
        assertEquals(new Point(2,2),mh.poll().getLocation());
        assertEquals(new Point(5,5),mh.poll().getLocation());
        assertEquals(new Point(7,7),mh.poll().getLocation());
    }
    
    @Test
    public void testBig(){
        ArrayList<Integer> compare = new ArrayList<Integer>();
        Random r = new Random();
        int[] x = new int[TEST_MAX];
        for(int i = 0; i < TEST_MAX; i++){
            int rnd = r.nextInt();
            compare.add(rnd);
            x[i] = rnd;
        }
        addAll(x);
        while(!compare.isEmpty()){
            int min = Integer.MAX_VALUE;
            int min_pos = -1;
            for(int i = 0; i < compare.size(); i++){
                if(min > compare.get(i)){
                    min = compare.get(i);
                    min_pos = i;
                }
            }
            assertEquals(min,mh.poll().getCost());
            compare.remove(min_pos);
        }
    }
}
