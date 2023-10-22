import java.util.Arrays;
import java.util.ArrayList;

public class CountingBloomFilter {

    private int m;
    private int bound;
    private int[] counts;
    private ArrayList<HashFn> hashes;
    
    public CountingBloomFilter() {
    	
    }

    public CountingBloomFilter(int m, int bound) {
        this.m = m;
        this.bound = bound;
        this.counts = new int[m];
        this.hashes = new ArrayList<>();
    }

    public CountingBloomFilter(int m, int bound, ArrayList<HashFn> hashes) {
        this.m = m;
        this.counts = new int[m];
        this.hashes = hashes;
        this.bound = bound;
    }

    public void addHashFn(HashFn h) {
        hashes.add(h);
    }

    //this method iterates over hashes list and calculats the results of value for each hash function in the list
    //if the result of any hash function is not bigger or equal then the bound then increments the element of counts array
    // at the index(result of hash functions)
    public void add(int value) {
        // TODO
    	
    	for(int i = 0; i< this.hashes.size(); i++) {
    		int x = this.hashes.get(i).calculateIndex(value, m);
    		
    		if(this.counts[x] < this.bound) {
    			this.counts[x]++;
    		}
    	
    	}
    }
    
    //as the add() function this method also iterates over hashes list and calculate indexes.If any of the elements in counts
    //at index(result of hash function) is less than the threshold then it turns the boolean a to false which means searched
    //value is not in the list
    public boolean lookup(int value, int threshold) {
        // TODO
    	
    	boolean a = true;
    	
    	for(int i = 0; i < this.hashes.size(); i++) {
    		int y = this.hashes.get(i).calculateIndex(value, m);
    		
    		if(this.counts[y] < threshold) {
    			a = false;
    			
    		
    		}
    	}
    	
    	
        return a;
    }

    @Override
    public String toString() {
        return Arrays.toString(counts);
    }
}
