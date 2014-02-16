package astarvis.ds;

/**
 * Minimum heap data structure
 * @author ilri@cs
 */
public class MinimumHeap {
    private ArrayList<Pair<Node, Integer> > queue;
    
    /**
     * Initialize empty minimum heap
     */
    public MinimumHeap(){
        this.queue = new ArrayList<Pair<Node, Integer> >();
    }
    
    /**
     * Add Node to minimum heap
     * @param n
     * @param i 
     */
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
    
    /**
     * Returns smallest identified node
     * @return 
     */
    public Node poll(){
        if(queue.size() == 0) return null;
        Pair<Node, Integer> min = queue.get(0);
        queue.set(0,queue.get(queue.size()-1));
        queue.remove(queue.size()-1);
        heapify(0);
        return min.getFirst();
    }
    
    /**
     * Checks if heap is empty
     * @return 
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    /**
     * Checks if node is in heap
     * @param n
     * @return 
     */
    public boolean contains(Node n){
        for(Pair<Node,Integer> n2 : queue){
            if(n2.getFirst() == n){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Helper function for minimumheap, heapifys heap so it would be defragmented
     * @param i 
     */
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
    
    /**
     * Swaps two elements in heap (array)
     * @param a
     * @param b 
     */
    private void swap(int a, int b){
        Pair tmp = queue.get(a);
        queue.set(a,queue.get(b));
        queue.set(b,tmp);
    }
}
