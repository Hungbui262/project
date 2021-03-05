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
 * This class will scan a Persons.csv file and print out the report in standard
 * output (XML format)
 */

public class PersonsXml {

	void loadfilePersonXML() {
		Scanner s = null;
		try {
			s = new Scanner(new File("data/Persons.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		String XML = "";
		XStream xstreamPerson = new XStream(new DomDriver());
		while (s.hasNext()) {

			List<String> emailAddress = new ArrayList<>();
			String line = s.nextLine();
			String tokens[] = line.split(",", -1);
			if (tokens.length <= 1) {
				System.out.println("Person.xml");
				System.out.println("<?xml version=\"1.0\"?>");
				System.out.println("<Persons>");
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
				Person b = new Person(code, firstName, lastName, a, emailAddress);

				xstreamPerson.alias("Persons", Person.class);
				if (type.equals("E") == true) {
					xstreamPerson.alias("Employee", Person.class);
					XML = xstreamPerson.toXML(b);
				} else if (type.equals("P") == true) {
					xstreamPerson.alias("PlatinumCustomer", Person.class);
					XML = xstreamPerson.toXML(b);
				} else if (type.equals("G") == true) {
					xstreamPerson.alias("GoldCustomer", Person.class);
					XML = xstreamPerson.toXML(b);
				} else if (type.equals("C") == true) {
					xstreamPerson.alias("Customer", Person.class);
					XML = xstreamPerson.toXML(b);
				}
				System.out.println(XML);
			}
		}
		PrintWriter fileWrite = null;
		try {
			fileWrite = new PrintWriter("data/Person.xml");
		fileWrite.write(XML);
			fileWrite.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
