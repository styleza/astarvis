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
        Pair p = new Pair<Node,Integer>(n,i);
        queue.add(null);
        int it = queue.size()-1;
        while(it > 0 && queue.get(it/2).getSecond() > i){
            queue.set(it,queue.get(it/2));
            it = it/2;
        }

        queue.set(it,p);
    }
    
    public Node poll(){
        if(queue.size() == 0) return null;
        Pair<Node, Integer> min = queue.get(0);
        queue.set(0,queue.get(queue.size()-1));
        queue.remove(queue.size()-1);
        heapify(0);
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
    
    private void heapify(int i){
        int l = 2*i;
        int r = l +1;
        int lrg = i;
        
        if(l < queue.size() &&
                queue.get(l).getSecond() < queue.get(lrg).getSecond()){
            lrg = l;
        }
        
        if(r < queue.size() &&
                queue.get(r).getSecond() < queue.get(lrg).getSecond()){
            lrg = r;
        }
        
        if(lrg != i){
            swap(i,lrg);
            heapify(lrg);
        }
    }
    
    private void swap(int a, int b){
        Pair tmp = queue.get(a);
        queue.set(a,queue.get(b));
        queue.set(b,tmp);
    }
}
