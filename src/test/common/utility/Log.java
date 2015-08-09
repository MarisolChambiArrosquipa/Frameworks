package utility;

import org.apache.log4j.Logger;

public class Log {
	private static Logger log= Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String testcase){
		log.info("***************************");
		log.info("***********"+testcase+"***********");
	}

	
	public static void endTestCase(String testcase){
		log.info("**********************************");
		log.info("********************"+testcase+"*************");
		log.info("*******end test case***************");
	}
	public static void info(String message) {
		// TODO Auto-generated method stub
		log.info(message);
		
	}
	
	public static void warn(String message){
		log.warn(message);
	}
	public static void fail(String message){
		log.fatal(message);
	}
	public static void error(String message){
		log.error(message);
	}
	public static void debug(String message){
		log.debug(message);
	}
}
