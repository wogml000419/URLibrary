/**
 * 
 */
package org.hjh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hjh.util.CommonUtil;

/**
 * <pre>
 * org.hjh.action
 *   |_ TimelineAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 30.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class TimelineAction implements IAction 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("utf-8");
		String isTimeline = request.getParameter("isTimeline");
		String userToSearch = request.getParameter("userToSearch");
		String search = request.getParameter("search");
		String showError = request.getParameter("showerror");
		
		if(CommonUtil.isEmpty(search) && CommonUtil.isEmpty(userToSearch))
		{
			isTimeline="true"; //검색어와 검색할 유저 둘 다 없으면 자신의 타임라인으로 리다이렉트
		}
		
		boolean isTimelineBool = ("true".equals(isTimeline) ? true : false); 

		request.setAttribute("isTimeline", isTimelineBool);
		request.setAttribute("userToSearch", userToSearch);
		request.setAttribute("search", search);
		request.setAttribute("showerror", showError);
		request.getRequestDispatcher("/jsp/timeline.jsp").forward(request, response);
	}

}
