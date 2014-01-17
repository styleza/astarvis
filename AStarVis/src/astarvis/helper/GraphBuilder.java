/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.helper;

import astarvis.algorithm.Astar;
import astarvis.algorithm.hfunction.SimpleHFunction;
import astarvis.ds.Graph;
import astarvis.ds.Node;
import astarvis.ds.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Ilari
 */
public class GraphBuilder {
    public static Graph build(int[][] weights,int h,int w,Point startPoint, Point goalPoint){
        ArrayList<Node> allNodes = new ArrayList<Node>();
        HashMap<Node, ArrayList<Node> > edges = new HashMap<Node, ArrayList<Node> >();
        Node[][] nodes = new Node[h][w];
        Node start = null;
        Node goal = null;
        for(int i = 0; i < h ; i++){
            nodes[i] = new Node[w];
        }
        
        for(int y = 0; y < h ; y++){
            for(int x = 0; x < w ; x++){
                Point nodePoint = new Point(x,y);
                nodes[y][x] = new Node(nodePoint, weights[y][x]);
                allNodes.add(nodes[y][x]);
                edges.put(nodes[y][x], new ArrayList<Node>());
                if(nodePoint.equals(startPoint)){
                    start = nodes[y][x];
                }
                if(nodePoint.equals(goalPoint)){
                    goal = nodes[y][x];
                }
            }
        }
        for(int y = 0; y < h ; y++){
            for(int x = 0; x < w ; x++){
                if(y > 0){
                    edges.get(nodes[y][x]).add(nodes[y-1][x]);
                }
                if(y+1 < h){
                    edges.get(nodes[y][x]).add(nodes[y+1][x]);
                }
                if(x > 0){
                    edges.get(nodes[y][x]).add(nodes[y][x-1]);
                }
                if(x+1 < w){
                    edges.get(nodes[y][x]).add(nodes[y][x+1]);
                }
            }
        }
        return new Graph(allNodes,edges,start,goal);
    }
    public static Graph buildRandom(int h, int w){
        // initialize random
        Random r = new Random();
        int[][] weigth = new int[h][w];
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                weigth[y][x] = r.nextBoolean() ? r.nextInt(200) : r.nextInt(Math.max(x, y)*2+1);
            }
        }
        Point start = new Point(0,0);
        Point goal = new Point(w-1,h-1);
        
        return GraphBuilder.build(weigth,h,w,start,goal);
    }
    public static Graph buildMaze(int h,int w){
        int[][] weigth = new int[h][w];
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                weigth[y][x] = (x % 2 == 0 && (!(x % 4 != 0 && y+1 == h) && !(x % 4 != 2 && y == 0))) ? 128 : 0;
            }
        }
        Point start = new Point(0,0);
        Point goal = new Point(w-1,h-1);
        
        return GraphBuilder.build(weigth,h,w,start,goal);
    }
}
