/**
 * 
 */
package kr.co.apistore.sms.messanger;

import java.util.HashMap;

import kr.co.apistore.sms.message.Message;

/**
 * @author Gaeul Lee
 *
 */
public class Messanger {

	public static MessageBody message(String content, String subject) {
		MessageBody body = new MessageBody();
		body.makeMessage(content, subject);
		return body;
	}

}