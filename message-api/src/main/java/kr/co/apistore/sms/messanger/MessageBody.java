/**
 * 
 */
package kr.co.apistore.sms.messanger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;

import kr.co.apistore.sms.constants.MessageConstants;
import kr.co.apistore.sms.main.Receipt;
import kr.co.apistore.sms.message.Message;
import kr.co.apistore.sms.sender.MessageSender;

/**
 * @author Gaeul Lee
 *
 */
public class MessageBody {
	private Message					m;
	private HashMap<String, String>	receivers;
	private SimpleDateFormat		format;

	public MessageBody() {
		m = new Message();
		receivers = new HashMap<>();
		format = new SimpleDateFormat(MessageConstants.TIME_FORMAT);
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

	/**
	 * 
	 * @throws ParseException
	 * @Method when
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 15.
	 */
	public MessageBody when(String sendTime) {
		try {
			/*
			 * yyyy-MM-dd HH:mm:ss 형태에 맞는지 확인.
			 */

			Date date = format.parse(sendTime);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		m.setSendTime(sendTime);
		return this;
	}

	/**
	 * 
	 * 
	 * @Method when
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 15.
	 */
	public MessageBody when(Date date) {
		/*
		 * yyyy-MM-dd HH:mm:ss 형태로 변환
		 */
		String sendTime = format.format(date);
		m.setSendTime(sendTime);
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
		/*
		 * 보내기 전에 메세지 파라미터 점검
		 */

		/* 전송예약시간 */
		if (m.getSendTime() == null) m.setSendTime("");

		/* 발신자번호 유효성 */
		if (m.getSenderPhone() == null || m.getSenderPhone().isEmpty()) throw new NullPointerException();

		/* 수신자번호 존재유무, 없으면 null exception */
		int totalReceivers = receivers.size();
		if (totalReceivers > 0) m.setDestPhone(getDestPhone());
		else throw new NullPointerException();

		return inssuRecept(MessageSender.send(m));
	}

	/**
	 * 
	 * @Method beforeSend
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 16.
	 */

	/**
	 * 수신번호 별 전송 영수증 발부
	 * 
	 * @Method inssuRecept
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 13.
	 */
	private Receipt inssuRecept(HttpResponse res) {
		Receipt receipt = new Receipt();
		JSONObject j = new JSONObject(res.getBody().toString());
		receipt.setResultCode((String) j.get("result_code"));
		receipt.setResultMessage((String) j.get("result_message"));
		receipt.setCmid((String) j.get("cmid"));
		return receipt;
	}

	public Receipt report(Receipt receipt) {
		// cmid는 1개씩 보내야 함
		JSONObject jResult = new JSONObject(MessageSender.report(receipt.getCmid()).getBody().toString());
		System.out.println(MessageSender.report(receipt.getCmid()).getBody().toString());
		// dest_phone, call_status, report_time, umid, dest_name
		return receipt;
	}

}
