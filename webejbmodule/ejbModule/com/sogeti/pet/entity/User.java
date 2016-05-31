package com.sogeti.pet.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "WEBSHOPUSER")
@NamedQueries({
    @NamedQuery(
            name="User.getUserByUserName",
            query="Select u From User u Where u.username = :username"
        ),
    @NamedQuery(name="User.getAll",query="SELECT u FROM User u")

})

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1460230029504558414L;

	@Id
	@Column(name = "LOGIN_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="USER_ROLE")
	private String userRole;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn (name="ADDRESS_FK_ID")
	/*@JsonManagedReference
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@userAddress")*/
	private UserAddress userAddress;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	    public int hashCode() {
	        HashCodeBuilder hcb = new HashCodeBuilder();
	        hcb.append(username);
	        return hcb.toHashCode();
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (!(obj instanceof User)) {
	            return false;
	        }
	        User that = (User) obj;
	        EqualsBuilder eb = new EqualsBuilder();
	        eb.append(username, that.username);
	        return eb.isEquals();
	    }
	
}
