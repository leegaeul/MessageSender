/**
 * 
 */
package kr.co.apistore.sms.messanger;

import kr.co.apistore.sms.main.Receipt;

/**
 * @author Gaeul Lee
 *
 */
public class Messanger {

	private static MessageBody newMessageBody() {

		MessageBody body = new MessageBody();
		return body;
	}

	public static MessageBody message(String content, String subject) {
		return newMessageBody().makeMessage(content, subject);

	}

	/**
	 * 
	 * @Method report
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 16.
	 */
	public static Receipt report(Receipt receipt) {
		return newMessageBody().report(receipt);
	}

}
