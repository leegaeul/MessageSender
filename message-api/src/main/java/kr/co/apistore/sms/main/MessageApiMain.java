/**
 * 
 */
package kr.co.apistore.sms.main;

import kr.co.apistore.sms.messanger.Messanger;

/**
 * @author Gaeul Lee
 *
 */
public class MessageApiMain {

	/**
	 * 
	 * @Method main
	 * @Author Gaeul Lee
	 * @Date 2017. 2. 15.
	 */
	public static void main(String[] args) {
		// Receipt receipt = Messanger.message("message", "subject").from("15885668", "gaeul").to("01087685300", "gaeul").when("2017-02-16 18:03:00").send();
		Receipt receipt = Messanger
				.message("message", "subject")
				.from("15885668", "gaeul")
				.to("01087685300", "gaeul")
				.send();
		Messanger.report(receipt);
	}

}
