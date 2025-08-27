package NikhitaJagota.Ecommerce;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProvider {
	
	public List<HashMap<String, String>> getData() throws IOException
	{
		File file = new File(System.getProperty("User.dir")+"\\src\\main\\java\\NikhitaJagota\\Ecommerce\\dataReader\\orderData.json");
	
	
		String jsonContent=FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
	    List<HashMap<String, String>> data = mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {}
        );
	    
	    return data;
		
	}

}
