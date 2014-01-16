/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.gui;

import astarvis.algorithm.Astar;
import astarvis.algorithm.hfunction.SimpleHFunction;
import astarvis.ds.Graph;
import astarvis.ds.Node;
import astarvis.ds.Point;
import astarvis.helper.GraphBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Ilari
 */
public class AstarController extends Timer implements ActionListener {
    private Drawer d;
    private Astar astar;
    private Graph g;

    private boolean continues;
    private int w, h;
    

    public AstarController(){
        super(1000,null);
        
        this.w = 30;
        this.h = 40;
        
        // initialize random
        Random r = new Random();
        int[][] weigth = new int[h][w];
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                weigth[y][x] = r.nextInt(x+y+1);
            }
        }
        Point start = new Point(0,0);
        Point goal = new Point(29,39);
        g = GraphBuilder.build(weigth,40,30,start,goal);
        this.astar = new Astar(g,new SimpleHFunction());
        
        
        addActionListener(this);
        setInitialDelay(500);
        
        continues = true;
        
    }
    public void setContinues(boolean c){
        this.continues = c;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {

        d.repaint();
        super.setDelay(20);
        
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    
    public void setDrawer(Drawer d){
        this.d = d;
    }
    
    public Graph getGraph(){
        return this.g;
    }
    public ArrayList<Node> getPath(){
        return astar.getPath();
    }

}
