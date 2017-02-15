import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

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
	@Ignore
	public void testMessageCall() {
		Receipt receipt = Messanger.message("message", "subject").from("15885668", "vodshop").to("01087685300", "gaeul")
				.send();
	}

	@Test
	public void sendTimeTest() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = format.parse("2017-02-15 16:02:45");
		
		System.out.println(format.format(d1));
		System.out.println(format.toPattern());

		Date d2 = new Date();
		d2 = format.parse("2017-02-15 16:02:45");
		System.out.println(d1.compareTo(d2));

	}
}