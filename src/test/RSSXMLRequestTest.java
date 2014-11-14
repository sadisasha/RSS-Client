import com.rssReader.util.RSSXMLRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/** @author sobolevstp */
public class RSSXMLRequestTest {

	private RSSXMLRequest xmlRequest;

	@org.junit.Before
	public void setUp() throws Exception {
		xmlRequest = new RSSXMLRequest("http://study-java.ru/feed/");
	}

	@Test
	public void xmlFileIsNotEmpty() throws Exception {
		String excepted = "";
		excepted = xmlRequest.getXMLFile();
		assertNotEquals(excepted, "");
	}

}
