package com.junl.frame.tools.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.io.FileUtils;

/**
 * 
 * @Class FileUtils
 * @author LEON
 * @Date 2014-3-21 下午4:49:18
 * @Description
 * 		操作文件工具类
 *
 */
public class FileUtil {

	public static final Log logger = LogFactory.getLog(FileUtils.class);
	
	/**
	 * 
	 * @Method createFolder
	 * @author LEON
	 * @Date 2014-3-21 下午4:51:06
	 * @Description
	 * 		创建单个文件夹
	 * 			如果文件夹存在，则返回true
	 *
	 * @param path 创建路径
	 * @return boolean 
	 */
	public static boolean createFolder(String path) {
		File file = new File(path);
		if(!file.exists()) {
			return file.mkdir();
		} else {
			return true;
		}
	}
	
	/**
	 * 
	 * @Method createFolder
	 * @author LEON
	 * @Date 2014-3-21 下午4:51:06
	 * @Description
	 * 		创建单个文件夹
	 *
	 * @param path 创建路径
	 * @param destroy 如果存在是否销毁 true：销毁
	 * @return boolean 
	 */
	public static boolean createFolder(String path, boolean destroy) {
		File file = new File(path);
		boolean result = false;
		if(!file.exists()) {
			result = file.mkdir();
		} else {
			if(destroy) {
				try {
					FileUtils.deleteDirectory(file);
					file.mkdir();
					result = true;
				} catch (IOException e) {
					e.printStackTrace();
					result = false;
				}
			} else {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @Method createFolders
	 * @author LEON
	 * @Date 2014-3-21 下午5:04:14
	 * @Description
	 * 		创建多层文件夹
	 *			如果文件夹存在，不创建 返回true
	 * @param path
	 * @return boolean 
	 */
	public static boolean createFolders(String path) {
		File file = new File(path);
		if(!file.exists()) {
			return file.mkdirs();
		} else {
			return true;
		}
	}
	
	/**
	 * 
	 * @Method copyInputStreamToFile
	 * @author LEON
	 * @Date 2014-3-21 下午5:06:17
	 * @Description
	 * 		读取文件流并复制到指定位置
	 *			如果文件存在，则不进行覆盖，return false
	 * @param inputStream
	 * @param desFile
	 * @return
	 */
	public static boolean copyInputStreamToFile(InputStream inputStream, File desFile) {
		try {
			if(desFile.exists()) {
				return false;
			} else {
				FileUtils.copyInputStreamToFile(inputStream, desFile);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("InputStream 复制出错");
			return false;
		}
	}
	
	/**
	 * 
	 * @Method copyInputStreamToFile
	 * @author LEON
	 * @Date 2014-3-21 下午5:10:10
	 * @Description
	 * 		读取文件流并复制到指定位置
	 * 			destroy:true  销毁指定文件
	 *
	 * @param inputStream
	 * @param desFile
	 * @param destroy
	 * @return
	 */
	public static boolean copyInputStreamToFile(InputStream inputStream, File desFile, boolean destroy) {
		try {
			if(desFile.exists()) {
				if(destroy) {
					desFile.delete();
					FileUtils.copyInputStreamToFile(inputStream, desFile);
					return true;
				} else {
					return false;
				}
			} else {
				FileUtils.copyInputStreamToFile(inputStream, desFile);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("InputStream 复制出错");
			return false;
		}
	}
	
	/**
	 * 
	 * @Method copy
	 * @author LEON
	 * @Date 2014-3-21 下午5:15:13
	 * @Description
	 * 		文件复制
	 *
	 * @param rscFile 原文件
	 * @param desFile 目标文件
	 * @return
	 */
	public static boolean copy(File rscFile, File desFile) {
		try {
			if(desFile.exists()) {
				return false;
			} else {
				FileUtils.copyFile(rscFile, desFile);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("文件：" + rscFile.getName().trim() + "复制过程中出错");
			return false;
		}
	}
	
	/**
	 * 
	 * @author chenmaolong
	 * @date 2015年9月17日 下午2:56:09
	 * @description 在指定目录创建文件
	 * @param pathUrl 文件保存目录
	 * @param lista 数据
	 * @param fileName 文件名称
	 * @throws IOException
	 *
	 */
	public static void newInputFile(String pathUrl,String lista, String fileName) throws IOException {
		File folder = new File(pathUrl);
		if (folder == null || !folder.exists()) {
			folder.mkdirs();
		}
		File targetFile = new File(pathUrl + fileName);
		OutputStreamWriter osw;

		try {
			if (targetFile.exists()) {
				targetFile.delete();
			}
			targetFile.createNewFile();
			osw = new OutputStreamWriter(new FileOutputStream(targetFile),
					"utf-8");
			osw.write(lista);
			osw.flush();
			osw.close();
		} finally {
		}
	}
	
	public static void main(String[] args) {
		createFolders("E:\\workspace\\B2B_Manager\\WebRoot\\material\\editdate1");
	}
}
