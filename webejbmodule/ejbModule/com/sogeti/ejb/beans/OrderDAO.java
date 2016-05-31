package com.sogeti.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sogeti.ejb.beans.interfaces.OrderDAOLocal;
import com.sogeti.pet.entity.OrderDetail;
import com.sogeti.pet.entity.UserOrder;

/**
 * Session Bean implementation class CartDAO
 */
@Stateless
@LocalBean
public class OrderDAO implements OrderDAOLocal {

    /**
     * Default constructor. 
     */
    public OrderDAO() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
   	private EntityManager em;
   	
   	 
       
       @Override
   	public UserOrder createUserOrder(UserOrder userOrder) {
   		em.persist(userOrder);
   		return userOrder;
   	}
       
       @Override
      	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
      		em.persist(orderDetail);
      		return orderDetail;
      	}
       
       @Override
      	public UserOrder updateUserOrder(UserOrder userOrder) {
      		em.merge(userOrder);
      		return userOrder;
      	}
       
       @Override
     	public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
     		em.merge(orderDetail);
     		return orderDetail;
     	}
       
       @Override
      	public void deleteUserOrder(int id) {
      		em.remove(getUserOrderById(id));
      	}
       
       @Override
      	public List<UserOrder> getAllUserOrders() {
      		return em.createNamedQuery("UserOrder.getAll", UserOrder.class).getResultList();
      	}
       
       @Override
      	public UserOrder getUserOrderById(int id) {
      		return em.find(UserOrder.class, id);
      	}
       
       @Override
     	public List<UserOrder> getUserOrdersByUserId(int userId) {
      	return em.createNamedQuery("UserOrder.getAllByUserId", UserOrder.class).setParameter("userId", userId).getResultList();
     	}
       
       @Override
    	public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
     	return em.createNamedQuery("OrderDetail.getAllByOrderId", OrderDetail.class).setParameter("order", getUserOrderById(orderId)).getResultList();
    	}
       

}
