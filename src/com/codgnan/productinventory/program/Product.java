package com.codgnan.productinventory.program;

public class Product {
	private int productid;
	private String productname;
	private double productprice;
	private int productquantity;
	
	public Product(int productid, String productname, double productprice, int productquantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.productquantity = productquantity;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductqunatity(int productquantity) {
		this.productquantity = productquantity;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productprice=" + productprice
				+ ", productquantity=" + productquantity + "]";
	}
	
	
	

}
