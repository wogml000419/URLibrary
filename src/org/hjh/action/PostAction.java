/**
 * 
 */
package org.hjh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hjh.service.PostService;
import org.hjh.util.CommonUtil;
import org.hjh.vo.PostVO;
import org.hjh.vo.UserVO;

/**
 * <pre>
 * org.hjh.action
 *   |_ PostAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 29.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class PostAction implements IAction 
{
	private void validate(String title, String url, String shareWith) throws Exception 
	{
		if(CommonUtil.isEmpty(title))
			throw new Exception("제목을 입력하세요");
		if(CommonUtil.isEmpty(url))
			throw new Exception("URL을 입력하세요");
		if(CommonUtil.isEmpty(shareWith))
			throw new Exception("공개 범위를 설정하세요");
	}
	
	private String urlValidate(String url)
	{
		if(!url.startsWith("http://") && !url.startsWith("https://"))
		{
			return "http://" + url;
		}
		return url;
	}
	
	private String getSurl(String url)
	{
		System.out.println(url);
		int doubleSlashIndex = url.indexOf("//");
		String surl = url.substring(doubleSlashIndex + 2);
		int slashIndex = surl.indexOf('/');
		surl = surl.substring(0, slashIndex);
		System.out.println(surl);
		return surl;
	}
	
	private int getShareWithInt(String shareWith)
	{
		if("no one".equals(shareWith))
			return 0;
		else if("followers".equals(shareWith))
			return 1;
		else 
			return 2;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String text = request.getParameter("text");
		String tags = request.getParameter("tags");
		String shareWith = request.getParameter("sharewith");
		
		System.out.println("title: " + title + " url: " + url + " share with: " + shareWith);

		response.setContentType("application/json;charset=utf-8");
		try 
		{
			validate(title, url, shareWith);
			
			int postId = PostService.getLastPostId() + 1;
			url = urlValidate(url);
			String surl = getSurl(url);
			int shareWithInt = getShareWithInt(shareWith);
			UserVO user = (UserVO)request.getSession().getAttribute("user");
			
			if(user == null)
				throw new Exception("로그인되지 않았습니다. 로그인 해 주세요.");
			
			PostVO post = new PostVO(postId, user.getId(), url, surl, title, text, shareWithInt, tags);
		    PostService.insertPost(post);
		    
		    request.setAttribute("title", "글 등록 완료");
		    request.setAttribute("msg", "정상적으로 글이 등록되었습니다.");
		    request.getRequestDispatcher("/timeline.do?isTimeline=true&showerror=false").forward(request, response);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			request.setAttribute("title", "글 등록 실패");
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/timeline.do?isTimeline=true&showerror=false").forward(request, response);
		}
	}

}
