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

import com.sogeti.ejb.beans.interfaces.CartDAOLocal;
import com.sogeti.pet.entity.UserCart;

@RequestScoped
@Path("/UserCart")
public class CartEndPoint {
	
	@EJB
	private CartDAOLocal cartDAOLocal;
	
	@POST
	@Consumes({MediaType.APPLICATION_OCTET_STREAM, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	public UserCart create(UserCart userCart) {
		if(userCart.getCartId()==0){
		return cartDAOLocal.createCart(userCart);
		}else{
			return cartDAOLocal.updateCart(userCart);
		}
	}
	
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public void delete(@PathParam("id") int id) {
			cartDAOLocal.deleteCart(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserCart> getAllCarts() {
		 List<UserCart> list = cartDAOLocal.getAllCarts();
		return list;
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserCart getCartById(@PathParam("id") int id) {
		UserCart userCart = cartDAOLocal.getCartById(id);
		return userCart;
	}
	
	@GET
	@Path("/userid/{userid:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserCart> getCartSByUserId(@PathParam("userid") int id) {
		List<UserCart> userCartList = cartDAOLocal.getCartSByUserId(id);
		return userCartList;
	}
	
}
