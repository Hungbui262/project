package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This class will scan a Persons.csv file and print out the report in standard output (CSV format)
 */
public class PersonOutputs {
	 void loadFilePersonCSV() {
		Scanner s = null;
		try {
			s = new Scanner(new File("data/Persons.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		while (s.hasNext()) {
			List<String> emailAddress = new ArrayList<>();
			String line = s.nextLine();
			String tokens[] = line.split(",", -1);
			if (tokens.length <= 1) {
				System.out.println("Persons.csv");
				System.out.println(tokens[0]);
				continue;
			} else {
				String code = tokens[0];
				String type = tokens[1];
				String firstName = tokens[2];
				String lastName = tokens[3];
				String street = tokens[4];
				String city = tokens[5];
				String state = tokens[6];
				String zip = tokens[7];
				String country = tokens[8];
				if (tokens.length < 10) {
					continue;
				} else {
					for (int i = 9; i < tokens.length; i++) {
						emailAddress.add(tokens[i]);
					}
				}
				Address a = new Address(street, city, state, zip, country);
				Person b = new Person(code,firstName, lastName, a, emailAddress);
				System.out.println(String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s",
						b.getCode(), b.getType(), b.getFirstName(), b.getLastName(), a.getStreet(), a.getCity(),
						a.getState(), a.getZip(), a.getCountry(), b.getEmailAddress()));
			}
		}
		s.close();
	}

}
