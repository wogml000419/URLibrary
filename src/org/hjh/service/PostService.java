/**
 * 
 */
package org.hjh.service;

import java.sql.Connection;

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
				throw new Exception("존재하지 않는 글입니다.");
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
