package generalUtilities;

import java.io.FileInputStream;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class Readjson {
	FileInputStream inputFile;
	String jsonFile;
	JSONObject jsonObject;
	JSONParser jsonParser;

	public Readjson(String jsonFile) {
		// TODO Auto-generated constructor stub
		this.jsonFile = jsonFile;
	}

	public JSONObject readjsonFile() {
		try {
			// String path=System.getProperty("user.dir");
			// System.out.println(path+jsonFile);
			inputFile = new FileInputStream(jsonFile);
			// System.out.println(inputFile);
			// FileReader reader = new FileReader(jsonFile);
			jsonParser = new JSONParser();
			jsonObject = (JSONObject) jsonParser.parse(inputFile);
			jsonObject = (JSONObject) jsonObject;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonObject;
	}

	public String getData(String key) {
		jsonObject = readjsonFile();
		// System.out.println(jsonObject);
		String value = (String) jsonObject.get(key);
		return value;
	}

}