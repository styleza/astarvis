package astarvis.ds;

import java.util.ArrayList;

/**
 *
 * @author ilri@cs
 */
public class MinimumHeap {
    private ArrayList<Pair<Node, Integer> > queue;
    
    public MinimumHeap(){
        this.queue = new ArrayList<Pair<Node, Integer> >();
    }
    
    public void add(Node n, Integer i){
        queue.add(new Pair<Node,Integer>(n,i));
    }
    
    //@TODO: Make this more efficient (minimumheap)
    public Node poll(){
        Pair<Node, Integer> min = queue.get(0);
        int remove_i = 0;
        for(int i = 1; i < queue.size(); i++){
            if(min.getSecond() > queue.get(i).getSecond()){
                min = queue.get(i);
                remove_i = i;
            }
        }
        queue.remove(remove_i);
        return min.getFirst();
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public boolean contains(Node n){
        for(Pair<Node,Integer> n2 : queue){
            if(n2.getFirst() == n){
                return true;
            }
        }
        return false;
    }
}
