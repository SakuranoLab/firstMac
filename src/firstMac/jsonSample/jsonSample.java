package firstMac.jsonSample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonSample {

	public static void main(String[] args) {

		//System.out.println("Fuck off the world!!!!!");

		String result ="";
		JsonNode root = null;
		String url = "https://cat-fact.herokuapp.com/facts/random";
		CatFactsRandom model=null;

		try {
			URL urlU = new URL(url);
			HttpURLConnection con = (HttpURLConnection)urlU.openConnection();
			con.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String tmp = "";

			while((tmp = in.readLine()) != null) {
				result += tmp;
			}

			ObjectMapper mapper = new ObjectMapper();

			root = mapper.readTree(result);
			in.close();
			con.disconnect();

			model = mapper.readValue(result, CatFactsRandom.class);

		}catch(Exception e) {
			e.printStackTrace();
		}

//		System.out.println(result);

		System.out.println(model.text);
	}

}
