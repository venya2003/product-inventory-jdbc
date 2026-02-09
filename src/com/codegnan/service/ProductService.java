package com.codegnan.service;

import java.util.List;
import com.codegnan.exceptions.ProductNotFoundException;
import com.codgnan.productinventory.program.*;

public interface ProductService {
    
	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int id) throws ProductNotFoundException;
	public void updateProduct(Product product) throws ProductNotFoundException;
	public void deleteProduct(int id) throws ProductNotFoundException;
}