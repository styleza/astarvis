package astarvis.algorithm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import astarvis.algorithm.hfunction.SimpleHFunction;
import astarvis.ds.*;
import astarvis.helper.GraphBuilder;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ilri@cs
 */
public class AstarTest {

    public AstarTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void testSimple1(){
        /*
        Structure of this graph:
        (s) - (1)
         |     |
        (2) - (g)
        */
        int w[][] = {{0,1},{2,0}};
        Point start = new Point(0,0);
        Point goal = new Point(1,1);
        Graph g = GraphBuilder.build(w,2,2,start,goal);
        Astar a = new Astar(g,new SimpleHFunction());
        ArrayList<Node> path = a.getPath();
        assertEquals(3,path.size());
        assertSame(path.get(0),g.getGoal());
        assertSame(path.get(1),g.getNodeAt(1, 0));
        assertSame(path.get(2),g.getStart());
    }
    @Test
    public void testSimple2(){
        /* (diffrent weights as 1
        Structure of this graph:
        (s) - (3)
         |     |
        (2) - (g)
        */
        int w[][] = {{0,3},{2,0}};
        Point start = new Point(0,0);
        Point goal = new Point(1,1);
        Graph g = GraphBuilder.build(w,2,2,start,goal);
        Astar a = new Astar(g,new SimpleHFunction());
        ArrayList<Node> path = a.getPath();
        assertEquals(3,path.size());
        assertSame(path.get(0),g.getGoal());
        assertSame(path.get(1),g.getNodeAt(0, 1));
        assertSame(path.get(2),g.getStart());
    }
    @Test
    public void testSimple3(){
        /*
        (s) - (3) - (4) - (5)
         #     |     |     |
        (1) # (1) # (1) # (1)
         |     |     |     #
        (1) - (1) - (2) - (1)
         |     |     |     #
        (1) - (2) - (1) - (g)
        */
        int w[][] = {{0,3,4,5},{1,1,1,1},{1,1,2,1},{1,2,1,0}};
        Point start = new Point(0,0);
        Point goal = new Point(3,3);
        Graph g = GraphBuilder.build(w,4,4,start,goal);
        Astar a = new Astar(g,new SimpleHFunction());
        ArrayList<Node> path = a.getPath();
        assertNotNull(path);
        assertEquals(7,path.size());
        assertSame(path.get(0),g.getGoal());
        assertSame(path.get(1),g.getNodeAt(3, 2));
        assertSame(path.get(2),g.getNodeAt(3, 1));
        assertSame(path.get(3),g.getNodeAt(2, 1));
        assertSame(path.get(4),g.getNodeAt(1, 1));
        assertSame(path.get(5),g.getNodeAt(0, 1));
        assertSame(path.get(6),g.getStart());
    }
    @Test
    public void testSimple4(){
        /*
        (s) # (3) # (4) - (5)
         |     |     #     |
        (9) - (9) - (1) - (1)
         |     |     #     |
        (1) - (1) - (2) - (9)
         |     |     #     |
        (1) - (2) - (1) # (g)
        */
        int w[][] = {{0,3,4,5},{9,9,1,1},{1,1,2,9},{1,2,1,0}};
        Point start = new Point(0,0);
        Point goal = new Point(3,3);
        Graph g = GraphBuilder.build(w,4,4,start,goal);
        Astar a = new Astar(g,new SimpleHFunction());
        ArrayList<Node> path = a.getPath();
        assertNotNull(path);
        assertEquals(7,path.size());
        assertSame(path.get(0),g.getGoal());
        assertSame(path.get(1),g.getNodeAt(2, 3));
        assertSame(path.get(2),g.getNodeAt(2, 2));
        assertSame(path.get(3),g.getNodeAt(2, 1));
        assertSame(path.get(4),g.getNodeAt(2, 0));
        assertSame(path.get(5),g.getNodeAt(1, 0));
        assertSame(path.get(6),g.getStart());
    }
    
}
