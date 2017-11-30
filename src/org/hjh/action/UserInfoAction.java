/**
 * 
 */
package org.hjh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hjh.service.UserService;
import org.hjh.vo.UserVO;

/**
 * <pre>
 * org.hjh.action
 *   |_ UserInfoAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 30.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class UserInfoAction implements IAction 
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("utf-8");
		UserVO user = (UserVO)request.getSession().getAttribute("user");
		if(user == null)
			throw new Exception("로그인 해 주세요");
		
		request.setAttribute("follows", UserService.getFollowsOf(user.getId()));
		request.getRequestDispatcher("/jsp/userinfo.jsp").forward(request, response);
	}

}
