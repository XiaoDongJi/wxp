package com.sty.message.response;

import com.sty.message.response.media.Music;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 音乐消息
 * @author JIXD
 *
 */
@XStreamAlias("xml")
public class ResponseMusicMessage extends ResponseMessage{
	@XStreamAlias("Music")
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
}
