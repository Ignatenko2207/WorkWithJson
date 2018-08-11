package info.sjd;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class AppRunner {

	private static Logger logger = Logger.getLogger(AppRunner.class.getName());
	
	public static void main(String[] args){
		
		String content = "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"NigelRees\",\"title\":\"SayingsoftheCentury\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"EvelynWaugh\",\"title\":\"SwordofHonour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"HermanMelville\",\"title\":\"MobyDick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J.R.R.Tolkien\",\"title\":\"TheLordoftheRings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],\"bicycle\":{\"color\":\"red\",\"price\":19.95}},\"expensive\":10}";
		
		DocumentContext context = JsonPath.parse(content);
	
		logger.info(context.read("$.store.book[0].author", String.class));
		
		logger.info(context.read("$.store.book[3].title", String.class));
		
		Map<String, Object> book = new HashMap<>();
		book.put("category", "fiction");
		book.put("author", "J. R. R. Tolkien");
		book.put("title", "The Lord of the Rings2");
		book.put("isbn", "0-395-19395-9");
		book.put("price", 33.99);
		
		context.add("$.store.book", book);
		
		logger.info(context.read("$.store.book[4].title", String.class));
		
	}
}
