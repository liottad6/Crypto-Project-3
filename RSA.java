
/**
 * @author Manoj
 *
 */
public class RSA {
	
	/**
	 * @author Manoj
	 * @param e
	 * @param m
	 * @return The inverse of e, mod m.
	 */
	public static long inverse(long e, long m)
	{
		return (Long) null;
	}
	
	/**
	 * @author Manoj
	 * @param b 
	 * @param p
	 * @param m
	 * @return bp mod m
	 */
	public static long modPower(long b, long p, long m)
	{
		long ans = 1;      
		b = b % m;  
		while (p > 0) { 
			if((p & 1)==1) {
				ans = (ans * b) % m;
			}
			p = p >> 1;  
			b = (b * b) % m;  
		} 
		return ans; 
	}
	
	public static void main(String[] args) {
		
	}
	
	public static java.lang.String longTo2Chars(long x){
		return null;
	}
	
	public static long randPrime(int m, int n, java.util.Random rand) {
		return 0;
	}
	
	public static long relPrime(long n, java.util.Random rand) {
		return 0;
	}
	
	public static void show(long[] cipher) {
		
	}
	
	public static long toLong(java.lang.String msg, int p) {
		return 0;
	}

}
