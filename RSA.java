
/**
 * @author Manoj
 *
 */
public class RSA {
	
	
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * @author Manoj
	 * @param e
	 * @param m
	 * @return The inverse of e, mod m.
	 */
	public static long inverse(long e, long m)
	{
		
		long ans = 0; long nu = 0; long ru = 1; long fin;
		
		

		long quo = m/e;
		long r = m - (quo * e);
		long r2 = e;
		while ((r > 1))
		{
			fin = nu - (quo * ru);
			nu = ru;
			ru = fin;
			quo = r2/r;
			long r3 = r;
			r = r2 - (r * quo);
			r2 = r3;
			
			
		}
		
		if(r == 1)
		{
			fin = nu - (quo * ru);
			if(fin < 0)
			{
				ans = fin + m;
			}
			else
				ans = fin % m;
		}
		return ans;
		
		
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
