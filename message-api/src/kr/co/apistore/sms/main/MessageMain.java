/**
 * 
 */
package kr.co.apistore.sms.main;

import kr.co.apistore.sms.messanger.Messanger;

/**
 * @author Gaeul Lee
 *
 */
public class MessageMain {

	public static void main (String[] args){
		Messanger.message("message","subject").from("01087685300", "gaeul").to("01087685300", "gaeul").send();
	}
}
