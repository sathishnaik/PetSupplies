package com.sogeti.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.sogeti.pet.entity.State;
import com.sogeti.pet.entity.User;

@Local
public interface UserDAOLocal {
	
	public User createUser(User user);
	public User updateUser(User user);
	public void remove(int id);
	public User getUser(int id);
	public List<User> getAllUsers();
	public User getUserByUsername(String username);
	public List<State> getStates();

}
