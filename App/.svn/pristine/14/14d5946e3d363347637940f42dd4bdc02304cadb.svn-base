package com.junl.frame.tools;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * @author xus
 * @date 2016年6月22日 上午11:15:38
 * @description 
 *		邮件工具类
 */
public class EmailUtils {
	
	final Logger logger = Logger.getLogger(EmailUtils.class);
	
	private JavaMailSenderImpl sender;
	private MimeMessage mailMessage;
	private Configuration configuration;
	private String username;
	
	/**
	 * 
	 * @param host 邮箱服务器
	 * @param username 用户名
	 * @param password 密码
	 */
	@SuppressWarnings("deprecation")
	public EmailUtils (String host, String username, String password) {
		this.username = username;
		sender = new JavaMailSenderImpl();
		sender.setHost(host);
		sender.setUsername(username);
		sender.setPassword(password);
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		sender.setJavaMailProperties(prop);
		
		mailMessage = sender.createMimeMessage();
		
		configuration = new Configuration();
		configuration.setClassForTemplateLoading(this.getClass(), "templates");
	}

	/**
	 * 
	 * @author xus
	 * @date 2016年6月22日 上午11:53:36
	 * @description 
	 *		发送邮件
	 * @param recipients 收件邮箱
	 * @param template 模版
	 * @param context 内容
	 *
	 */
	public void send(String recipients, String template, String context) {
		
		MimeMessageHelper messageHelper;
		try {
			messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			// 设置收件人
			messageHelper.setTo(recipients);
			// 寄件人
			messageHelper.setFrom(this.username);
			// 邮箱标题
			messageHelper.setSubject("jdoc管理系统密码找回！");
			
			// 获取模版，填入参数
			Template t = configuration.getTemplate(template);
			Writer out = new StringWriter();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("random", context);
			t.process(map, out);
			messageHelper.setText(out.toString(), true);
			out.close();
			// 发送
			sender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
