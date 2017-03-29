package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.facebook.FacebookFriends;
import aiss.model.resource.FacebookFriendsResource;

public class FacebookFriendsController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6818025976353856770L;
	private static final Logger log = Logger.getLogger(FacebookFriendsController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		String accessToken=(String)req.getSession().getAttribute("Facebook-token");
		if(accessToken!=null && !"".equals(accessToken)){
			FacebookFriendsResource fbResource=new FacebookFriendsResource(accessToken);
			FacebookFriends friends=fbResource.getFriends();
			if(friends!=null){
				req.setAttribute("friends", friends);
				req.getRequestDispatcher("/FacebookFriendsView.jsp").forward(req,resp);
			}else{
				log.info("The friends returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("/AuthController/Facebook").forward(req,resp);
			}
		}else{
			log.info("Trying to acces to Facebook without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("/AuthController/Facebook").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}


}
