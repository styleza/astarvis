package astarvis.ds;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ilri@cs
 */
public class Graph {
    private ArrayList<Node> V;                  // node's
    private HashMap<Node,ArrayList<Node> > E;   // Edges (from node A to B)
    private Node start;
    private Node goal;
    
    public Graph(ArrayList<Node> V, HashMap<Node,ArrayList<Node> > E,Node start, Node goal){
        this.V = V;
        this.E = E;
        this.start = start;
        this.goal = goal;
    }
    
    public ArrayList<Node> getNeighborsForNode(Node node){
        return E.get(node);
    }
    
    public ArrayList<Node> getAllNodes(){
        return V;
    }
    
    public Node getStart(){
        return start;
    }
    public Node getGoal(){
        return goal;
    }
    public Node getNodeAt(int x, int y){
        for(Node n : V){
            if(n.getLocation().getX() == x && n.getLocation().getY() == y){
                return n;
            }
        }
        return null;
    }
}
