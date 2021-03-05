package com.mgg;
/**
 * 
 * @author Hung Bui, Khoa Le 
 * DATE: 2021/02/26
 * 
 * This program will scan multiple files and then generate into CSV and XML format in standard output
 */

public class DataConverter {
	public static void main(String[] args) {
		PersonOutputs a = new PersonOutputs();
		a.loadFilePersonCSV();
		System.out.println("\n\n");
		StoreOutputs b = new StoreOutputs();
		b.loadFileStoreCSV();
		System.out.println("\n\n");
		ItemOutputs c = new ItemOutputs();
		c.loadFileItemsCSV();
		System.out.println("\n\n");
		PersonsXml d = new PersonsXml();
		d.loadfilePersonXML();
		System.out.println("\n\n");
		StoreXml e = new StoreXml();
		e.loadFileStoreXML();
		System.out.println("\n\n");
		
		ItemXml f = new ItemXml();
		f.loadFileItemXML();
		
	}

}
