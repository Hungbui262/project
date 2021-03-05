package com.mgg;
import java.util.List;
/**
 * This class models individual store 
 */
public class Store {
	private String storeCode;
	private String code;
	private Address address;
	private Manager manager;
	

	public Store(String storeCode, String code, Address address) {
		this.storeCode = storeCode;
		this.code = code;
		this.address = address;
	}
	
	public Store(String storeCode,  Address address, Manager manager ) {
		
		this.storeCode = storeCode;
		this.address = address;
		this.manager = manager;

	}
	public String getStoreCode() {
		return storeCode;
	}
	public String getCode() {
		return code;
	}
	public Address getAddress() {
		return address;
	}
	public Manager getManager() {
		return manager;
	}

}
