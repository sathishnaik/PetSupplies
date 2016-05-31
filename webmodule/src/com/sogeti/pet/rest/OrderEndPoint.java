package com.sogeti.pet.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sogeti.ejb.beans.interfaces.OrderDAOLocal;
import com.sogeti.pet.entity.OrderDetail;
import com.sogeti.pet.entity.UserOrder;

@RequestScoped
@Path("/UserOrder")
public class OrderEndPoint {
	
	@EJB
	private OrderDAOLocal orderDAOLocal;
	
	@POST
	@Consumes({MediaType.APPLICATION_OCTET_STREAM, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	public UserOrder create(UserOrder userOrder) {
		if(userOrder.getOrderId()==0){
		return orderDAOLocal.createUserOrder(userOrder);
		}else{
			return orderDAOLocal.updateUserOrder(userOrder);
		}
	}
	
	@POST
	@Path("/detail")
	@Consumes({MediaType.APPLICATION_OCTET_STREAM, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		if(orderDetail.getOrderDetailId()==0){
		return orderDAOLocal.createOrderDetail(orderDetail);
		}else{
			return orderDAOLocal.updateOrderDetail(orderDetail);
		}
	}
	
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public void delete(@PathParam("id") int id) {
		orderDAOLocal.deleteUserOrder(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserOrder> getAllOrders() {
		 List<UserOrder> list = orderDAOLocal.getAllUserOrders();
		 for(UserOrder p:list){
			 System.out.println(p.getOrderId());
		 }
		return list;
	}
	
	@GET
	@Path("/userid/{userid:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserOrder> getOrdersByUserId(@PathParam("userid") int id) {
		List<UserOrder> userOrderList = orderDAOLocal.getUserOrdersByUserId(id);
		for(UserOrder userOrder: userOrderList){
			System.out.println(userOrder.getOrderStatus());
		}
		return userOrderList;
	}
	
	@GET
	@Path("/orderid/{orderid:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderDetail> getOrderDetailsByOrderId(@PathParam("orderid") int id) {
		List<OrderDetail> orderDetailList = orderDAOLocal.getOrderDetailsByOrderId(id);
		for(OrderDetail orderDetail: orderDetailList){
			System.out.println(orderDetail.getOrderDetailId());
		}
		return orderDetailList;
	}
	
}
