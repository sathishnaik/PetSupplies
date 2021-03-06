package com.sogeti.pet.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "CATEGORY")
@NamedQueries({
    @NamedQuery(name="Category.getAll",query="SELECT c FROM Category c")
})
public class Category implements Serializable{
	
	public Category(){
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3812839544124264883L;

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="CATEGORY_DESCRIPTION")
	private String categoryDescription;
	
	
	@Column(name="CATEGORY_IMAGE_PATH")
	private String categoryImagePath;
	
	@OneToMany(mappedBy="category", orphanRemoval = true, fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn ( name="CATEGORY_ID", referencedColumnName="CATEGORY_FK_ID")
	@JsonManagedReference(value="category")
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@products")
	private Set<Product> products;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategoryDescription() {
		return categoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}


	public String getCategoryImagePath() {
		return categoryImagePath;
	}


	public void setCategoryImagePath(String categoryImagePath) {
		this.categoryImagePath = categoryImagePath;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	@Override
    public int hashCode() {
        return getCategoryName().hashCode();
    }
	
	 @Override
	    public boolean equals(final Object obj) {
	        if (this == obj)
	            return true;
	        if (!(obj instanceof Category))
	            return false;
	        return getCategoryName().equals(((Category) obj).getCategoryName());
	    }
	
}
