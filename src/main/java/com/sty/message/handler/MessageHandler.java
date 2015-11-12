package com.sty.message.handler;

import com.sty.message.request.RequestMessage;
import com.sty.message.response.ResponseMessage;

public interface MessageHandler {
	ResponseMessage handle(RequestMessage rqm);
}
