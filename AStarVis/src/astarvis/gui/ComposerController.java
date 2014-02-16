/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.gui;

import astarvis.ds.Point;
import astarvis.helper.GraphBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 * AStart GUI controller
 * @author Ilari
 */
public class ComposerController extends Timer implements ActionListener {
    private DrawerComposer d;
    private AstarController actrl;

    private boolean continues;
    private int w, h;
    private int weigths[][];
    

    /**
     * Initializes composer GUI controller
     */
    public ComposerController(AstarController actrl){
        super(1000,null);
        
        this.w = 30;
        this.h = 40; 
        this.weigths = new int[h][w];
        this.actrl = actrl;
        
        addActionListener(this);
        setInitialDelay(100);
        
        continues = true;
        
    }
    
    /**
     * Sets wether gui should continue
     * @param c 
     */
    public void setContinues(boolean c){
        this.continues = c;
    }
    

    /**
     * Painting invoke
     * @param ae 
     */
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

    
    public void setDrawer(DrawerComposer d){
        this.d = d;
    }
    
    /**
     * Change weight in point x,y (GUI scaled x and y)
     * @param x
     * @param y
     * @return 
     */
    public Point changeWeigth(int x,int y){
        Point p = convertToScale(x,y);
        if(p == null) return null;
        if(p.getX() < w && p.getY() < h){
            weigths[p.getY()][p.getX()] += 50;
        }
        actrl.reset(GraphBuilder.buildFromUI(weigths,h,w));
        return p;
    }
    
    /**
     * Converts GUI scaled x and y to Graph's coordinates
     * @param x
     * @param y
     * @return 
     */
    public Point convertToScale(int x,int y){
        x = x/d.getScale();
        y = y/d.getScale()-1;
        if(x < 0 || x >= w || y < 0 || y >= h) return null;
        return new Point(x,y);
    }
    
    /**
     * Sets Start or endpoint
     * (first endpoint and if is endpoint sets to start point)
     * @param x
     * @param y 
     */
    public void setStartEnd(int x,int y){
        x = x/d.getScale();
        y = y/d.getScale()-1;
        if(x < w && y < h){
            weigths[y][x] = (weigths[y][x] == 1 ? 2 : 1);
        }
        actrl.reset(GraphBuilder.buildFromUI(weigths,h,w));
    }
    
    /**
     * Return's weights in composed graph
     * @return 
     */
    public int[][] getWeights(){
        return weigths;
    }
    
    /**
     * Resets all weights back to zero
     */
    public void reset(){
        this.weigths = new int[h][w];
        for(int y = 0 ; y < h ; y++){
            for(int x = 0; x < w ; x++){
                this.weigths[y][x] = 5;
            }
        }
    }
    

}
