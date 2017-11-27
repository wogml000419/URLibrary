/**
 * 
 */
package org.hjh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hjh.service.UserService;
import org.hjh.util.CommonUtil;
import org.hjh.vo.UserVO;

/**
 * <pre>
 * org.hjh.action
 *   |_ SignupAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 24.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class SignupAction implements IAction {

	private void validate(String id, String pwd, String repwd, String nickname) throws Exception {
		if(CommonUtil.isEmpty(id)) throw new Exception("id를 입력하세요");
		if(CommonUtil.isEmpty(pwd)) throw new Exception("비밀번호를 입력하세요");
		if(CommonUtil.isEmpty(repwd)) throw new Exception("비밀번호를 한 번 더 입력하세요");
		if(CommonUtil.isEmpty(nickname)) throw new Exception("닉네임을 입력하세요");
		
		if(!pwd.equals(repwd)) throw new Exception("비밀번호를 잘못 입력하였습니다.");
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");		
		String nickname = request.getParameter("nickname");
		
		System.out.println("id: " + id + " pass: " + pwd + " re-pass: " + repwd + " nick: " + nickname);
		response.setContentType("application/json;charset=utf-8");
		try {
			validate(id, pwd, repwd, nickname);
			
			UserService.signup(new UserVO(id, pwd, nickname));
			request.setAttribute("title", "회원가입 성공");
			request.setAttribute("msg", "회원가입에 성공하였습니다.");
			request.setAttribute("carousel", 0);	
			request.getRequestDispatcher("jsp/main.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("title", "회원가입 실패");
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("carousel", 2);	
			request.getRequestDispatcher("jsp/main.jsp").forward(request, response);
		}
	}
}
