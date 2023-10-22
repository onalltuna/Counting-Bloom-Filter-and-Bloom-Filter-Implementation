import java.util.ArrayList;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        int seed = 100;
        Random rand = new Random(seed);
        int sequenceSize = 10000;

        int m = 100;
        int maxint = Integer.MAX_VALUE;
        ArrayList<HashFn> hashes = new ArrayList<>();
        hashes.add(new HashFn() {
            public int calculateIndex(int value, int arrSize) {
                return value % arrSize;
            }
        });
        // TODO - add the hash function specified in the project description to the "hashes" ArrayList
        
        //adds the specified hash function to the hashes list
        hashes.add(new HashFn() {
        	public int calculateIndex(int value, int arrSize) {
        		
        		int x = value;
        		
        		//decimal version of hexadecimal number
        		int dec = Integer.parseInt("7feb352d",16);
        		
        		//righshift, Xor and multiplication
        		x = x ^ (value >>> 13);
        		x = x * dec;
        		
        		x = x ^ (x >>> 13);
        		x = x * dec;
        		x = x ^ (x >>> 13);
        		
        		if(x < 0) {
        			x = x * -1;
        			x = x % arrSize;
        		}
        		
        		x = x % arrSize;
        		
        		return x;
        	}
        });
        		
        CountingBloomFilter f = new CountingBloomFilter(m, maxint, hashes);
        BloomFilter bf = new BloomFilter(m, hashes);

        for (int i = 0; i < sequenceSize; i++) {
            int randNo = (rand.nextInt() & Integer.MAX_VALUE) % sequenceSize;

            bf.add(randNo);
            f.add(randNo);
        }

        for (int i = 0; i < sequenceSize / 100; i++) {
            int randNo = (rand.nextInt() & Integer.MAX_VALUE) % sequenceSize;
            System.out.println("number: " + randNo +
                    ", counting: " + f.lookup(randNo, 200) +
                    ", bloom: " + bf.lookup(randNo));
        }
    }
}
