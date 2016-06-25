package edu.Arithmetic;

public class 希尔排序法 {
	public static int [] randoms(int n){
		int [] table = new int [n];
		for (int i = 0; i < table.length; i++) {
			table[i] = (int)(Math.random()*100);
		}
		return table;
	}

	public static void print(int [] table){
		for (int i = 0; i < table.length; i++) {
			System.out.print(" "+table[i]);
		}
		System.out.println();
	}

	public static void insourt(int [] table){
		for (int delta = table.length/2 ; delta >0; delta/=2)
			for (int i = delta; i < table.length; i++) {
				int temp = table[i];
				int j = i -delta;
				while(j>=0 && temp >table[j]){
					table[j+delta] = table[j];
					j -=delta;
				}
				table[j+delta] = temp;
				print(table);
			}
	}

	public static void main(String[] args) {
		int [] table = randoms(10);
		System.out.print("    ");
		print(table);
		insourt(table);

	}

}
