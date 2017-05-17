package hospital.model;

public class User {
	
	private int idUser;
	private String username;
	private String password;
	private String role;
	
	
	public User(){}
	
	
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
