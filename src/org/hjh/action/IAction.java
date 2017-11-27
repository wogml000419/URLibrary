/**
 * 
 */
package org.hjh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * org.hjh.action
 *   |_ IAction
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 17.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public interface IAction {
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
