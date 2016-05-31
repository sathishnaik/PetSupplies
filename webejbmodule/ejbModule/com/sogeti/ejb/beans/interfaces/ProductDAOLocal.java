package com.sogeti.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.sogeti.pet.entity.Product;

@Local
public interface ProductDAOLocal {
	
	Product createProduct(Product product);
	public List<Product> getAllProducts();
	public Product updateProduct(Product product);
	public Product getProductById(int id);
	public void deleteProduct(int id);

}
