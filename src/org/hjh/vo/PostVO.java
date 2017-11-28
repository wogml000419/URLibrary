/**
 * 
 */
package org.hjh.vo;

import java.util.Arrays;

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
	private String urlThumbnail;
	private String urlText;
	private String title;
	private String userText;
	private String[] tags;

	public PostVO() {}
	public PostVO(int postID, String userEmail, String url, String surl, String urlThumbnail, 
			String urlText, String title, String userText, String[] tags) 
	{
		this.postID = postID;
		this.userEmail = userEmail;
		this.title = title;
		this.url = url;
		this.surl = surl;
		this.urlThumbnail = urlThumbnail; //postID를 사용해 서버에 저장
		this.urlText = urlText;
		this.userText = userText;
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

	public String getUrlThumbnail() {
		return urlThumbnail;
	}

	public void setUrlThumbnail(String urlThumbnail) {
		this.urlThumbnail = urlThumbnail;
	}

	public String getUrlText() {
		return urlText;
	}

	public void setUrlText(String urlText) {
		this.urlText = urlText;
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

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() 
	{
		return "PostVO [postID=" + postID + ", userEmail=" + userEmail + ", url=" + url + ", surl=" + surl
				+ ", urlTumbnail=" + urlThumbnail + ", urlText=" + urlText + ", title=" + title + ", userText="
				+ userText + ", tags=" + Arrays.toString(tags) + "]";
	}
	
	public JsonObject toJson()
	{
		JsonObject result = new JsonObject();
		
		result.addProperty("postID", postID);
		result.addProperty("userEmail", userEmail);
		result.addProperty("url", url);
		result.addProperty("surl", surl);
		result.addProperty("urlThumbnail", urlThumbnail);
		result.addProperty("urlText", urlText);
		result.addProperty("title", title);
		result.addProperty("userText", userText);
		result.addProperty("tags", Arrays.toString(tags));
		
		return result;
	}
}
