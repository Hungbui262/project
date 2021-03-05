package com.mgg;
/**
 * This class models individual item 
 */ 
public class Item {
	private String productCode;
	private String productType;
	private String productName;
	private String basePrice;

	public Item(String productCode, String productType, String productName, String basePrice) {
		this.productCode = productCode;
		this.productType = productType;
		this.productName = productName;
		this.basePrice = basePrice;
	}
	public Item(String productCode, String productName, String basePrice) {
		this.productCode = productCode;
		this.basePrice = basePrice;
		this.productName = productName;
	}
//	public Item(String productCode, String productName,) {
//		this.productCode = productCode;	
//		this.productName = productName;
//	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductType() {
		return productType;
	}

	public String getProductName() {
		return productName;
	}

	public String getBasePrice() {
		return basePrice;
	}

	
}
