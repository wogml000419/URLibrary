/**
 * 
 */
package org.hjh.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hjh.service.PostService;
import org.hjh.service.UserService;
import org.hjh.vo.PostVO;
import org.hjh.vo.UserVO;

import com.google.gson.JsonObject;

/**
 * <pre>
 * org.hjh.action
 *   |_ LoadPostAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 27.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class LoadPostAction implements IAction
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{	
		try
		{
			request.setCharacterEncoding("utf-8");
			String isTimeline = request.getParameter("isTimeline");
			String userToSearch = request.getParameter("userToSearch");
			String searchJson = request.getParameter("search");		
			//isTimeline만 true이면 사용자의 타임라인
			//userToSearch에 값이 있다면 유저의 글에서 검색한 결과 (혹은 타임라인)
			//isTimeline보단 search가 우선도 높음
			System.out.println(isTimeline);
			System.out.println(userToSearch);
			System.out.println(searchJson);		
			
			PostVO post = PostService.getPost(3);
			UserVO user = UserService.searchUser(post.getUserEmail());
			response.setContentType("application/json;charset=utf-8");
			if(post != null)
			{
				PrintWriter out = response.getWriter();
				JsonObject obj = new JsonObject();
				obj.add("post", post.toJson());
				obj.add("user", user.toJson());
				out.write(obj.toString());
			}
		}
		catch(Exception e)
		{
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}
	}

}
