package com.wolverine.util.exception;

public class CheckException extends RuntimeException {

	private String errMsg;
	static CheckException checkExcep = null ;
	
	public synchronized static CheckException newCheckException(String errMsg){
		if ( null == checkExcep ) checkExcep = new CheckException();
		checkExcep.setErrMsg(errMsg);
		return checkExcep ;
	}
	
	public CheckException() {
		super();
	}
	
	public CheckException(String errMsg) {
		super();
		this.errMsg = errMsg;
	}
	
	public CheckException(Throwable cause) {
		super(cause);
	}
	
	public CheckException(String errMsg, Throwable cause) {
		super(cause);
		this.errMsg = errMsg;
	}
	
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String toString() {
        String s = getClass().getName();
        String message = getErrMsg();
        return (message != null) ? (s + ": " + message) : s;
    }
	
}
