import java.util.ArrayList;

public class BloomFilter extends CountingBloomFilter  {
	
	private int m;
	
    private int[] counts;
    private ArrayList<HashFn> hashes;

	
	public BloomFilter(int m, ArrayList<HashFn> hashes) {
			
		 	this.m = m;
	        this.counts = new int[m];
	        this.hashes = hashes;
	       
	}

	public BloomFilter(int m) {
		
		this.m = m;
        this.counts = new int[m];
        this.hashes = new ArrayList<>();
	}
	
	//same as the add function in CountingBloomFilter class but there is no bound checking.
	public void add(int value) {
        
    	for(int i = 0; i< this.hashes.size(); i++) {
    		int x = this.hashes.get(i).calculateIndex(value, m);
    		
    			counts[x]++;
    	}
    	
    }
	
	//similar to the lookup function in CountingBloomFilter class but compares the element in counts at the
	//index(result of hash function) with 1 becasue BloomFilter sets the element at indexes to 1 rather than incrementing
	boolean lookup(int item) {
		boolean a = true;
		
		for(int i = 0; i < this.hashes.size(); i++) {
			
			int y =  this.hashes.get(i).calculateIndex(item, m);
			
			if(this.counts[y] < 1) {
				
				return false;
			}
			
		}
	
		return a;
	}
}
