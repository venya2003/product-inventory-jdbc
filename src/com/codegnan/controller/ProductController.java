package com.codegnan.controller;

import com.codegnan.service.ProductServiceimpl;

import java.util.List;

import com.codegnan.exceptions.ProductNotFoundException;
import com.codegnan.service.ProductService;
import com.codgnan.productinventory.program.Product;

public class ProductController {

	public static void main(String[] args) {
		ProductService service = new ProductServiceimpl();
		
		//add products
		service.addProduct(new Product(101,"KitKat",30.35,55));
		service.addProduct(new Product(102,"Magiee",15.00,25));
		service.addProduct(new Product(103,"ThumsUp",20.00,100));
		service.addProduct(new Product(104,"Coke",40.10,250));
		service.addProduct(new Product(105,"Munch",10.00,98));
		service.addProduct(new Product(106,"Kurukure",30.35,100));
		service.addProduct(new Product(107,"Lays",30.35,45));
		service.addProduct(new Product(108,"WheatFlour",30.35,23));
		service.addProduct(new Product(109,"GramFlour",30.35,65));
		service.addProduct(new Product(110,"DairyMilk",30.35,77));
		
		System.out.println("products saved successfully");
		
		//fetch all records
		
		System.out.println("productid\tproductname\tproductprice\tproductquantity");
		System.out.println("-------------");
		List<Product> product = service.getAllProducts();
		for(Product prod:product) {
			System.out.println(prod);
		}
		
		//fetch single record
		try {
			Product fetchProduct = service.getProductById(101);
			System.out.println(fetchProduct);
		}catch(ProductNotFoundException e) {
			e.printStackTrace();
		}
		
		//update employee 102
		try {
		service.updateProduct(new Product(102,"sprite",20.20,54));
		}catch(ProductNotFoundException e) {
			e.printStackTrace();
		}
		
		//delete employee 110
		try{
			service.deleteProduct(110);
		}catch(ProductNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
