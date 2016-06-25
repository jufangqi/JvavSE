package edu.Arithmetic;

public class 冒泡排序法{
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
			for (int j = 0; j < i; j++) {
				if(table[i]>table[j]){
					int temp = table[i];
					table[i] = table[j];
					table[j] = temp;
				}
			}
		}print(table);
	}
	
	public static void insourt1(int [] table){
		for (int i = 1; i < table.length ; i++) {
			for (int j = 0; j < table.length-i; j++) {
				if(table[j]<table[j+1]){
					int temp = table[j];
					table[j] = table[j+1];
					table[j+1] = temp;
				}
			}
		}print(table);
	}
	public static void main(String[] args) {
		 int [] table = randoms(10);
		 print(table);
		 insourt1(table);
	}
	
}
