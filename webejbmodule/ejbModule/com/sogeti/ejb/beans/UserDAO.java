package com.sogeti.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sogeti.ejb.beans.interfaces.UserDAOLocal;
import com.sogeti.pet.entity.State;
import com.sogeti.pet.entity.User;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
public class UserDAO implements UserDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
	  /**
     * Default constructor. 
     */
    public UserDAO() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void remove(int id) {
		em.remove(getUser(id));
		
	}

	@Override
	public User getUser(int id) {
		return em.find(User.class, id);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return em.createNamedQuery("User.getUserByUserName", User.class).
				setParameter("username", username).getSingleResult();
	}
	
    @Override
	public List<User> getAllUsers() {
		return em.createNamedQuery("User.getAll", User.class).getResultList();
	}
    
    @Override
	public List<State> getStates() {
		return em.createNamedQuery("State.getAll", State.class).getResultList();
	}

}
