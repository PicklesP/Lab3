/**
 * An application that simulates a month of transactions at In-n-Out
 * Author: Angel Jauregui
 * CS240
 */

package cs240;

import java.util.Random;

public class Main {
	
	public static void main(String[] args){
		Menu m = new Menu();
		Pantry p = new Pantry();
		Customers c = new Customers();
		//Stock for the first day of the month
		p.restock(300);
		//each day of the month
		for(int i = 301; i < 331; i++){
			int customersLost = 0;
			int order1 = 0;
			int order2 = 0;
			int order3 = 0;
			int order4 = 0;
			int order5 = 0;
			int order6 = 0;
			for(int j = 0; j < 10; j++){
				int[] orders = c.serveCustomers(p);
				customersLost += orders[0];
				order1 += orders[1];
				order2 += orders[2];
				order3 += orders[3];
				order4 += orders[4];
				order5 += orders[5];
				order6 += orders[6];
			}
			//every third day the food gets restocked
			if(i % 3 == 0)
				p.restock(i);
			System.out.println(customersLost);
			System.out.println(order1);
			System.out.println(order2);
			System.out.println(order3);
			System.out.println(order4);
			System.out.println(order5);
			System.out.println(order6);
			p.tossExpired(i);
		}
	}
}
