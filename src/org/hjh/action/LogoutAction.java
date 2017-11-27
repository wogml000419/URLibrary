/**
 * 
 */
package org.hjh.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * org.hjh.action
 *   |_ LogoutAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 24.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class LogoutAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
		rd.forward(request, response);
	}

}
