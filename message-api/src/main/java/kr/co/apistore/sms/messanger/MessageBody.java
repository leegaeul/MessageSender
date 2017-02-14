/**
 * 
 */
package kr.co.apistore.sms.messanger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import kr.co.apistore.sms.constants.MessageConstants;
import kr.co.apistore.sms.main.Receipt;
import kr.co.apistore.sms.message.Message;

/**
 * @author Gaeul Lee
 *
 */
public class MessageBody {
	private Message					m;
	private HashMap<String, String>	receivers;

	public MessageBody() {
		m = new Message();
		receivers = new HashMap<>();
	}

	/**
	 * 
	 * @Method makeMessage
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 8.
	 */
	public MessageBody makeMessage(String content, String subject) {
		m.setContent(content);
		m.setSubject(subject);
		return this;
	}

	/**
	 * 
	 * 
	 * @Method from
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 13.
	 */
	public MessageBody from(String phone, String name) {
		m.setSenderPhone(phone);
		m.setSenderName(name);
		return this;
	}

	/**
	 * 
	 * 
	 * @Method to
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 13.
	 */
	public MessageBody to(String phone, String name) {
		receivers.put(phone, name);
		return this;
	}

	private String getDestPhone() {
		String destPhone = "";
		Set key = receivers.keySet();
		for (Iterator iterator = key.iterator(); iterator.hasNext();) {
			destPhone += (String) iterator.next();
			if (iterator.hasNext()) destPhone += ",";
		}
		return destPhone;
	}

	public Receipt send() {
		// url -> http://api.openapi.io/ppurio/version/message/{sms/lms/mms}/id;
		String url = "http://api.openapi.io/ppurio/1/message/lms/"+ MessageConstants.USER_ID;
		HttpResponse res = null;
		try {
			res = (HttpResponse) Unirest.post(url).header("x-waple-authorization", MessageConstants.KEY) // 1.key
					.header("Content-Type", MessageConstants.CONTENT_TYPE) // 2.content-type
					.field("send_time", m.getSendTime()) // 3.send_time
					.field("dest_phone", getDestPhone()) // 4.dest_phone
					.field("send_phone", m.getSenderPhone())// 6.send_phone
					.field("msg_body", m.getContent())// 8.body
					.field("subject", m.getSubject())// 9.subject
					.asJson();
		}
		catch (UnirestException e) {
			e.printStackTrace();
		}
		return inssuRecept(res);
	}

	/**
	 * 
	 * @Method inssuRecept
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 13.
	 */
	private Receipt inssuRecept(HttpResponse res) {
		Receipt receipt = new Receipt();
		/*
		 * 수신번호 별 전송 영수증 발부
		 */
		return receipt;
	}

	public void report(Receipt receipt) {
		String cmid = receipt.getCmid();
		// url -> http://api.openapi.io/ppurio/version/message/report/id;
		String url = " http://api.openapi.io/ppurio/version/message/report/id";
		try {
			HttpResponse res = Unirest.get(url).header("x-waple-authorization", MessageConstants.KEY)
					.queryString("cmid", cmid).asJson();
		}
		catch (UnirestException e) {
			e.printStackTrace();
		}
	}
}
