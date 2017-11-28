/**
 * 
 */
package org.hjh.vo;

import com.google.gson.JsonObject;

/**
 * <pre>
 * org.hjh.vo
 *   |_ UserVO
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 17.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class UserVO 
{
	private String id;
	private String pwd;
	private String nickname;

	public UserVO() {} 
	public UserVO(String id, String pwd, String nickname)
	{
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() 
	{
		return "UserVO [id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + "]";
	}

	public JsonObject toJson()
	{
		JsonObject json = new JsonObject();
		
		json.addProperty("id", id);
		json.addProperty("nickname", nickname);
		
		return json;
	}
	
}
