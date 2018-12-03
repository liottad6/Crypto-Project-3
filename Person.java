package proj3;

/**
 * @author David Liotta
 *
 */

public class Person {
	long e;			//public exponent
	long m;			//public modulus
	long d;			//private exponent

	public Person() {
		long p = randPrime(from, to, rand);
		long q = randPrime(from, to, rand);
		this.m = q * p;
		this.e = randPrime(from, to, rand);  //TODO Make this relatively prime to m
		this.d = inverse(e, m);
		
	}
	
	/**
	 *  Accessor method for public modulus
	 * @return m
	 */
	public long getM() {
		return this.m;
	}
	
	public long getE() {
		return this.e;
	}
	
	public long[] encryptTo(String msg, Person she) {
		return null;
		
	}
	
	public String decrypt(long[] cipher) {
		return null;
	}

}
