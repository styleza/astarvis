package astarvis.ds;

import java.util.ArrayList;
//import java.util.HashMap;

/**
 * Graph data structure
 * @author ilri@cs
 */
public class Graph {
    private ArrayList<Node> V;                  // node's
    private HashMap<Node,ArrayList<Node> > E;   // Edges (from node A to B)
    private Node start;
    private Node goal;
    private Node[][] structure;
    private Point rect;
    
    /**
     * Initializes new graph, V contains all nodes, E all edges
     * @param V
     * @param E
     * @param start
     * @param goal 
     */
    public Graph(ArrayList<Node> V, HashMap<Node,ArrayList<Node> > E,Node start, Node goal){
        this.V = V;
        this.E = E;
        this.start = start;
        this.goal = goal;

    }
    
    /**
     * Extended initialization, takes also borders of graph (rect)
     * @param V
     * @param E
     * @param start
     * @param goal
     * @param rect 
     */
    public Graph(ArrayList<Node> V, HashMap<Node,ArrayList<Node> > E,Node start, Node goal, Point rect){
        this(V,E,start,goal);
        this.rect = rect;
    }
    
    /**
     * Returns all connected nodes from node
     * @param node
     * @return 
     */
    public ArrayList<Node> getNeighborsForNode(Node node){
        return E.get(node);
    }
    
    /**
     * Returns all nodes in graph
     * @return 
     */
    public ArrayList<Node> getAllNodes(){
        return V;
    }
    
    /**
     * Returns start node
     * @return 
     */
    public Node getStart(){
        return start;
    }
    
    /**
     * Returns goal node
     * @return 
     */
    public Node getGoal(){
        return goal;
    }
    
    /**
     * Returns node in grid, at point (x,y)
     * @param x
     * @param y
     * @return 
     */
    public Node getNodeAt(int x, int y){
        if(structure == null){
            structurize();
        }
        if(x < 0 || y < 0 || x > rect.getX() || y > rect.getY()){
            return null;
        }
        return structure[y][x];
    }
    
    /**
     * structurizes graph nodes (so getNodeAt would be fast)
     */
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
