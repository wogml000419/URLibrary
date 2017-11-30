/**
 * 
 */
package org.hjh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
	
	public int[] getTimelinePostIds(String requestedUser, int start, int cnt) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		FollowsDao fdao = new FollowsDao(conn);
		List<String> follows = fdao.getFollows(requestedUser);
		if(follows.size() == 0)
			throw new Exception("팔로우한 목록이 존재하지 않습니다.");
		
		StringBuilder where = new StringBuilder();
		for(String follow : follows)
		{
			where.append("(USEREMAIL='" + follow + "' AND SHAREWITH!=0) OR ");
		}
		int lastIndex = where.lastIndexOf("OR");
		if(lastIndex >= 0)
			where.delete(lastIndex, where.length());
		
		
		String sql = "SELECT POSTID FROM POST WHERE " + where + "ORDER BY POSTID DESC LIMIT ?, ?";
		System.out.println(sql + "(" + start + ", " + cnt + ")");
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, cnt);
			
			rs = pstmt.executeQuery();
			
			int i=0;
			int[] result = new int[cnt];
			while(rs.next())
			{
				result[i] = rs.getInt(1);
				i++;
			}
			
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
	
	public int[] getOnesPostIds(String userEmail, int start, int cnt, int shareWith) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT POSTID FROM POST WHERE USEREMAIL=? AND SHAREWITH>=? ORDER BY POSTID DESC LIMIT ?, ?";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			pstmt.setInt(2, shareWith);
			pstmt.setInt(3, start);
			pstmt.setInt(4, cnt);
			
			rs = pstmt.executeQuery();
			
			int i=0;
			int[] result = new int[cnt];
			while(rs.next())
			{
				result[i] = rs.getInt(1);
				i++;
			}
			
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
