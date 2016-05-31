package com.sogeti.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.sogeti.pet.entity.UserCart;

@Local
public interface CartDAOLocal {
	public UserCart createCart(UserCart userCart);
	public UserCart updateCart(UserCart userCart);
	public void deleteCart(int id);
	public List<UserCart> getAllCarts();
	public UserCart getCartById(int id);
	public List<UserCart> getCartSByUserId(int id);

}
