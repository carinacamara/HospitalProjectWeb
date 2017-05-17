package hospital.model;

import javax.validation.constraints.Size;

public class Secretary {
	
	private int idSecretary;
	
	
	@Size(min = 1, message = "Everybody has a name!" )
	private String name;
	
	@Size(min = 1, message = "He/She needs an username!" )
	private String username;
	
	@Size(min = 1, message = "No password?!" )
	private String password;
	
	
	public Secretary(){}
	

	
	public Secretary(int idSecretary,String name, String username, String password) {
		this.idSecretary = idSecretary;
		this.name = name;
		this.username = username;
		this.password = password;
	}




	public int getIdSecretary() {
		return idSecretary;
	}
	public void setIdSecretary(int idSecretary) {
		this.idSecretary = idSecretary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
