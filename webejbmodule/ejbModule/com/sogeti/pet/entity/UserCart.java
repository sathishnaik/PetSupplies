package com.sogeti.pet.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "USERCART")
@NamedQueries({
    @NamedQuery(name="Cart.getAll",query="SELECT c FROM UserCart c"),
    @NamedQuery(name="UserCart.getAllByUserId",query="SELECT c FROM UserCart c where c.userId=:userId")

})
public class UserCart implements Serializable{
	
	public UserCart(){
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3812839544124264883L;

	@Id
	@Column(name = "CART_ID")
	@GeneratedValue
	private int cartId;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_FK_ID")
	private Product product;
	
	@Column(name="USER_FK_ID")
	private int userId;
	
	@Column(name="PRODUCT_QUANTITY")
	private int productQuantity;
	
	@Column(name="TOTAL_PRICE")
	private int totalPrice;
	
	@Column(name="CART_STATUS")
	private String cartStatus;
	
	@Column(name="CART_CREATED_DATE")
	private Timestamp cartCreatedDate;
	
	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getCartStatus() {
		return cartStatus;
	}


	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}


	public Timestamp getCartCreatedDate() {
		return cartCreatedDate;
	}


	public void setCartCreatedDate(Timestamp cartCreatedDate) {
		this.cartCreatedDate = cartCreatedDate;
	}


	@Override
    public int hashCode() {
        return getProduct().getId()+getUserId()+getCartCreatedDate().hashCode();
    }
	
	 @Override
	    public boolean equals(final Object obj) {
	        if (this == obj)
	            return true;
	        if (!(obj instanceof UserCart))
	            return false;
	        return getProduct().getId() == ((UserCart) obj).getProduct().getId()&&
	        		getUserId() == ((UserCart) obj).getUserId()&&
	        		getCartCreatedDate().equals(((UserCart) obj).getCartCreatedDate());
	    }
	
}