 package Sufiyancoltd.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datagetter {

	public List<HashMap<String, String>> jasondatagetter() throws IOException {
		// Converting string to jason

		String jasoncon = FileUtils.readFileToString(new File(
				"\\Users\\This PC\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\Sufiyancoltd\\data\\data.jason"),
				StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jasoncon,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}
