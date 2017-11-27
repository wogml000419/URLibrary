/**
 * 
 */
package org.hjh.service;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * <pre>
 * org.hjh.service
 *   |_ AbstractService
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 17.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public abstract class AbstractService {
	
	public static Connection getConnection() throws Exception
	{
		try
		{
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
			return dataSource.getConnection();
		}
		catch(Exception e)
		{
			throw new Exception("DB 연결 실패");
		}
	}

}
