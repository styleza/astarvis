package astarvis.ds;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ilri@cs
 */
public class Graph {
    private ArrayList<Node> V;      // node's
    private HashMap<Node,ArrayList<Node> > E;   // Edges (from node A to B)
    
    public Graph(ArrayList<Node> V, HashMap<Node,ArrayList<Node> > E){
        this.V = V;
        this.E = E;
    }
    
    public ArrayList getNeighborsForNode(Node node){
        return E.get(node);
    }
}
