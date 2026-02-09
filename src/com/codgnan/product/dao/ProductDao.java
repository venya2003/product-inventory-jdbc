package com.codgnan.product.dao;

import java.util.List;
import com.codegnan.exceptions.ProductNotFoundException;


import com.codgnan.productinventory.program.Product;

public interface ProductDao {
	//insert
  public void save(Product product);
  
  //select
  public List<Product>findAll();
  
  //fetch single record
  public Product findById(int id) throws ProductNotFoundException;
  
  //update
  public void update (Product product) throws ProductNotFoundException;
  
  //delete
  public void deleteById(int id) throws ProductNotFoundException;
  
  
}
