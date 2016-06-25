package edu.Arithmetic;

public class 插入排序法 {
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
		for (int i = 1; i < table.length; i++) {
			int j,temp = table[i];
			for (j = i-1; j>=0 && temp <table[j]; j--)
				table[j+1] = table[j];
			table[j+1] = temp;
			print(table);
		}
		print(table);
	}
	/*
	 * while(j>=0 && a[j]<t){
				a[j+1] = a[j--];
			}
	 */
	public static void main(String[] args) {
		int [] table = randoms(10);
		print(table);
		insourt(table);
	}
}
