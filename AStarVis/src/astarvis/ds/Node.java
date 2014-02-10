/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.ds;

/**
 * Node data structure
 * @author ilri@cs
 */
public class Node implements Hashable {
    private Point location;
    private int cost;
    
    /**
     * Initializes node with location and weight (cost)
     * @param location
     * @param cost 
     */
    public Node(Point location, int cost){
        this.location = location;
        this.cost = cost;
    }
    
    /**
     * Returns Node's location
     * @return 
     */
    public Point getLocation(){
        return this.location;
    }
    
    /**
     * Returns Node's weight (cost)
     * @return 
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * Returns hash key for this object
     * @return 
     */
    @Override
    public int hashKey() {
        return this.location.getX()*743+this.location.getY()*149+this.cost*283;
    }
}
