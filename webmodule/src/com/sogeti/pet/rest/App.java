package com.sogeti.pet.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class App extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	   private Set<Class<?>> classes = new HashSet<Class<?>>();

	   public App(){
	        classes.add(UserEndPoint.class); 
	        classes.add(CategoryEndPoint.class); 
	   }

	   @Override
	   public Set<Class<?>> getClasses() {
	        return classes;
	    }

	   @Override
	   public Set<Object> getSingletons() {
	        return singletons;
	   }

}