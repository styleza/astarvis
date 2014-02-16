package astarvis.algorithm;

import astarvis.algorithm.hfunction.HFunction;
import astarvis.ds.Graph;
import astarvis.ds.MinimumHeap;
import astarvis.ds.Node;
import astarvis.ds.Point;
import astarvis.ds.ArrayList;
import astarvis.ds.HashMap;

/**
 * Solves shortest path in graph using A* algorithm 
 * @author ilri@cs
 */
public class Astar {
    private Node start;
    private Node goal;
    private Graph graph;
    private HFunction heurastic;
    private ArrayList<Node> closedset;
    private HashMap<Node, Node> cameFrom;
    private HashMap<Node, Integer> gScore;
    private MinimumHeap open;
    boolean solved;
    boolean saveLookupHistory;
    private ArrayList<Point> history;
    
    /**
     * Initialize and solve shortest path in graph
     * You must also define heurastic function to estimated costs between point A and goal
     * @param graph
     * @param heurastic 
     */
    public Astar(Graph graph,HFunction heurastic, boolean saveLookupHistory){
        this.start = graph.getStart();
        this.goal = graph.getGoal();
        this.graph = graph;
        this.heurastic = heurastic;
        this.closedset = new ArrayList<Node>();
        //this.openset = new HashSet<Node>();
        this.cameFrom = new HashMap<Node, Node>();
        this.gScore = new HashMap<Node, Integer>();
        this.open = new MinimumHeap();
        
        for(Node n : graph.getAllNodes()){
            gScore.put(n,Integer.MAX_VALUE);
        }
        gScore.put(start, 0);
        open.add(start, 0 + heurastic.estimate(start, goal));
        //openset.add(start);
        
        solved = false;
        
        this.saveLookupHistory = saveLookupHistory;
        if(saveLookupHistory){
            history = new ArrayList<Point>();
        }
        
        solve();
    }

    
    /**
     * Solves the shortest (most "cheap") path using A* algorithm
     */
    private void solve(){
        
        while(!open.isEmpty()){
            
            Node current = open.poll();
            
            if(saveLookupHistory){
                history.add(current.getLocation());
            }
            
            if(current == goal){
                solved = true;
                return;
            }
            
            closedset.add(current);
            for(Node neighbor : graph.getNeighborsForNode(current)){
                if(closedset.contains(neighbor)){
                    continue;
                }
                int pgscore = gScore.get(current) + neighbor.getCost();
                
                if(!open.contains(neighbor) || pgscore < gScore.get(neighbor)){
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, pgscore);
                    if(!open.contains(neighbor)){
                        open.add(neighbor, pgscore + heurastic.estimate(neighbor, goal));
                    }
                }
            }
        }
        solved = false;
    }
    
    /**
     * Returns path after it's solved
     * @return 
     */
    public ArrayList<Node> getPath(){
        ArrayList<Node> returnValue = new ArrayList<Node>();
        if(!solved){
            return returnValue;
        }
        returnValue.add(goal);
        Node tmp = cameFrom.get(goal);
        while(true){
            returnValue.add(tmp);
            if(cameFrom.containsKey(tmp)){
                tmp = cameFrom.get(tmp);
            }
            else {
                break;
            }
        }
        return returnValue;
    }
    
    /**
     * Returns lookup history, points where A* algorithm visited
     * saveLookupHistory flag must be true if you want to save lookup history
     * @return 
     */
    public ArrayList<Point> getLookupHistory(){
        return this.history;
        
    }
}
