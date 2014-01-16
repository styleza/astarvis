package astarvis.algorithm.hfunction;

import astarvis.ds.Node;

/**
 *
 * @author ilri@cs
 */
public class SimpleHFunction implements HFunction{

    @Override
    public int estimate(Node from, Node goal) {
        return goal.getCost();
    }
    
}
