package astarvis.algorithm;

import astarvis.algorithm.hfunction.HFunction;
import astarvis.ds.Graph;
import astarvis.ds.MinimumHeap;
import astarvis.ds.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ilri@cs
 */
public class Astar {
    private Node start;
    private Node goal;
    private Graph graph;
    private HFunction heurastic;
    private Set<Node> closedset;
    private Set<Node> openset;
    private HashMap<Node, Node> cameFrom;
    private HashMap<Node, Integer> gScore;
    private MinimumHeap open;
    boolean solved;
    
    public Astar(Graph graph,HFunction heurastic){
        this.start = graph.getStart();
        this.goal = graph.getGoal();
        this.graph = graph;
        this.heurastic = heurastic;
        this.closedset = new HashSet<Node>();
        this.openset = new HashSet<Node>();
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
        solve();
    }
    
    private void solve(){
        
        while(!open.isEmpty()){
            
            Node current = open.poll();
            
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
}
