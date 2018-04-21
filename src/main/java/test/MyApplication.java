package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyApplication {
	static Logger logger = LogManager.getLogger(MyApplication.class.getName());

	public boolean doIt() {
		logger.trace("MyApplication.doIt begin");// Log entry to a method
		logger.error("Did it again!"); // Log a message object with the ERROR level
		logger.trace("MyApplication.doIt end"); // Log exit from a method
		return false;
	}

}
