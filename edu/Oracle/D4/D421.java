package edu.Oracle.D4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;

@SuppressWarnings("all")
class D4221{}
public class D421 {
 public static void main(String[] args) {
	 	int a = 1/0;
//		int  a=(int) Math.hypot(3, 4);
//		double s = Math.random();
//		double sw = Math.random();
//		BigInteger bi = new BigInteger("-1");
//		BigDecimal d=new BigDecimal("1.2321321");
//		BigDecimal d1=new BigDecimal(""+Math.PI);
//		BigDecimal d2=d.multiply(d1);
//		System.out.println(d2);
		
//		D422 dd = new D422();
//		dd.getpass("dingcun");
//		
		String str = "qweqwwessasqsswewe";
		String pass = "ss";
		int index=-1;
		for (int i = 0; i < str.length()-pass.length(); i++) {
			if(str.substring(i, i+pass.length()).equals(pass)){
				index = i;
				break;
			}
		}
		System.out.println(index);
	}
	
	public  void getpass(String str){
		String []aaaa = {"12"} ;
		System.out.println("***************"+aaaa.hashCode());
		String []aaab = {"12"} ;
		System.out.println(aaab.hashCode());
		System.out.println("**************"+aaaa.equals(aaab));
		String sq1=new String("asd");
		System.out.println(sq1.hashCode()+"  **sq1");
		String sq2=new String("asd");
		System.out.println(sq2.hashCode()+"  **sq2");
		System.out.println(sq1.equals(sq2));
	}

}
