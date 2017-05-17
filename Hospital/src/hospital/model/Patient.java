package hospital.model;

import javax.validation.constraints.Size;

public class Patient {
	
	private int idPatient;
	
	
	@Size(min = 1, message = "Invalid" )
	private String identityCard;
	
	@Size(min = 1, max = 13 ,message = "Invalid" )
	private Long CNP;
	
	@Size(min = 1, message = "Address is requiered")
	private String address;
	
	@Size(min = 1, message = "Name is requiered")
	private String name;
	
	
	public Patient(){}
	
	
	
	public Patient(String identityCard, Long CNP, String address, String name) {
		
		this.identityCard = identityCard;
		this.CNP = CNP;
		this.address = address;
		this.name = name;
		
		
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public Long getCNP() {
		return CNP;
	}
	public void setCNP(Long cNP) {
		CNP = cNP;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
