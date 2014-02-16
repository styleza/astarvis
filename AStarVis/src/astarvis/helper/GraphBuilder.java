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
import astarvis.ds.ArrayList;
import astarvis.ds.HashMap;
import astarvis.ds.Pair;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * Builds different kind of graphs
 * @author Ilari
 */
public class GraphBuilder {
    
    /**
     * Builds graph with specified data
     * @param weights
     * @param h
     * @param w
     * @param startPoint
     * @param goalPoint
     * @return 
     */
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
        return new Graph(allNodes,edges,start,goal,new Point(w,h));
    }
    
    /**
     * Builds random graph
     * @param h
     * @param w
     * @return 
     */
    public static Graph buildRandom(int h, int w){
        // initialize random
        Random r = new Random();
        int[][] weigth = new int[h][w];
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                weigth[y][x] = (r.nextBoolean() ? r.nextInt(200) : r.nextInt(Math.max(x, y)*2+1)) % 255;
            }
        }
        Point start = new Point(0,0);
        Point goal = new Point(w-1,h-1);
        
        return GraphBuilder.build(weigth,h,w,start,goal);
    }
    
    /**
     * Builds maze graph
     * @param h
     * @param w
     * @return 
     */
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
    
    /**
     * Build graph from weight array only
     * Detects startpoint and endpoint by weights
     * start weight = 1
     * end weight = 2
     * @param weigths
     * @param h
     * @param w
     * @return 
     */
    public static Graph buildFromUI(int weigths[][],int h, int w){
        // locate startpoint and endpoint
        int sx, sy, ex,ey;
        sx = sy = 0;
        ex = w-1;
        ey = h-1;
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                if(weigths[y][x] == 1){
                    sx = x;
                    sy = y;
                    //weigths[y][x] = 0;
                }
                if(weigths[y][x] == 2){
                    ex = x;
                    ey = y;
                    //weigths[y][x] = 0;
                }
            }
        }
        Point startPoint = new Point(sx,sy);
        Point endPoint = new Point(ex,ey);
        return GraphBuilder.build(weigths, h, w, startPoint, endPoint);
    }
    
    /**
     * Builds graph from image
     * Image must contain
     * one red pixel
     * on green pixel
     * @param imageFile
     * @return
     * @throws IOException 
     */
    public static Pair<Graph,Point> buildFromImage(String imageFile) throws IOException{
        final File file = new File(imageFile);
        final BufferedImage image = ImageIO.read(file);
        final int h = image.getHeight();
        final int w = image.getWidth();
        
        int weights[][] = new int[h][w];
        Point sp = null;
        Point ep = null;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                final int clr = image.getRGB(x, y);
                final int red = (clr & 0x00ff0000) >> 16;
                final int green = (clr & 0x0000ff00) >> 8;
                final int blue = clr & 0x000000ff;
                final int gray = (red+green+blue)/3;
                if(green == 255 && blue+red == 0){
                    if(sp != null){
                        System.out.println("More than one startpoint found");
                        return null;
                    }
                    sp = new Point(x,y);
                    weights[y][x] = 1;
                }
                else if(red == 255 && green+blue == 0){
                    if(ep != null){
                        System.out.println("More than one endpoint found");
                        return null;
                    }
                    ep = new Point(x,y);
                    weights[y][x] = 1;
                } else {
                    weights[y][x] = 255-gray;
                    if(weights[y][x] == 0){
                        weights[y][x] = 5;
                        
                    }
                }
            }
        }
        if(ep == null){
            System.out.println("Endpoint not found");
        }
        if(sp == null){
            System.out.println("Startpoint not found");
        }
        if(ep == null || sp == null){
            return null;
        }
        System.out.println("Loaded image "+w+"x"+h);
        return new Pair<Graph,Point>(GraphBuilder.build(weights, h, w, sp, ep),new Point(w,h));
    }
}
