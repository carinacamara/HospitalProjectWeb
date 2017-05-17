package hospital.model;

import javax.validation.constraints.Size;

public class Doctor {
	
	private int idDoctor;
	
	@Size(min =  1, message = "Invalid")
	private String username;
	
	@Size(min =  1, message = "Invalid")
	private String password;
	
	@Size(min =  1, message = "Invalid")
	private String name;

	
	
	public Doctor(){}
	
	public Doctor(int idDoctor,String username, String password, String name) {
		this.idDoctor = idDoctor;
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
