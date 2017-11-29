/**
 * 
 */
package org.hjh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hjh.vo.PostVO;

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
				result.setTitle(rs.getString(3));
				result.setUrl(rs.getString(4));
				result.setSurl(rs.getString(5));				
				result.setUserText(rs.getString(6));
				result.setShareWith(rs.getInt(7));
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
	
	public int getLastPostId() throws Exception 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT POSTID FROM POST ORDER BY POSTID DESC LIMIT 1";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			int result = -1;
			if(rs.next())
			{
				result = rs.getInt(1);
			}
			if(result == -1)
				throw new Exception();
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
	
	public void insertPost(PostVO post) throws Exception
	{
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO POST VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post.getPostID());
			pstmt.setString(2, post.getUserEmail());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getUrl());
			pstmt.setString(5, post.getSurl());
			pstmt.setString(6, post.getUserText());
			pstmt.setInt(7, post.getShareWith());			
		
			int cnt = pstmt.executeUpdate();
			if(cnt != 1)
				throw new Exception();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("글을 등록하는 중 오류가 발생하였습니다.");
		}
		finally
		{
			if(pstmt != null) pstmt.close();
		}
	}
}
