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
			int postNum = Integer.parseInt(request.getParameter("postNum"));
			String showError = request.getParameter("showerror");
			//isTimeline만 true이면 사용자의 타임라인
			//userToSearch에 값이 있다면 유저의 글에서 검색한 결과 (혹은 타임라인)
			//isTimeline보단 search가 우선도 높음
			System.out.println(isTimeline);
			System.out.println(userToSearch);
			System.out.println(searchJson);		
			System.out.println(showError);
			
			UserVO requestedUser = (UserVO)request.getSession().getAttribute("user");
			PostVO post = null;
			UserVO user = null;
			
			boolean showErrorBool = "false".equals(showError) ? false : true;
			System.out.println(showErrorBool);
			if("true".equals(isTimeline))	//다른 parameter의 값에 관계없이 isTimeline이 true면 유저 자신의 타임라인을 보여줍니다.
			{
				if(requestedUser == null)
					throw new Exception("로그인 해 주세요.");
				int[] postIds = PostService.getTimelinePostIds(requestedUser.getId(), postNum, 1);
				if(postIds[0] == 0)
				{
					if(showErrorBool) throw new Exception("더이상 불러올 포스토가 없습니다.");
				}
				else
				{
				    post = PostService.getPost(postIds[0]);
				    user = UserService.searchUser(post.getUserEmail());
				}
			}
			else
			{
				if(requestedUser == null)
					requestedUser = new UserVO("unknown", null, null);
				int[] postIds = PostService.getOnesPostIds(requestedUser.getId(), userToSearch, postNum, 1);
				if(postIds[0] == 0)
				{
					if(showErrorBool) throw new Exception("더이상 불러올 포스토가 없습니다.");
				}
				else
				{
					post = PostService.getPost(postIds[0]);
					user = UserService.searchUser(post.getUserEmail());
				}
			}
			
			if(post != null)
			{
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				JsonObject obj = new JsonObject();
				obj.add("post", post.toJson());
				obj.add("user", user.toJson());
				out.write(obj.toString());
			}
			
		}
		catch(Exception e)
		{
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("msg", e.getMessage());
			out.write(obj.toString());
			e.printStackTrace();
		}
	}

}
