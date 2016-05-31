package com.sogeti.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.sogeti.pet.entity.OrderDetail;
import com.sogeti.pet.entity.UserOrder;

@Local
public interface OrderDAOLocal {
	
	public UserOrder createUserOrder(UserOrder userOrder);
	public UserOrder updateUserOrder(UserOrder userOrder);
	public void deleteUserOrder(int id);
	public List<UserOrder> getAllUserOrders();
	public UserOrder getUserOrderById(int id);
	public List<UserOrder> getUserOrdersByUserId(int userId);
	public OrderDetail createOrderDetail(OrderDetail orderDetail);
	public OrderDetail updateOrderDetail(OrderDetail orderDetail);
	public List<OrderDetail> getOrderDetailsByOrderId(int orderId);

}
