package rblearning.models;

public enum LessionType {

	VIDEO("VIDEO"),
	ARTICLE("ARTICLE"),
	SIMPLE_POST("POST");
	
	private String type;
	
	LessionType(String type){
		this.type = type;
	}
	
	
	public String getValue(){
		return type;
	}
	
}
