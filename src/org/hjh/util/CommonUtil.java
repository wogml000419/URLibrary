/**
 * 
 */
package org.hjh.util;

/**
 * <pre>
 * org.hjh.util
 *   |_ CommonUtil
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 17.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class CommonUtil {
	public static boolean isEmpty(String s) {
		if(s == null || s.trim().equals(""))
			return true;
		return false;
	}
}
