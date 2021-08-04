import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class ReadVegesData{
	private JSONObject json_obj;
	private JSONArray vegeList;
	private String[] vegeNames;
	
	ReadVegesData() throws IOException, ParseException{
		
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("./json_files/vegetablesData.json");
		Object obj = jsonparser.parse(reader);
		json_obj = (JSONObject)obj;
		vegeList = (JSONArray)json_obj.get("vegetables");
		vegeNames = new String[10];
		
	}
	
	//@Override
	public String getName(String n) {
		for(int i = 0; i < vegeList.size();i++) {
			JSONObject vegeItem = (JSONObject) vegeList.get(i);
			String vegeName = (String) vegeItem.get("name");
			if(vegeName == n) {
				return vegeName;
			}
		}
		return null;
	}
	
	//@Override
	public String[] getNames() {
		for(int i = 0; i < vegeList.size();i++) {
			JSONObject vegeItem = (JSONObject) vegeList.get(i);
			String vegeName = (String) vegeItem.get(vegeItem);
			vegeNames[i] = vegeName;
		}
		return vegeNames;
	}

//	@Override
//	public String[] getcalories() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public String getcalorie() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getservingSize() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String[] getservingSizes() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getNutrition() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String[] getNutritions() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
