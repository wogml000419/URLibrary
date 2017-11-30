/**
 * 
 */
package org.hjh.service;

import java.sql.Connection;

import org.hjh.dao.FollowsDao;
import org.hjh.dao.PostDao;
import org.hjh.dao.TagDao;
import org.hjh.vo.PostVO;

/**
 * <pre>
 * org.hjh.service
 *   |_ PostService
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 28.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class PostService extends AbstractService
{
	public static PostVO getPost(int postID) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			PostDao dao = new PostDao(conn);
			PostVO result = dao.getPostById(postID);
 			if(result == null)
				throw new Exception(postID + "는 존재하지 않는 글입니다.");
 			TagDao tdao = new TagDao(conn);
 			result.setTags(tdao.getTagOfPost(result.getPostID()));
			return result;
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public static int getLastPostId() throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			PostDao dao = new PostDao(conn);
			return dao.getLastPostId();
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public static int[] getTimelinePostIds(String requestedUser, int start, int cnt) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			PostDao dao = new PostDao(conn);
			return dao.getTimelinePostIds(requestedUser, start, cnt);
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public static int[] getOnesPostIds(String requestedUser, String userToSearch, int start, int cnt) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			PostDao dao = new PostDao(conn);
			FollowsDao fdao = new FollowsDao(conn);
			
			int shareWith = 2;
			if(userToSearch.equals(requestedUser))
			{
				shareWith = 0;
			}
			else if(fdao.isFollowing(requestedUser, userToSearch))
			{
				shareWith = 1;
			}
			else
			{
				shareWith = 2;
			}
				
			return dao.getOnesPostIds(userToSearch, start, cnt, shareWith);
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public static void insertPost(PostVO post) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			PostDao dao = new PostDao(conn);
			dao.insertPost(post);
			
			TagDao tdao = new TagDao(conn);
			tdao.setTagOfPost(post.getPostID(), post.getTags());
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
}
