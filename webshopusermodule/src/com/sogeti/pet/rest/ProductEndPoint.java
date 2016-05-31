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

import com.sogeti.ejb.beans.interfaces.ProductDAOLocal;
import com.sogeti.pet.entity.Product;

@RequestScoped
@Path("/products")
public class ProductEndPoint {
	
	@EJB
	private ProductDAOLocal productDAOLocal;
	
	@POST
	@Consumes({MediaType.APPLICATION_OCTET_STREAM, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	public Product save(Product product) {
		if(product.getId()==0){
		return productDAOLocal.createProduct(product);
		}else{
			return productDAOLocal.updateProduct(product);
		}
	}
	
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public void delete(@PathParam("id") int id) {
		productDAOLocal.deleteProduct(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		 List<Product> list = productDAOLocal.getAllProducts();
		return list;
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("id") int id) {
		Product product = productDAOLocal.getProductById(id);
		return product;
	}

}
