package com.sty.message.response;

import com.sty.message.response.media.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 语音消息
 * @author JIXD
 *
 */
@XStreamAlias("xml")
public class ResponseVoiceMessage extends ResponseMessage{
	
	@XStreamAlias("Voice")
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	
	
}
