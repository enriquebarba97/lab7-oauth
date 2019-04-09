package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.SpotifyResource;

public class SpotifyPlaylistNewController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -6818025976353856770L;
    private static final Logger log = Logger.getLogger(SpotifyPlaylistNewController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
// ToDo: get 'name' and 'description' parameters
    	String name = req.getParameter("name");
    	String description = req.getParameter("description");
        // ToDo: if 'name' and 'description'
    	if(name != null && description != null) {
            // ToDo: get token
    		String accessToken = (String) req.getSession().getAttribute("Spotify-token");
            // ToDo: if token
    		if(accessToken != null && !"".equals(accessToken)) {
                // ToDo: create spotify resource with this id and create playlist with 'name' and 'description';
    			SpotifyResource spResource = new SpotifyResource(accessToken);
    			spResource.createPlaylist(name, description);
            // ToDo: else
    		}else {
    			// ToDo: redirect to oauth servlet
    			log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
                req.getRequestDispatcher("/AuthController/Spotify").forward(req, resp);
    		}
        // ToDo: else (i.e., no parameters passed) 
    	}else {
    		// ToDo: redirect to /spotifyPlaylistCreate.jsp
    		 req.getRequestDispatcher("/spotifyPlaylistCreate.jsp").forward(req, resp);
    	}
        req.getRequestDispatcher("/spotifyPlaylistsGet").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}
