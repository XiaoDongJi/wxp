package com.sty.message.response;

import com.sty.message.response.media.Video;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 视频消息，包括短视频
 * @author JIXD
 *
 */
@XStreamAlias("xml")
public class ResponseVideoMessage extends ResponseMessage{
	@XStreamAlias("Video")
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	
	
}
