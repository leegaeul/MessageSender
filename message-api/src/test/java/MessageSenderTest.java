import org.junit.Ignore;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import junit.framework.Assert;
import kr.co.apistore.sms.constants.MessageConstants;
import kr.co.apistore.sms.main.Receipt;
import kr.co.apistore.sms.messanger.Messanger;

/**
 * 
 */

/**
 * @author Gaeul Lee
 *
 */
public class MessageSenderTest {

	@Test
	public void testMessageCall() {
		Receipt receipt = Messanger.message("message", "subject").from("15885668", "vodshop")
				.to("01087685300", "gaeul").send();
	}

}
