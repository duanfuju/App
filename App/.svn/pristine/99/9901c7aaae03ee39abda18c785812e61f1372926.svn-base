package com.junl.frame.tools.net;

import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 
 * @author LEON
 * @date 2015年12月23日 上午10:30:35
 * @description 
 *     TODO
 */
public class WebUtils {
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年3月22日 下午4:23:03
	 * @description 
	 *     获取request
	 * @return
	 *
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
			      .getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年3月22日 下午4:23:23
	 * @description 
	 *     获取session
	 * @return
	 *
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午10:30:38
	 * @description 
	 *     根据名称获取session的attribute
	 * @param request
	 * @param name
	 * @return
	 *
	 */
	public static Object getSessionAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		return (session != null ? session.getAttribute(name) : null);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午10:35:16
	 * @description 
	 *     写入值到session attribute
	 * @param request
	 * @param name
	 * @param value
	 *
	 */
	public static void setSessionAttribute(HttpServletRequest request, String name, Object value) {
		if (value != null) {
			request.getSession().setAttribute(name, value);
		} else {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.removeAttribute(name);
			}
		}
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午10:40:29
	 * @description 
	 *     获取cookie
	 * @param request
	 * @param name
	 * @return
	 *
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月23日 上午10:44:48
	 * @description 
	 *     返回给定路径在网络应用程序中的实际路径
	 * @param servletContext
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 *
	 */
	public static String getRealPath(ServletContext servletContext, String path) throws FileNotFoundException {
		// Interpret location as relative to the web application root directory.
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		String realPath = servletContext.getRealPath(path);
		if (realPath == null) {
			throw new FileNotFoundException(
					"ServletContext resource [" + path + "] cannot be resolved to absolute file path - " +
					"web application archive not expanded?");
		}
		return realPath;
	}
	
	/**
	 * 
	 * @method getIpAddress
	 * @author tongzhenghan
	 * @date 2016年5月31日 上午11:52:53
	 * @description
	 *		获取客户端ip地址
	 *
	 * @return
	 */
	public static String getIpAddress(){
		String ip = getRequest().getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip =  getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip =  getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip =  getRequest().getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip =  getRequest().getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip =  getRequest().getRemoteAddr();
		}
		return ip;
	}
}
