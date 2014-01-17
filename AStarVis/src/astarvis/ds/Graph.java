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
    private Node[][] structure;
    private Point rect;
    
    public Graph(ArrayList<Node> V, HashMap<Node,ArrayList<Node> > E,Node start, Node goal){
        this.V = V;
        this.E = E;
        this.start = start;
        this.goal = goal;

    }
    public Graph(ArrayList<Node> V, HashMap<Node,ArrayList<Node> > E,Node start, Node goal, Point rect){
        this(V,E,start,goal);
        this.rect = rect;
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
        if(structure == null){
            structurize();
        }
        if(x < 0 || y < 0 || x > rect.getX() || y > rect.getY()){
            return null;
        }
        return structure[y][x];
    }
    
    private void structurize(){
        if(rect == null){
            this.rect = new Point();
            for(Node n : V){
                if(n.getLocation().getX() > rect.getX()){
                    rect.setX(n.getLocation().getX());
                }
                if(n.getLocation().getY() > rect.getY()){
                    rect.setY(n.getLocation().getY());
                }
            }
        }
        structure = new Node[rect.getY()+1][rect.getX()+1];
        for(Node n : V){
            structure[n.getLocation().getY()][n.getLocation().getX()] = n;
        }
    }
}
