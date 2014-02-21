package astarvis.gui;

import astarvis.algorithm.Astar;
import astarvis.algorithm.hfunction.DirectingHFunction;
import astarvis.algorithm.hfunction.HFunction;
import astarvis.algorithm.hfunction.SimpleHFunction;
import astarvis.ds.Graph;
import astarvis.ds.Node;
import astarvis.ds.Point;
import astarvis.helper.GraphBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import astarvis.ds.ArrayList;
import astarvis.ds.Pair;
import java.util.Random;
import javax.swing.Timer;

/**
 * AStart GUI controller
 * @author Ilari
 */
public class AstarController extends Timer implements ActionListener {
    private Drawer d;
    private Astar astar;
    private Graph g;
    private HFunction currentHFunction;

    private boolean continues;
    private int w, h;
    

    /**
     * Initializes A* GUI controller
     */
    public AstarController(){
        super(1000,null);
        
        this.w = 30;
        this.h = 40;
        
        setDirectingHFunction();
        reset(true);
        
        
        addActionListener(this);
        setInitialDelay(0);
        
        continues = true;
        
    }
    
    /**
     * Initialize A* with graph
     * @param d 
     */
    public AstarController(Pair<Graph,Point> d){
        super(1000,null);
        
        this.w = d.getSecond().getX();
        this.h = d.getSecond().getY();
        
        setDirectingHFunction();
        
        this.g = d.getFirst();
        this.astar = new Astar(this.g,currentHFunction,true);
        
        addActionListener(this);
        setInitialDelay(0);
        
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

    
    public void setDrawer(Drawer d){
        this.d = d;
    }
    
    public Graph getGraph(){
        return this.g;
    }
    public ArrayList<Node> getPath(){
        return astar.getPath();
    }
    
    /**
     * Resets (and solves)  new A* visualization for random / maze data
     * @param random 
     */
    public void reset(boolean random){
        this.g = random ? GraphBuilder.buildRandom(h, w) : GraphBuilder.buildMaze(h, w);
        this.astar = new Astar(g,currentHFunction,true);
        if(this.d != null){
            this.d.setTick(0);
        }

    }
    /**
     * Resets (and solves) new A* visualization for composer data
     * @param g 
     */
    public void reset(Graph g){
        this.g = g;
        this.astar = new Astar(g,currentHFunction,true);
        if(this.d != null){
            this.d.setTick(0);
        }
    }
    
    /**
     * Sets heurastic to directing
     */
    public void setDirectingHFunction(){
        this.currentHFunction = new DirectingHFunction();
    }
    
    /**
     * Sets heurastic to simple
     */
    public void setSimpleHFunction(){
        this.currentHFunction = new SimpleHFunction();
    }
    
    /**
     * Returns lookup history (points where A* has visited)
     * @param to
     * @return 
     */
    public ArrayList<Point> getLookupHistory(int to){
        if(to >= this.astar.getLookupHistory().size()){
            return this.astar.getLookupHistory();
        }
        return new ArrayList<Point>(this.astar.getLookupHistory().subList(to));
    }

}
