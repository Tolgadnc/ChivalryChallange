

public class Items {
	private String name;
	private String description;
	
	
	//Constructor
	
	public Items (String name, String description) {
		this.name = name;
		this.description = description;
		
		
	}
	
	//getter methods
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public String toString(Items item){
		return getName();
	}
	
}