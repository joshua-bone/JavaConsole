package helpers;

import java.util.ArrayList;

public class PrimeSieveInt {
	int upperLimit;
	ArrayList<Integer> sieve;
	ArrayList<Integer> primes;
	
	public PrimeSieveInt(int upperLimit){
		sieve = new ArrayList<>();
		primes = new ArrayList<>();
		primes.add(2);
		this.upperLimit = upperLimit;
		generateSieve();
	}
	
	
	public void generateSieve(){
		int maxIndex = (this.upperLimit - 3) / 64;
		for (int i = 0; i <= maxIndex; i++){
			sieve.add(0xffffffff);
		}
		for (int i = 3; i < upperLimit; i+=2){
			if (isPrime(i)){
				primes.add(i);
				for (int j = i*2; j < upperLimit; j += i){
					if (j % 2 != 0) setSieveNotPrime(j);
				}
			}
		}
	}
	
	public void setSieveNotPrime(int index){
		int[] rowColumn = transformIndex(index);
		int row = rowColumn[0];
		int col = rowColumn[1];
		sieve.set(row, ~(~sieve.get(row) | 1 << col));
	}
	
	public boolean isPrime(int n){
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		int [] rowColumn = transformIndex(n);
		int row = rowColumn[0];
		int col = rowColumn[1];
		return ((sieve.get(row) & (1 << col)) != 0);
	}

	public int[] transformIndex(int n){
		if (n % 2 == 0) return null;
		int row = ((n-3) / 2) / 32;
		int col = ((n-3) / 2) % 32;
		return new int[] {row, col};
	}
	
	public ArrayList<Integer> getPrimes(){
		return primes;
	}
}
