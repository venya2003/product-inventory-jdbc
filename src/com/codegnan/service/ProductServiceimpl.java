package com.codegnan.service;

import java.util.List;

import com.codegnan.exceptions.ProductNotFoundException;
import com.codgnan.product.dao.ProductDaoImpl;
import com.codgnan.productinventory.program.Product;
import com.codgnan.product.dao.ProductDao;

public class ProductServiceimpl implements ProductService {
	ProductDao dao = new ProductDaoImpl();
	@Override
	public void addProduct(Product product) {
		dao.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.findAll();
		
	}

	@Override
	public Product getProductById(int id) throws ProductNotFoundException {
	
		return dao.findById(id);
	}

	@Override
	public void updateProduct(Product product) throws ProductNotFoundException {
		dao.update(product);
		
	}

	@Override
	public void deleteProduct(int id) throws ProductNotFoundException {
		dao.deleteById(id);
		
	}

}
