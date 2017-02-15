/**
 * 
 */
package kr.co.apistore.sms.message;

import java.util.Date;

/**
 * @author Gaeul Lee
 *
 */
public class Message {
	private String	content;
	private String	subject;
	private String	senderPhone;
	private String	senderName;
	private String	sendTime;
	private String	destPhone;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the senderPhone
	 */
	public String getSenderPhone() {
		return senderPhone;
	}

	/**
	 * @param senderPhone the senderPhone to set
	 */
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the sendTime
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * @return the destPhone
	 */
	public String getDestPhone() {
		return destPhone;
	}

	/**
	 * @param destPhone the destPhone to set
	 */
	public void setDestPhone(String destPhone) {
		this.destPhone = destPhone;
	}

}
