/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astarvis.algorithm.hfunction;

import astarvis.ds.Node;

/**
 *
 * @author Ilari
 */
public class DirectingHFunction implements HFunction{

    @Override
    public int estimate(Node from, Node goal) {
        int factor = (goal.getLocation().getX() - from.getLocation().getX()) +
                (goal.getLocation().getY() - from.getLocation().getY());
        
        return (int)((from.getCost() + goal.getCost()) * factor);
        
    }
    
    
}
