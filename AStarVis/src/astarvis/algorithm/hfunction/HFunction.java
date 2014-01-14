package astarvis.algorithm.hfunction;

import astarvis.ds.Node;

/**
 *
 * @author ilri@cs
 */
public interface HFunction {
    public int estimate(Node from, Node goal);
}
