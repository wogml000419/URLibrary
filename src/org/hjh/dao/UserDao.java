/**
 * 
 */
package org.hjh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hjh.vo.UserVO;

/**
 * <pre>
 * org.hjh.dao
 *   |_ UserDao
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 17.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class UserDao {
	
	private Connection conn = null;
	
	public UserDao(Connection conn)
	{
		this.conn = conn;
	}
	
	public UserVO searchUser(UserVO vo) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT * FROM USER WHERE EMAIL=? AND PWD=?";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			UserVO result = null;
			while(rs.next())
			{
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setNickname(rs.getString(3));
			}
			System.out.println(result);
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("사용자 정보를 조회하는 중 오류가 발생하였습니다.");
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}

	public UserVO searchUserById(UserVO vo) throws Exception
	{
		return searchUserById(vo.getId());
	}
	public UserVO searchUserById(String id) throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT * FROM USER WHERE EMAIL=?";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			UserVO result = null;
			while(rs.next())
			{
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setNickname(rs.getString(3));
			}
			System.out.println(result);
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("사용자 정보를 조회하는 중 오류가 발생하였습니다.");
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public void insertUser(UserVO vo) throws Exception
	{
		PreparedStatement pstmt = null;
				
		String sql = "INSERT INTO USER VALUES(?, ?, ?)";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNickname());
			
			int cnt = pstmt.executeUpdate();
			if(cnt != 1)
				throw new Exception("사용자 정보를 등록하는 중 오류가 발생하였습니다.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("사용자 정보를 등록하는 중 오류가 발생하였습니다.");
		}
		finally
		{
			if(pstmt != null) pstmt.close();
		}
	}
	
	public List<UserVO> searchAllUsers() throws Exception
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT EMAIL, NICKNAME FROM USER";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			List<UserVO> result = new ArrayList<>();
			while(rs.next())
			{
				result.add(new UserVO(rs.getString(1), null, rs.getString(2)));
			}
			System.out.println(result);
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("사용자 정보를 조회하는 중 오류가 발생하였습니다.");
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
}
