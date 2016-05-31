package com.sogeti.pet.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PRODUCT")
@NamedQueries({
    @NamedQuery(name="Product.getAll",query="SELECT p FROM Product p")
})
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7272560615986044083L;
	
	public Product(){
		
	}

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name="PRODUCT_IMAGE_PATH")
	private String productImagePath;
	
	@Column(name = "PRODUCT_PRICE")
	private int productPrice;
	
	@Column(name="PRODUCT_STATUS")
	private String productStatus;
	
	@Column(name="PRODUCT_ADDED_DATE")
	private Timestamp productAddedDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="CATEGORY_FK_ID", referencedColumnName="CATEGORY_ID")
	@JsonBackReference(value="category")
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@products")
	private Category category;
	
	
	@Transient
	private int categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public Timestamp getProductAddedDate() {
		return productAddedDate;
	}

	public void setProductAddedDate(Timestamp productAddedDate) {
		this.productAddedDate = productAddedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCategoryId() {
		if(this.category!=null)
		return this.category.getId();
		return 0;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
