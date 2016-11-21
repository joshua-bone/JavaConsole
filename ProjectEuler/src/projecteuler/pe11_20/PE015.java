package projecteuler.pe11_20;

import java.util.ArrayList;

public class PE015 {
//	Starting in the top left corner of a 2×2 grid, and only being able 
//  to move to the right and down, there are exactly 6 routes to the 
//	bottom right corner.
//
//	How many such routes are there through a 20×20 grid?
	public static void main(String[] args) {
		System.out.println("Paths through a 2x2 grid: " + routeGrid(2));
		System.out.println("Paths through a 20x20 grid: " + routeGrid(20));
		System.out.println("Verified answer from Project Euler: 137846528820");
	}
	
	public static long routeGrid(int size){
		size++; //because a 2x2 grid is actually a 3x3 grid of lattice points
		ArrayList<Long> array = new ArrayList<>();
		for (int i = 0; i < size; i++){
			array.add(1L);
		}
		long temp;
		for (int i = 1; i < size; i++){
			temp = 0;
			for (int j = 0; j < size; j++){
				array.set(j, array.get(j) + temp);
				temp = array.get(j);
			}			
		}
		return array.get(array.size() - 1);
	}
}
