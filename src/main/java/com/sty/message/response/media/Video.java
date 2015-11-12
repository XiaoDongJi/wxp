package com.sty.message.response.media;

public class Video {
	private String MediaId;
	private String Title;
	private String Description;
	
	public Video() {
		super();
	}
	public Video(String mediaId, String title, String description) {
		super();
		MediaId = mediaId;
		Title = title;
		Description = description;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
