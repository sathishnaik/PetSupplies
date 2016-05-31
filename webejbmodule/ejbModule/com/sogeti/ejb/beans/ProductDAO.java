package com.sogeti.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sogeti.ejb.beans.interfaces.ProductDAOLocal;
import com.sogeti.pet.entity.Product;

/**
 * Session Bean implementation class ProductDAO
 */
@Stateless
public class ProductDAO implements ProductDAOLocal {

    /**
     * Default constructor. 
     */
    public ProductDAO() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
	
	 
    
    @Override
	public Product createProduct(Product product) {
		em.persist(product);
		return product;
	}
    
    @Override
   	public Product updateProduct(Product product) {
   		em.merge(product);
   		return product;
   	}
    
    @Override
   	public void deleteProduct(int id) {
       Product product =	getProductById(id);
   		em.remove(product);
   	}
    
    @Override
   	public List<Product> getAllProducts() {
   		return em.createNamedQuery("Product.getAll", Product.class).getResultList();
   	}
    
    @Override
   	public Product getProductById(int id) {
   		 Product product = em.find(Product.class, id);
   		return product;
   	}

}
