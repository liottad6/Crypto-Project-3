package Crypto;
import java.util.Random;

/**
 * @author David Liotta
 * The person class to be used in conjunction with RSA
 */

public class Person {
	long e;			//public exponent
	long m;			//public modulus
	long d;			//private exponent

	/**
	 * Constructor for Person
	 * Sets up the variables needed for RSA
	 */
	public Person() {
		Random rand = new Random();
		long p = RSA.randPrime(1, 500, rand);
		long q = RSA.randPrime(1, 500, rand);
		long n = (q - 1) * (p - 1);
		this.m = q * p;
		this.e = RSA.relPrime(m, rand); 
		this.d = RSA.inverse(e, m);
	}
	
	public long getM() {
		return this.m;
	}
	
	public long getE() {
		return this.e;
	}
	
	/**
	 * Method that encrypts a message using RSA encryption
	 * @param msg the message to decrypt
	 * @param she the person who we are sending the message to
	 * @return the encrypted message
	 */
	public long[] encryptTo(String msg, Person she) {	
		long[] encrBytes = new long[msg.length() / 2];
	
		for(int i = 0; i < msg.length(); i += 2) {
			long tempMsg = RSA.toLong(msg, i);				//Retrieving each 2 chars converted to a long
			tempMsg = RSA.modPower(tempMsg, she.getE(), she.getM());	//Applying the exponent and mod
			encrBytes[i / 2] = tempMsg;					//Building the array
		}
		return encrBytes;
	}
	
	/**
	 * Method that decrypts an array of longs to a readable string
	 * @param cipher the array of encrypted bytes
	 * @return the decrypted message
	 */
	public String decrypt(long[] cipher) {
		String decrypted = "";
		
		for(int i = 0; i < cipher.length; i++) {
			long tempBit = cipher[i];			//Retrieve the bit to decrypt
			tempBit = RSA.modPower(tempBit, e, m);		//Decrypt it
			String temp = RSA.longTo2Chars(tempBit);	//Convert to a string
			decrypted += temp;
		}
		return decrypted;
	}

}

