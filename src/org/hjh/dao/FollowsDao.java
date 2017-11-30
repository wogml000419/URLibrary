/**
 * 
 */
package org.hjh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hjh.vo.PostVO;

/**
 * <pre>
 * org.hjh.dao
 *   |_ FollowsDao
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 30.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class FollowsDao 
{
	private Connection conn = null;
	
	public FollowsDao(Connection conn)
	{
		this.conn = conn;
	}
	
	public List<String> getFollows(String user) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT FOLLOWS FROM FOLLOWS WHERE USER=?";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			
			rs = pstmt.executeQuery();
			
			List<String> result = new ArrayList<String>();
			while(rs.next())
			{
				result.add(rs.getString(1));
			}
			System.out.println(result);
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("팔로우 목록을 조회하는 중 오류가 발생하였습니다.");
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
}
