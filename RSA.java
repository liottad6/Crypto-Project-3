
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

}
