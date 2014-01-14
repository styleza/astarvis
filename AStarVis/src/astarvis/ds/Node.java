/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.ds;

/**
 *
 * @author ilri@cs
 */
public class Node {
    private Point location;
    private int cost;
    
    public Node(Point location, int cost){
        this.location = location;
        this.cost = cost;
    }
    
    public Point getLocation(){
        return this.location;
    }
    
    public int getCost(){
        return this.cost;
    }
}
