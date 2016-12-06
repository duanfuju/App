package com.junl.frame.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.junl.frame.tools.string.StringUtils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 * 
 * @author LEON
 * @date 2015年12月25日 上午10:06:31
 * @description 
 *     压缩与解压缩工具类
 */
public class ZipUtils {

	public static final Log logger = LogFactory.getLog(ZipUtils.class);
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月25日 上午10:32:03
	 * @description 
	 *     全部解压缩到指定目录
	 * @param zipPath 文件路径
	 * @param password 密码  没有则写空
	 * @param dest 压缩目录
	 *
	 */
	public static void unzip(String zipPath, String password, String dest) throws ZipException {
		
		try {
			ZipFile zipFile = new ZipFile(zipPath);
			zipFile.setFileNameCharset("GBK");
			if (!zipFile.isValidZipFile()) {
				throw new ZipException("压缩文件不合法,可能被损坏.");
			}
			File destDir = new File(dest);
			if (destDir.isDirectory() && !destDir.exists()) {    
	            destDir.mkdir();    
	        }
			if (zipFile.isEncrypted()) {    
				zipFile.setPassword(password.toCharArray());  // 设置密码    
	        }
			zipFile.extractAll(dest);
		} catch (ZipException e) {
			logger.error("未找到压缩文件,请检测文件:" + zipPath + "是否存在");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月25日 上午11:41:31
	 * @description 
	 *     压缩文件夹
	 * @param folderPath 文件夹路径
	 * @param dest 压缩目标路径
	 * @param password 密码 没有密码则空
	 *
	 */
	public static void zipFolder(String folderPath, String dest, String password) {
		
		try {
			ZipFile zipFile = new ZipFile(dest);
			zipFile.setFileNameCharset("GBK");
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			if(!StringUtils.isEmpty(password)) {		// 如果传入密码则设置密码
				parameters.setEncryptFiles(true);
				parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
				parameters.setPassword(password);
			}
			zipFile.addFolder(folderPath, parameters);
		} catch (ZipException e) {
			logger.error("文件夹压缩异常");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月25日 上午11:44:02
	 * @description 
	 *     压缩文件，支持多文件
	 * @param files 文件集合
	 * @param dest 压缩目标地址
	 * @param password 密码
	 *
	 */
	public static void zipFiles(ArrayList<File> files, String dest, String password) {
		
		// 屁都没有直接拜拜
		if(files == null || files.size() <= 0) {
			return;
		}
		
		try {
			ZipFile zipFile = new ZipFile(dest);
			ZipParameters parameters = new ZipParameters();  
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);  
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			if(!StringUtils.isEmpty(password)) {		// 如果传入密码则设置密码
				parameters.setEncryptFiles(true);
				parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
				parameters.setPassword(password);
			}
			zipFile.addFiles(files, parameters);
		} catch (ZipException e) {
			logger.error("文件压缩异常");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月25日 下午12:52:49
	 * @description 
	 *     添加指定文件到zip中，如果存在密码，参数中填写密码
	 * @param zipPath zip文件路径
	 * @param filePath 文件地址
	 * @param password 密码
	 *
	 */
	public static void addFileInZip(String zipPath, String filePath, String password) {
		
		try {
			File file = new File(filePath);
			String fileName = file.getName();
			InputStream stream = new FileInputStream(file);
			
			ZipFile zipFile = new ZipFile(zipPath);
			if (zipFile.isEncrypted()) {    
				zipFile.setPassword(password.toCharArray());  // 设置密码    
	        }
			
			ZipParameters parameters = new ZipParameters();  
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);  
			parameters.setFileNameInZip(fileName);  
			parameters.setSourceExternalStream(true);
			zipFile.addStream(stream, parameters);
			stream.close();
		} catch (ZipException e) {
			logger.error("未找到压缩文件,请检测文件:" + zipPath + "是否存在");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
