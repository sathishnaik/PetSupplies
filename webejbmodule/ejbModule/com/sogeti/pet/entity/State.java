package com.sogeti.pet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "STATES")
@NamedQueries({
   
    @NamedQuery(name="State.getAll",query="SELECT s FROM State s")

})
public class State implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7090025074031646219L;

	@Id
	@Column(name = "STATE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stateId;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
