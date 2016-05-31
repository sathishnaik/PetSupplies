package com.sogeti.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sogeti.ejb.beans.interfaces.CartDAOLocal;
import com.sogeti.pet.entity.UserCart;

/**
 * Session Bean implementation class CartDAO
 */
@Stateless
@LocalBean
public class CartDAO implements CartDAOLocal {

    /**
     * Default constructor. 
     */
    public CartDAO() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
   	
   	 
       
       @Override
   	public UserCart createCart(UserCart userCart) {
   		em.persist(userCart);
   		return userCart;
   	}
       
       @Override
      	public UserCart updateCart(UserCart userCart) {
      		em.merge(userCart);
      		return userCart;
      	}
       
       @Override
      	public void deleteCart(int id) {
      		em.remove(getCartById(id));
      	}
       
       @Override
      	public List<UserCart> getAllCarts() {
      		return em.createNamedQuery("UserCart.getAll", UserCart.class).getResultList();
      	}
       
       @Override
      	public UserCart getCartById(int id) {
      		return em.find(UserCart.class, id);
      	}
       
       @Override
     	public List<UserCart> getCartSByUserId(int userId) {
      	return em.createNamedQuery("UserCart.getAllByUserId", UserCart.class).setParameter("userId", userId).getResultList();
     	}
       

}
