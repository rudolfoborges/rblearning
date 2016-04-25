package rblearning.models;

public enum Role {

	ADMIN("ADMIN"),
	VISITOR("VISITOR");
	
	private String role;
	
	Role(String role){
		this.role = role;
	}
	
	
	public String getValue(){
		return role;
	}
}
