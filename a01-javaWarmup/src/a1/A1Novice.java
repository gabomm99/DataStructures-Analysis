package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();
		Double[] allTotals = new Double[count];
		String[] names = new String[count];
		int i = 0;
		while (i<count) {
			String customer = "";
			customer = (scan.next()).charAt(0) + ". " + scan.next();
			names[i] = customer;

			int numOfItems = scan.nextInt();
			double total = 0;
			int j = 0;
			while(j<numOfItems){
				int quantity = scan.nextInt();
				scan.next();
				double price = scan.nextDouble();
				total += (quantity * price);
				j++;
			}
			allTotals[i] = total;
			i++;
		}
		scan.close();
		int n = 0;
		while(n<count){
			System.out.println(names[n] + ": " + String.format("%.2f", allTotals[n]));
			n++;
		}
	}
}
