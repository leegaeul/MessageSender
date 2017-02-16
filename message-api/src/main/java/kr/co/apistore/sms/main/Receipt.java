/**
 * 
 */
package kr.co.apistore.sms.main;

/**
 * @author Gaeul Lee
 *
 */
public class Receipt {
	private String	resultMessage;
	private String	resultCode;
	private String	cmid;

	/**
	 * @return the resultMessage
	 */
	public String getResultMessage() {
		return resultMessage;
	}

	/**
	 * @param resultMessage the resultMessage to set
	 */
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the cmid
	 */
	public String getCmid() {
		return cmid;
	}

	/**
	 * @param cmid the cmid to set
	 */
	public void setCmid(String cmid) {
		this.cmid = cmid;
	}

}
