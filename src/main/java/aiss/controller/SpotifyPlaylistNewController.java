package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpotifyPlaylistNewController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -6818025976353856770L;
    private static final Logger log = Logger.getLogger(SpotifyPlaylistNewController.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
// ToDo: get 'name' and 'description' parameters
        // ToDo: if 'name' and 'description'
            // ToDo: get token
            // ToDo: if token
                // ToDo: create spotify resource with this id and create playlist with 'name' and 'description'; 
            // ToDo: else
                // ToDo: redirect to oauth servlet
        // ToDo: else (i.e., no parameters passed) 
            // ToDo: redirect to /spotifyPlaylistCreate.jsp
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}
