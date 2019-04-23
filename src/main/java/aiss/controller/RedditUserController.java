package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import aiss.model.resource.RedditResource;
import aiss.utility.RedditOAuth;

/**
 * Servlet implementation class RedditUserController
 */
public class RedditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(RedditUserController.class.getName());
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedditUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Reddit-token");
		if(accessToken != null && !"".equals(accessToken)) {
			Long time = (Long) request.getSession().getAttribute("Reddit-expires");
			String refresh_token = (String) request.getSession().getAttribute("Reddit-refresh");
			accessToken = refrescarToken(accessToken, time, refresh_token, request);
			RedditResource rs = new RedditResource(accessToken);
			String user = rs.getUser();
			request.setAttribute("user", user);
			request.getRequestDispatcher("/reddit.jsp").forward(request, response);
		}else {
			log.info("A por el token que voy");
			request.getRequestDispatcher("/RedditAuthController").forward(request, response);
		}
	}

	private String refrescarToken(String accessToken, Long time, String refresh_token, HttpServletRequest request) {
		String token = accessToken;
		if(System.currentTimeMillis()>(time+3300000L)) {
			log.fine("Refrescando el token de Reddit");
			try {
				JSONObject refresco = RedditOAuth.refreshToken(refresh_token);
				token = refresco.getString("access_token");
				request.getSession().setAttribute("Reddit-token", token);
				request.getSession().setAttribute("Reddit-expires", System.currentTimeMillis());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return token;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
