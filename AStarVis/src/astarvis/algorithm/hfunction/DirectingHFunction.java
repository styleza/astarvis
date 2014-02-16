package astarvis.algorithm.hfunction;

import astarvis.ds.Node;

/**
 * Directing heurastic function,
 * estimates costs using distance between point A and B
 * @author Ilari
 */
public class DirectingHFunction implements HFunction{

    @Override
    public int estimate(Node from, Node goal) {
        int factor = Math.abs(goal.getLocation().getX() - from.getLocation().getX()) +
                Math.abs(goal.getLocation().getY() - from.getLocation().getY());
        
        return (int)((from.getCost() + goal.getCost()) * factor);
        
    }
    
    
}
