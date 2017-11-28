/**
 * 
 */
package org.hjh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hjh.vo.PostVO;
import org.hjh.vo.UserVO;

/**
 * <pre>
 * org.hjh.dao
 *   |_ PostDao
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 28.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class PostDao 
{
	private Connection conn = null;
	
	public PostDao(Connection conn)
	{
		this.conn = conn;
	}
	
	public PostVO getPostById(int postId) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT * FROM POST WHERE POSTID=?";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			
			rs = pstmt.executeQuery();
			PostVO result = null;
			while(rs.next())
			{
				result = new PostVO();
				result.setPostID(rs.getInt(1));
				result.setUserEmail(rs.getString(2));
				result.setUrl(rs.getString(3));
				result.setSurl(rs.getString(4));
				result.setUrlText(rs.getString(5));
				result.setTitle(rs.getString(6));
				result.setUserText(rs.getString(7));
				
				result.setUrlThumbnail("/image/urlthumbnails/" + result.getPostID() + ".jpg");
			}
			System.out.println(result);
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("포스트를 조회하는 중 오류가 발생하였습니다.");
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
}
