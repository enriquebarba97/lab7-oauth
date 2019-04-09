package aiss.model.resource;

import aiss.model.spotify.NewPlaylist;
import aiss.model.spotify.Playlists;
import aiss.model.spotify.UserProfile;
import java.util.logging.Logger;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class SpotifyResource {

    private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());

    private final String access_token;
    private final String baseURL = "https://api.spotify.com/v1";

    public SpotifyResource(String access_token) {
        this.access_token = access_token;
    }

    public Playlists getPlaylists() {
        String playlistsGetURL = baseURL + "/me/playlists";
        ClientResource cr = new ClientResource(playlistsGetURL);

        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);

        Playlists playlists = null;
        try {
            playlists = cr.get(Playlists.class);
            return playlists;

        } catch (ResourceException re) {
            log.warning("Error when retrieving Spotify playlists: " + cr.getResponse().getStatus());
            log.warning(playlistsGetURL);
            return null;
        }
    }

    public boolean createPlaylist(String name, String description) {
        // We need the Spotify UserID in order to make requests to this POST URL
        String userId = this.getUserId();
        if (userId != null && !name.trim().isEmpty()) {

            // ToDo: create post URL (you'll need the userId)
        	String uri = baseURL + "/users/" + userId + "/playlists";
            // ToDo: create properly the ClientResource and the ChallengeResponse
        	ClientResource cr = new ClientResource(uri);
        	 ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
             chr.setRawValue(access_token);
             cr.setChallengeResponse(chr);
            // ToDo: create the NewPlaylist object and set the properties
        	NewPlaylist playlist = new NewPlaylist();
        	playlist.setName(name);
        	playlist.setDescription(description);
            // ToDo: pprint useful log information
        	log.info("Creating the playlist " + playlist.getName());

            try {
                cr.post(playlist, MediaType.APPLICATION_ALL_JSON);
                return true;

            } catch (ResourceException re) {
                // ToDo: print useful log information before returning
            	log.warning("Error when creating a Spotify playlist: " + cr.getResponse().getStatus());
                return false;
            }
        } else {
            log.warning("Error when getting userID from Spotify");
            return false;
        }
    }

    protected String getUserId() {
        String userProfileURL = baseURL + "/me";
        ClientResource cr = new ClientResource(userProfileURL);

        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);

        log.info("Retrieving user profile");

        try {
            return cr.get(UserProfile.class).getId();

        } catch (ResourceException re) {
            log.warning("Error when retrieving the user profile: " + cr.getResponse().getStatus());
            log.warning(userProfileURL);
            return null;
        }
    }
}
