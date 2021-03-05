package com.mgg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class will scan a Items.csv file and print out the report in standard output (CSV format)
 */
public class ItemOutputs {
	public static void loadFileItemsCSV() {
		Scanner s = null;
		try {
			s = new Scanner(new File("data/Items.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		while (s.hasNext()) {
			String line = s.nextLine();
			String tokens[] = line.split(",", -1);
			if (tokens.length <= 1) {
				System.out.println("Items.csv");
				System.out.println(tokens[0]);
				continue;
			} else {
				String productCode = tokens[0];
				String productType = tokens[1];
				String productName = tokens[2];
				if (tokens.length < 4) {
					Item b = new Item(productCode, productType, productName," ");
					System.out.println(String.format("%s, %s, %s, %s",
							b.getProductCode(), b.getProductType(), b.getProductName(), b.getBasePrice()));
				} else {
						String base = tokens[3];
						Item b = new Item(productCode, productType, productName, base);
						System.out.println(String.format("%s, %s, %s, %s",
								b.getProductCode(), b.getProductType(), b.getProductName(), b.getBasePrice()));
					}
			}
		}
		s.close();
	}
}
