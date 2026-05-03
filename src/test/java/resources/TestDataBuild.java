package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.PlaceData;

public class TestDataBuild {
	
//THis is Static Data	
//	public PlaceData addPlacePayload()
//	{
//		PlaceData data = new PlaceData();
//		Location loc = new Location();
//		List<String> type = new ArrayList<String>();
//		type.add("shoe park");
//		type.add("shop");
//		loc.setLat("-38.383494");
//		loc.setLng("427362");
//		data.setLocation(loc);
//		data.setAccuracy(50);
//		data.setName("Frontline house");
//		data.setPhone_number("(+91) 983 893 3937");
//		data.setAddress("29, side layout, cohen 09");
//		data.setTypes(type);
//		data.setWebsite("http://google.com");
//		data.setLanguage("French-IN");
//		return data;
//	}
	
	
	//This is for Dynamic Data
	public PlaceData addPlacePayload(String name, String language, String address)
	{
		PlaceData data = new PlaceData();
		Location loc = new Location();
		List<String> type = new ArrayList<String>();
		type.add("shoe park");
		type.add("shop");
		loc.setLat("-38.383494");
		loc.setLng("427362");
		data.setLocation(loc);
		data.setAccuracy(50);
		data.setName(name);
		data.setPhone_number("(+91) 983 893 3937");
		data.setAddress(address);
		data.setTypes(type);
		data.setWebsite("http://google.com");
		data.setLanguage(language);
		return data;
	}

}
