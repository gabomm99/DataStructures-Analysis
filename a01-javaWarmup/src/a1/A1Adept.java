package a1;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int numItems = scan.nextInt();
		Map<String, Double> itemNames = new HashMap<String, Double>();
		int i = 0;
		while(i<numItems){
			itemNames.put(scan.next(), scan.nextDouble());
			i++;
		}

		int numOfCust = scan.nextInt();
		Double[] allTotals = new Double[numOfCust];
		String[] names = new String[numOfCust];
		int j = 0;
		while (j<numOfCust) {
			names[j] = (scan.next()+ " " + scan.next());

			int numOfItems = scan.nextInt();
			double total = 0;
			int n = 0;
			while(n<numOfItems){
				int quantity = scan.nextInt();
				String item = scan.next();
				total += (quantity * itemNames.get(item));
				n++;
			}
			allTotals[j] = total;
			j++;
		}
		scan.close();

		String biggest = findValueMax(allTotals, names);
		String smallest = findValueMin(allTotals, names);
		double average = calculateAvg(allTotals);

		System.out.println("Biggest: " + biggest);
		System.out.println("Smallest: " + smallest);
		System.out.println("Average: " + String.format("%.2f", average));
	}


	static String findValueMin(Double[] cost,String[] names) {

		double minVal = cost[0];
		String smallPayer = names[0] + " (" + (String.format("%.2f", cost[0]) + ")");

		for (int i=1; i < names.length; i++) {
			if (cost[i] < minVal) {
				minVal = cost[i];
				smallPayer = names[i] + " (" + (String.format("%.2f", cost[i]) + ")");
			}
		}
		return smallPayer;
	}

	static String findValueMax(Double[] cost,String[] names) {

		double maxVal = cost[0];
		String bigPayer = names[0] + " (" + (String.format("%.2f", cost[0]) + ")");

		for (int i=1; i < names.length; i++) {
			if (cost[i] > maxVal) {
				maxVal = cost[i];
				bigPayer = names[i] + " (" + (String.format("%.2f", cost[i]) + ")");
			}
		}
		return bigPayer;
	}

	static Double calculateAvg(Double[] vals) {

		double sum = 0.00;

		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		double avg = sum/vals.length;

		return avg;
	}
}



