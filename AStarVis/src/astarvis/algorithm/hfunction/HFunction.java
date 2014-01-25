package astarvis.algorithm.hfunction;

import astarvis.ds.Node;

/**
 * Heurastic functions abstract interface
 * @author ilri@cs
 */
public interface HFunction {
    public int estimate(Node from, Node goal);
}
