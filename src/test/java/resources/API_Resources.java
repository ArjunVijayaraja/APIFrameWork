package resources;

//enum is a spl class in Java - it has a collection of CONSTANTS or METHODS
public enum API_Resources {

	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;

	API_Resources(String string) {
		this.resource = string;
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
