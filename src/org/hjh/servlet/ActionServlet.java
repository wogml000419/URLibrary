package org.hjh.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hjh.action.*;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, IAction> actions = new HashMap<>();
 
    public ActionServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	actions.put("login", new LoginAction());
    	actions.put("logout", new LogoutAction());
    	actions.put("signup", new SignupAction());
    	actions.put("loadpost", new LoadPostAction());
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String uri = request.getRequestURI();
			System.out.println(uri);
			uri = uri.substring(uri.lastIndexOf('/') + 1);
			uri = uri.substring(0, uri.indexOf('.'));
			
			IAction action = actions.get(uri);
			if(action == null)
				throw new Exception(uri + "은 잘못된 ActionName입니다.");
			action.execute(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("JSP/error.jsp").forward(request, response);
		}
	}
}
