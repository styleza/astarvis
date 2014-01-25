package astarvis.algorithm.hfunction;

import astarvis.ds.Node;

/**
 * Basic heurastic function which estimates cost simply by returning goals+from cost
 * @author ilri@cs
 */
public class SimpleHFunction implements HFunction{

    @Override
    public int estimate(Node from, Node goal) {
        return from.getCost() + goal.getCost();
    }
    
}
