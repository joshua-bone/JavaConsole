package projecteuler.pe21_30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class PE022 {
//	Using names.txt (right click and 'Save Link/Target As...'), 
//	a 46K text file containing over five-thousand first names, 
//	begin by sorting it into alphabetical order. Then working 
//	out the alphabetical value for each name, multiply this value 
//	by its alphabetical position in the list to obtain a name score.
//
//	For example, when the list is sorted into alphabetical order, 
//	COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th 
//	name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
//
//	What is the total of all the name scores in the file?
	
	public static String fileName = "names.txt";
	
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))){
			String line = bufIn.readLine();
			for (String name : line.split(",")){
				names.add(name);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		Collections.sort(names);
		long sum = 0;
		for (int i = 0; i < names.size(); i++){
			sum += (i+1) * getLetterScore(names.get(i));
		}
		System.out.println("The sum of the name scores is: " + sum);
		System.out.println("Verified answer from Project Euler: 871198282");
	}
	
	public static int getLetterScore(String word){
		int sum = 0;
		for (int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if (c >= 'A' && c <= 'Z'){
				sum += c - 'A' + 1;
			}
		}
		return sum;
	}
}
