package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This class will scan a Stores.csv file and print out the report in standard
 * output (XML format)
 */
public class StoreXml {

	void loadFileStoreXML() {

		Scanner s = null;
		try {
			s = new Scanner(new File("data/Stores.csv"));

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		XStream xstreamStore = new XStream(new DomDriver());

		while (s.hasNext()) {

			String line = s.nextLine();
			String tokens[] = line.split(",", -1);
			if (tokens.length <= 1) {
				System.out.println("Stores.xml");
				System.out.println("<?xml version=\"1.0\"?>");
				System.out.println("<Stores>");
				continue;
			} else {
				String storeCode = tokens[0];
				String code = tokens[1];
				String street = tokens[2];
				String city = tokens[3];
				String state = tokens[4];
				String zip = tokens[5];
				String country = tokens[6];

				Scanner x = null;
				try {
					x = new Scanner(new File("data/Persons.csv"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				while (x.hasNext()) {
					xstreamStore.alias("Stores", Store.class);
					List<String> emailAddress = new ArrayList<>();
					String line2 = x.nextLine();
					String tokenx[] = line2.split(",", -1);
					String managerCode = tokenx[0];

					if (code.equals(managerCode)) {
						String lastName = tokenx[2];
						String firstName = tokenx[3];
						String managerStr = tokenx[4];
						String managerCity = tokenx[5];
						String managerState = tokenx[6];
						String managerZip = tokenx[7];
						String managerCountry = tokenx[8];

						Address personalAddress = new Address(managerStr, managerCity, managerState, managerZip,
								managerCountry);
						for (int i = 9; i < tokenx.length; i++) {
							emailAddress.add(tokenx[i]);
						}
						Manager m = new Manager(managerCode, lastName, firstName, personalAddress, emailAddress);
						Address a = new Address(street, city, state, zip, country);
						Store b = new Store(storeCode, a, m);
						String xml = xstreamStore.toXML(b);
						System.out.println(xml);
						PrintWriter fileWrite = null;
						try {
							fileWrite = new PrintWriter("data/Store.xml");
							fileWrite.write(xml);
							fileWrite.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
		System.out.println("</Stores>");

	}
}
