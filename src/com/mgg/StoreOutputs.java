package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class will scan a Stores.csv file and print out the report in standard output (CSV format)
 */
public class StoreOutputs {
	 void loadFileStoreCSV() {
		 
		Scanner s = null;
		try {
			s = new Scanner(new File("data/Stores.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		while (s.hasNext()) {
			String line = s.nextLine();
			String tokens[] = line.split(",", -1);
			if (tokens.length <= 1) {
				System.out.println("Stores.csv");
				System.out.println(tokens[0]);
				continue;
			} else {
				String storeCode = tokens[0];
				String code = tokens[1];
				String street = tokens[2];
				String city = tokens[3];
				String state = tokens[4];
				String zip = tokens[5];
				String country = tokens[6];

				Address a = new Address(street, city, state, zip, country);
				Store b = new Store(storeCode, code, a);
				System.out.println(String.format("%s, %s, %s, %s, %s, %s, %s", b.getStoreCode(),
						b.getCode(), a.getStreet(), a.getCity(), a.getState(), a.getZip(), a.getCountry()));
			}
		}
		s.close();
	}
}
