package com.sogeti.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sogeti.ejb.beans.interfaces.CategoryDAOLocal;
import com.sogeti.pet.entity.Category;

/**
 * Session Bean implementation class CategoryDAO
 */
@Stateless
public class CategoryDAO implements CategoryDAOLocal {

    /**
     * Default constructor. 
     */
    public CategoryDAO() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
	
	 
    
    @Override
	public Category createCategory(Category category) {
    	System.out.println("storing category EJB!!!!!!!!!!!!!!!!");
		em.persist(category);
		return category;
	}
    
    @Override
   	public Category updateCategory(Category category) {
   		em.merge(category);
   		return category;
   	}
    
    @Override
   	public void deleteCategory(int id) {
   		em.remove(getCategoryById(id));
   	}
    
    @Override
   	public List<Category> getAllCategories() {
   		return em.createNamedQuery("Category.getAll", Category.class).getResultList();
   	}
    
    @Override
   	public Category getCategoryById(int id) {
   		return em.find(Category.class, id);
   	}
    
}
