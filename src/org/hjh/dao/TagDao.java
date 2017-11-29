/**
 * 
 */
package org.hjh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <pre>
 * org.hjh.dao
 *   |_ TagDao
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 28.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class TagDao 
{
	private Connection conn = null;
	
	public TagDao(Connection conn)
	{
		this.conn = conn;
	}
	
	public String getTagOfPost(int postID) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT TAG FROM TAGS WHERE POSTID=?";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postID);
			
			rs = pstmt.executeQuery();
			StringBuilder result = new StringBuilder();
			while(rs.next())
			{
				result.append(rs.getString(1) + ' ');
			}
			System.out.println(result);
			return result.toString();
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
	
	public void setTagOfPost(int postID, String tags) throws Exception
	{
		String[] tagsArr = tags.split(",");
		int tagsCnt = tagsArr.length;
		for(int i=0; i<tagsCnt; i++)
		{
			tagsArr[i] = tagsArr[i].trim();
			if(!tagsArr[i].startsWith("#"))
				tagsArr[i] = '#' + tagsArr[i];
		}
		setTagOfPost(postID, tagsArr);
	}
	public void setTagOfPost(int postID, String[] tags) throws Exception
	{
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO TAGS VALUES(?, ?)";
		
		try
		{
			for(String tag : tags)
			{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, postID);
				pstmt.setString(2, tag);
				int result = pstmt.executeUpdate();
				if(result != 1)
					throw new Exception();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("태그를 등록하던 중 오류가 발생하였습니다.");
		}
	}
}
