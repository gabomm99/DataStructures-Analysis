package a1;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int numItems = scan.nextInt();
		Map<String, Integer> itemNames = new LinkedHashMap<String, Integer>();
		Map<String, Integer> numBuyersTrack = new HashMap<String, Integer>();
		int i = 0;
		while(i<numItems){
			String individualItem = scan.next();
			itemNames.put(individualItem, 0);
			numBuyersTrack.put(individualItem, 0);
			scan.nextDouble();
			i++;
		}

		int numOfCust = scan.nextInt();
		String[] names = new String[numOfCust];
		int j = 0;
		while (j<numOfCust) {
			names[j] = (scan.next()+ " " + scan.next());

			int numOfItems = scan.nextInt();
			int n = 0;
			Map<String, Integer> localTracker = new HashMap<String, Integer>();
			for (Map.Entry<String, Integer> entry : itemNames.entrySet()) {
				localTracker.put(entry.getKey(), 0);
			}
			while(n<numOfItems){
				int quantity = scan.nextInt();
				String item = scan.next();
				int newCount = itemNames.get(item) + quantity;
				itemNames.put(item, newCount);
				if (localTracker.get(item) == 0) {
					numBuyersTrack.put(item, numBuyersTrack.get(item) + 1);
					localTracker.put(item, localTracker.get(item) + 1);
				}
				n++;
			}
			j++;
		}
		scan.close();

		for (Map.Entry<String, Integer> entry : itemNames.entrySet()){
			String product = entry.getKey();
			int amount = entry.getValue();
			int numCustm = numBuyersTrack.get(product);
			if (amount == 0){
				System.out.println("No customers bought " + product);
			} else{
				System.out.println(Integer.toString(numCustm) + " customers bought " + Integer.toString(amount) + " " + product);
			}
		}
	}
}