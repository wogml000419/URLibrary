/**
 * 
 */
package org.hjh.vo;

import com.google.gson.JsonObject;

/**
 * <pre>
 * org.hjh.vo
 *   |_ PostVO
 * 
 * 1. 개요: 
 * 2. 작성일: 2017. 11. 28.
 * </pre> 
 *
 * @author : user
 * @version : 1.0
 */
public class PostVO {
	
	private int postID;
	private String userEmail;
	private String url;
	private String surl;
	private String title;
	private String userText;
	private int shareWith;
	private String tags;

	public PostVO() {}
	public PostVO(int postID, String userEmail, String url, String surl, String title, String userText, int shareWith, String tags) 
	{
		this.postID = postID;
		this.userEmail = userEmail;
		this.title = title;
		this.url = url;
		this.surl = surl;
		this.userText = userText;
		this.shareWith = shareWith;
		this.tags = tags;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSurl() {
		return surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}
	
	public int getShareWith() {
		return shareWith;
	}

	public void setShareWith(int shareWith) {
		this.shareWith = shareWith;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() 
	{
		return "PostVO [postID=" + postID + ", userEmail=" + userEmail + ", url=" + url + ", surl=" + surl
				+ ", title=" + title + ", userText="
				+ userText + ", shareWith=" + shareWith + ", tags=" + tags + "]";
	}
	
	public JsonObject toJson()
	{
		JsonObject result = new JsonObject();
		
		result.addProperty("postID", postID);
		result.addProperty("userEmail", userEmail);
		result.addProperty("url", url);
		result.addProperty("surl", surl);
		result.addProperty("title", title);
		result.addProperty("userText", userText);
		result.addProperty("tags", tags);
		
		return result;
	}
}
