package com.junl.frame.core.exception;

import java.io.PrintStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 
 * @author LEON
 * @date 2016年2月27日 下午4:57:34
 * @description 
 *     系统统一的异常拦截器
 */
public class ExceptionAspect {

	private static Logger logger = Logger.getLogger(ExceptionAspect.class);
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年2月29日 上午10:13:18
	 * @description 
	 *     拦截系统所有类执行的异常状况
	 * @param point
	 * @return
	 * @throws Throwable
	 *
	 */
	@SuppressWarnings("rawtypes")
	public Object afterThrowing(ProceedingJoinPoint point) throws Throwable {
		
		Object result = null;
		String className = "";
		String methodName = "";
		try {
			StopWatch sw = new StopWatch();
			Class c = point.getTarget().getClass();
			className = c.getSimpleName();
	        methodName = point.getSignature().getName();
	        sw.start();
        	result = point.proceed();
            sw.stop();
		} catch (Exception e) {
			logger.error("系统执行" + className + "类中" + methodName + "时出现异常");
			ByteArrayOutputStream bot = new ByteArrayOutputStream();  
			e.printStackTrace(new PrintStream(bot));  
			logger.error(bot.toString());
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}

}
