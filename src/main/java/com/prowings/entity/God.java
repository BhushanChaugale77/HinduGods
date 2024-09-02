package com.prowings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class God {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String godName;

	private String godPlace;
	
	private String godAnicientTime;
	
	private String godemail;
	
	private String currentState;

	public God() {
		super();
 	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGodName() {
		return godName;
	}

	public void setGodName(String godName) {
		this.godName = godName;
	}

	public String getGodPlace() {
		return godPlace;
	}

	public void setGodPlace(String godPlace) {
		this.godPlace = godPlace;
	}

	public String getGodAnicientTime() {
		return godAnicientTime;
	}

	public void setGodAnicientTime(String godAnicientTime) {
		this.godAnicientTime = godAnicientTime;
	}

	public String getGodemail() {
		return godemail;
	}

	public void setGodemail(String godemail) {
		this.godemail = godemail;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	@Override
	public String toString() {
		return "God [id=" + id + ", godName=" + godName + ", godPlace=" + godPlace + ", godAnicientTime="
				+ godAnicientTime + ", godemail=" + godemail + ", currentState=" + currentState + "]";
	}
	
	 
	
	
	
}
