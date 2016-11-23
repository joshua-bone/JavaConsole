package projecteuler.pe21_30;

import java.util.ArrayList;
import java.util.Collections;

public class PE024 {
	
//	A permutation is an ordered arrangement of objects. For example, 
//	3124 is one possible permutation of the digits 1, 2, 3 and 4. 
//	If all of the permutations are listed numerically or alphabetically, 
//	we call it lexicographic order. The lexicographic permutations of 
//	0, 1 and 2 are:
//
//	012   021   102   120   201   210
//
//	What is the millionth lexicographic permutation of the digits 
//	0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	
	public static void main(String[] args){
		ArrayList<Integer> arrangement = new ArrayList<>();
		for (int i = 0; i < 10; i++) arrangement.add(i);
		generatePermutation(arrangement, 1_000_000);
	}
	
	public static void generatePermutation(ArrayList<Integer> array, int requiredPermutation){
		for (int perm = 1; perm < requiredPermutation; perm++){
			if(!generateNextPermutation(array)){
				System.out.println("error: array is at maximum lexographical permutation");
			}
		}
		System.out.print("The 1 millionth permutation: ");
		for (int i : array) System.out.print(i);
		System.out.println("\nVerified answer from Project Euler: 2783915460");
	}
	
	public static boolean generateNextPermutation(ArrayList<Integer> array){
		int divider = -1;
		int max = -1;
		//step 1: work backwards until we find a digit that is less than the
		//digit immediately to its right. Set a divider immediately after this index. 
		for (int i = array.size() - 1; i >= 0; i--){
			if (array.get(i) > max){
				max = array.get(i);
			} else {
				divider = i;
				break;
			}
		}
		
		if (divider == -1 || max == -1){
			return false; //error: array is already at the maximum lexographical permutation
		}
		
		//step 2: find the smallest digit on the right hand side (rhs) that is 
		//larger than the last digit on the left hand side (lhs)
		int lhsRightmost = array.get(divider);
		int rhsNextLargest = Integer.MAX_VALUE;
		int rhsNLindex = -1;
		for (int i = divider + 1; i < array.size(); i++){
			if (array.get(i) > lhsRightmost){
				rhsNextLargest = Math.min(rhsNextLargest, array.get(i));
				rhsNLindex = i;
			}
		}
		
		//step 3: insert the digit we found into the array at the end of the lhs.
		//        This will push the last digit on the lhs over into the rhs
		rhsNextLargest = array.remove(rhsNLindex);
		array.add(divider, rhsNextLargest);
		
		//step 4: sort the rhs into lexographical order
		Collections.sort(array.subList(divider+1, array.size()));
		return true;
	}
}
