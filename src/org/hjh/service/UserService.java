/**
 * 
 */
package org.hjh.service;

import java.sql.Connection;
import java.util.List;

import org.hjh.dao.FollowsDao;
import org.hjh.dao.UserDao;
import org.hjh.vo.UserVO;

/**
 * <pre>
 * org.hjh.service
 *   |_ UserService
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 17.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class UserService extends AbstractService 
{
	public static UserVO login(UserVO vo) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			UserVO result = dao.searchUser(vo);
			if(result == null)
				throw new Exception("아이디 또는 비밀번호가 잘못되었습니다.");
			return result;
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public static void signup(UserVO vo) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			
			if(dao.searchUserById(vo) != null)
				throw new Exception("이미 사용중인 아이디입니다.");
			
			dao.insertUser(vo);
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public static List<UserVO> searchUserList() throws Exception 
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			
			return dao.searchAllUsers();
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public static UserVO searchUser(String id) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			
			return dao.searchUserById(id);
		}
		finally
		{
			if(conn != null) conn.close();
		}	
	}
	
	public static UserVO[] getFollowsOf(String id) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			FollowsDao fdao = new FollowsDao(conn);
			
			List<String> follows = fdao.getFollows(id);
			int size = follows.size();
			UserVO[] result = new UserVO[size];
			
			for(int i=0; i<size; i++)
				result[i] = dao.searchUserById(follows.get(i));
			return result;
		}
		finally
		{
			if(conn != null) conn.close();
		}	
	}
}
