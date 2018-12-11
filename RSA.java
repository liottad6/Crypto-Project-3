
/**
 * @author Manoj
 *
 */
import java.util.Random;
public class RSA {
	
	
	
	public static void main (String args[]){   
        Person Alice = new Person();
        Person Bob = new Person();
    
        String msg = new String ("Bob, let's have lunch.");     // message to be sent to Bob
        long []  cipher;
        cipher =  Alice.encryptTo(msg, Bob);            // encrypted, with Bob's public key
    
        System.out.println ("Message is: " + msg);
        System.out.println ("Alice sends:");
        show (cipher);
    
        System.out.println ("Bob decodes and reads: " + Bob.decrypt (cipher));  // decrypted,
                                    // with Bob's private key.
        System.out.println ();
    
        msg = new String ("No thanks, I'm busy");
        cipher = Bob.encryptTo (msg, Alice);
        
        System.out.println ("Message is: " + msg);
        System.out.println ("Bob sends:");
        show (cipher);
    
        System.out.println ("Alice decodes and reads: " + Alice.decrypt (cipher));
    	}//end main
	
	
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
	
	
	/**
        * Find a random prime number
        * 
        * @param      m, n, java.util.Random  
        * @return     A random prime in the range m..n, using rand to generate the number
        */
        public static long randPrime(int m, int n, Random rand) {
            boolean prime = false;
            int randomPrime = 0;
            while(!prime){
                prime = true;
                int randomInt = m + rand.nextInt(n-m);
                
                int bound = (int) Math.sqrt((double)randomInt);
                //while loop check if the generated number is prime
                int i = 3;
                if ((randomInt % 2) == 0){
                    //immediately fails if number is even
                    i = bound+1;
                    prime = false;
                }//end if
                while(i <= bound){
                    //checks if i divides the generated number
                    if ((randomInt % i) == 0){
                        //i is a factor of randomInt
                        prime = false;
                    }//end if
                    //breaks the loop if the prime test is failed
                    if (prime == false){
                        i = bound;
                    }//end if
                    i += 2;
                }//end while
                randomPrime = randomInt;
            }//end while
            return randomPrime;
        }//end randPrime
	
	/**
        * Find a random number relatively prime to a given long int
        * 
        * @param      n, java.util.Random  
        * @return     a random number relatively prime to n
        */
        public static long relPrime(long n, Random rand) {
            //gcd must be 1 for two relatively prime numbers
            boolean a = false;
            long output = 0;
            while(!a){
                a = true;
                //coprime will be less than n
                int coprime = rand.nextInt((int) n-1) +1;//adds one so zero isnt included
                output = (long) coprime;//holds the original value for coprime
                int remainder = (int) n;
                //runs through euclidean algorithm
                while (remainder != 1){
                    if((n%coprime) == 0){
                        a = false;
                        remainder = 1;
                    }//end if
                    else{
                        //holds the number of times coprime goes into n
                        int divides = remainder /coprime;
                        remainder -= (divides*coprime);
                        if(remainder == 1){
                            //numbers are coprime
                            break;
                        }//end if
                        else{
                            //switches the numbers around for next round of algorithm
                            int temp = coprime;
                            coprime = remainder;
                            remainder = temp;
                        }//end else
                    }//end else
                }//end while
                
            }//end while
            return output;
        }//end relPrime
	
	/**
    	 * Display an array of longs on stdout
 	 * 
 	 * @param  cipher   array of longs
         */
   	 public static void show(long[] cipher){
       	 int i = 0;
   	     while (i < cipher.length){
        	    System.out.print(cipher[i]);
          	  i++;
       	     }//end while
    	 }//end show
	
	/**
     	* Convert two numeric chars to long int
    	* 
     	* @param  msg, p  
     	* @return     the two digit number beginning at position p of msg as a long int.
     	*/
    	public static long toLong(String msg, int p){
        	String msg2 = msg.substring(p,p+2);
        	int a = msg2.charAt(0);
        	int b = msg2.charAt(1);
        	long output = a|b;
        	return output;
    	}//end toLong
	
	/**
     	* Convert a long to 2 chars
     	* 
     	* @param  x
     	* @return     The string made up two numeric digits representing x
     	*/
    	public String longTo2Chars(long x){
        	char a = (char)(x >> 32);
        	char b = (char) x;
        	String output = "" + a + b;
        	return output;
    	}//end longTo2Chars

}
