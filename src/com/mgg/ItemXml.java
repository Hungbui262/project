package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This class will scan a Items.csv file and print out the report in standard output (XML format)
 */
public class ItemXml {

	void loadFileItemXML() {
		Scanner s = null;
		try {
			s = new Scanner(new File("data/Items.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		XStream xstreamItem = new XStream(new DomDriver());

		while (s.hasNext()) {
			String line = s.nextLine();
			String tokens[] = line.split(",", -1);
			if (tokens.length <= 1) {
				System.out.println("Items.xml");
				System.out.println("<?xml version=\"1.0\"?>");
				System.out.println("<Items>");

				continue;
			} else {
				String productCode = tokens[0];
				String productType = tokens[1];
				String productName = tokens[2];
				if (tokens.length <= 3) {

					xstreamItem.alias("GiftCard", Item.class);

					Item b = new Item(productCode, productName, "0");
					String xml = xstreamItem.toXML(b);
					System.out.println(xml);
					
					PrintWriter fileWrite = null;
					try {
						fileWrite = new PrintWriter("data/output.xml");
					fileWrite.write(xml);
						fileWrite.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
				} else {

					if (productType.equals("PN") == true) {
						xstreamItem.alias("NewProduct", Item.class);
						
					} else if (productType.equals("PU") == true) {
						xstreamItem.alias("UsedProduct", Item.class);
						
					} else if (productType.equals("SB") == true) {
						xstreamItem.alias("Subcribtion", Item.class);
						
					} else if (productType.equals("SV") == true) {
						xstreamItem.alias("Service", Item.class);
						
					}
					String base = tokens[3];
					Item b = new Item(productCode, productName, base);
					String xml = xstreamItem.toXML(b);
					System.out.println(xml);
					
					PrintWriter fileWrite = null;
					try {
						fileWrite = new PrintWriter("data/output.xml");
					fileWrite.write(xml);
						fileWrite.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		System.out.println("</Items>");

	}
}
