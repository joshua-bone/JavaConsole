package cipher;

public class Cipher {
	public String encrypt(String s, int k){return cipherString(s, k);}
	public String decrypt(String s, int k){return cipherString(s, -k);}
	
	private String cipherString(String msg, int key){
		char[] letters = new char[msg.length()];
		for (int i = 0; i<msg.length(); i++){
			letters[i] = cipherChar(msg.charAt(i), key);
		}
		return new String (letters);
	}
	
	
	//shift the char by the provided int key
	private char cipherChar(char c, int key){
		
		while(key < 0){key+=26;} //avoid trouble with negative modulus
		
		char transpose = '?';
		
		if (c >= 'A' && c <= 'Z'){ //if it is a capital, need to subtract 65
			transpose = 'A';
		}
		else if (c >= 'a' && c <= 'z'){ //if lowercase, need to subtract 97
			transpose = 'a';
		}
		
		if (transpose == '?'){
			return c; //keep the same char if not alphabetical
		} else {
			return (char) ((c - transpose + key) % ('Z' - 'A' + 1) + transpose);
		}
	}
}
