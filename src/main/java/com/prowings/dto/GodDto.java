package com.prowings.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class GodDto {

	
	private Long id;
	@NonNull
	@NotBlank
	@NotEmpty
	private String godName;
	@NonNull
	@NotBlank
	@NotEmpty
	private String godPlace;
	@NonNull
	@NotBlank
	@NotEmpty
	private String godAnicientTime;
	@Pattern(
	        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
	        message = "Invalid email address"
	    )
	private String godemail;
	@NonNull
	@NotBlank
	@NotEmpty
	private String currentState;

	public GodDto() {
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
		return "GodDto [id=" + id + ", godName=" + godName + ", godPlace=" + godPlace + ", godAnicientTime="
				+ godAnicientTime + ", godemail=" + godemail + ", currentState=" + currentState + "]";
	}
	 
	
	
	
}
