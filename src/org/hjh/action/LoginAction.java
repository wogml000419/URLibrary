/**
 * 
 */
package org.hjh.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hjh.service.UserService;
import org.hjh.util.CommonUtil;
import org.hjh.vo.UserVO;

/**
 * <pre>
 * org.hjh.action
 *   |_ LoginAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 24.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class LoginAction implements IAction {
	
	private void validate(String id, String pwd) throws Exception {
		if(CommonUtil.isEmpty(id))
			throw new Exception("id를 입력하세요");
		if(CommonUtil.isEmpty(pwd))
			throw new Exception("비밀번호를 입력하세요");
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try 
		{
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			System.out.println("id: " + id + " pwd: " + pwd);

			validate(id, pwd);

			UserVO vo = new UserVO(id, pwd, "");
			
			UserVO result = UserService.login(vo);
		
			response.setContentType("text/html;charset=utf-8");
		
			if(result != null)
			{
				//세션에 사용자 정보 생성
				HttpSession session = request.getSession();
				session.setAttribute("user", result);
				RequestDispatcher rd = request.getRequestDispatcher("/timeline.do?isTimeline=true&showerror=false");
				rd.forward(request, response);
			}
			else
			{
				throw new Exception("ID 혹은 비밀번호가 맞지 않습니다.");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			request.setAttribute("title", "로그인 실패");
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("carousel", 0);			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
			rd.forward(request, response);
		}
	}

}
