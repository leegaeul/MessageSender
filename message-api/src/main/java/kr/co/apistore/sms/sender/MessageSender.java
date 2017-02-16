/**
 * 
 */
package kr.co.apistore.sms.sender;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import kr.co.apistore.sms.constants.MessageConstants;
import kr.co.apistore.sms.message.Message;

/**
 * @author Gaeul Lee
 *
 */
public abstract class MessageSender {
	public static HttpResponse send(Message m) {
		// url -> http://api.openapi.io/ppurio/version/message/{sms/lms/mms}/id;
		String url = "http://api.openapi.io/ppurio/1/message/lms/" + MessageConstants.USER_ID;
		HttpResponse res = null;
		try {
			res = (HttpResponse) Unirest.post(url).header("x-waple-authorization", MessageConstants.KEY) // 1.key
					.header("Content-Type", MessageConstants.CONTENT_TYPE) // 2.content-type
					.field("send_time", m.getSendTime()) // 3.send_time
					.field("dest_phone", m.getDestPhone()) // 4.dest_phone
					.field("send_phone", m.getSenderPhone())// 6.send_phone
					.field("msg_body", m.getContent())// 8.body
					.field("subject", m.getSubject())// 9.subject
					.asJson();
		}
		catch (UnirestException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static HttpResponse report(String cmid) {
		// url -> http://api.openapi.io/ppurio/version/message/report/id;
		String url = " http://api.openapi.io/ppurio/1/message/report/" + MessageConstants.USER_ID;;
		HttpResponse res = null;
		try {
			res = Unirest.get(url).header("x-waple-authorization", MessageConstants.KEY).queryString("cmid", cmid)
					.asJson();
		}
		catch (UnirestException e) {
			e.printStackTrace();
		}
		return res;
	}
}
