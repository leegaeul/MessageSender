/**
 * 
 */
package kr.co.apistore.sms.messanger;

import java.util.HashMap;
import java.util.List;

import kr.co.apistore.sms.message.Message;

/**
 * @author Gaeul Lee
 *
 */
public class MessageBody {
	private Message					m;
	private HashMap<String, String>	receivers;

	/**
	 * 
	 * @Method makeMessage
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 8.
	 */
	public MessageBody makeMessage(String content, String subject) {
		m = new Message();
		receivers = new HashMap<>();
		m.setContent(content);
		m.setSubject(subject);
		return this;
	}

	public MessageBody from(String phone, String name) {
		m.setSenderPhone(phone);
		m.setSenderName(name);
		return this;
	}

	public MessageBody to(String phone, String name) {
		receivers.put(phone, name);
		return this;
	}
	public void send(){
	}
}
