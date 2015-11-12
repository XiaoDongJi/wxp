package com.sty.utils;

import java.util.Map;
import org.apache.log4j.Logger;
import com.sty.common.aes.AesException;
import com.sty.common.aes.WXBizMsgCrypt;

public class WxMsgEncryptUtil {
	private static Logger logger = Logger.getLogger(WxMsgEncryptUtil.class);

	// 1：当前aesKey -1：上一个aesKey
	private static int aesKeyIndex = 1;
	// 使用的aesKey
	private static String encodingAesKey = "";
	// 解密出错次数，共两次:使用当前aesKey、使用上一个aesKey一次。超过就不执行解密了
	private static int encodingErrNum = 0;
	//时间戳
	private static String timestamp = "";
	//随机字符串
	private static String nonce = "";

	/**
	 * 解密处理
	 * 
	 * @param params
	 * @param reqStr
	 * @return
	 * @throws AesException
	 */
	public static synchronized String decryptMsg(Map<String,String[]> map,String msg) {
		if (null != msg) {
			timestamp = map.get("timestamp")[0];
			nonce = map.get("nonce")[0];
			try {
				if (aesKeyIndex == 1) {
					logger.info(aesKeyIndex + "---使用当前AesKey---");
					encodingAesKey = ConfigUtil.CurrEncodingAesKey;
				} else if (aesKeyIndex == -1) {
					logger.info(aesKeyIndex + "---使用上一个AesKey---");
					encodingAesKey = ConfigUtil.PrevEncodingAesKey;
				}
				WXBizMsgCrypt pc = new WXBizMsgCrypt(ConfigUtil.token, encodingAesKey, ConfigUtil.AppId);
				String result2 = pc.decryptMsg(map.get("msg_signature")[0], timestamp, nonce, msg);
				encodingErrNum = 0;
				aesKeyIndex = 1;// 当前解密成功，下次解密时取当前AesKey
				return result2;
			} catch (Exception e) {
				encodingErrNum = encodingErrNum + 1;//
				logger.error(encodingErrNum + "-->" + e.getMessage());
				e.printStackTrace();
				if (encodingErrNum < 2) {
					// e.getCode()==-40001&&
					aesKeyIndex = -1;// 使用上一个AesKey
					decryptMsg(map,msg);// 重新解密
					logger.error("使用上一个AesKey重新解密");
				} else if (encodingErrNum >= 2) {
					encodingErrNum = 0;
					aesKeyIndex = 1;// 下次解密时取当前AesKey
					encodingAesKey = ConfigUtil.CurrEncodingAesKey;
					logger.error("使用当前AesKey和上次的AesKey都失效，下次解密时取当前AesKey");
				}
			}
		}
		return "";
	}

	/**
	 * 加密处理
	 * 
	 * @param params
	 * @param resStr
	 * @return
	 */
	public static String encryptResMsg(String repMsg) {
		if (null != repMsg) {
			try {
				WXBizMsgCrypt pc = new WXBizMsgCrypt(ConfigUtil.token, encodingAesKey, ConfigUtil.AppId);
				String jiami = pc.encryptMsg(repMsg, timestamp, nonce);
				return jiami;
			} catch (AesException e) {
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}

}
