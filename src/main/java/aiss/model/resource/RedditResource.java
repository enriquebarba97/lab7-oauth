package aiss.model.resource;

import java.io.IOException;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class RedditResource {
	private static final String uri = "https://oauth.reddit.com/api/v1/me";
	private static final Logger log = Logger.getLogger(RedditResource.class.getName());
	private final String access_token;
	
	public RedditResource(String access_token) {
		this.access_token = access_token;
	}
	
	public String getUser() throws IOException {
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
		cr.setChallengeResponse(chr);
		
		String result = null;
		try {
			result = cr.get(MediaType.APPLICATION_JSON).getText();
		}catch(ResourceException e) {
			log.warning("ERROR: " + e.getMessage());
		}
		return result;
	}
}
