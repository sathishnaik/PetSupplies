package com.sogeti.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.sogeti.pet.entity.Category;

@Local
public interface CategoryDAOLocal {
	public Category createCategory(Category category);
	public List<Category> getAllCategories();
	public Category updateCategory(Category category);
	public void deleteCategory(int id);
	public Category getCategoryById(int id);
	

}
