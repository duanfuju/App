package com.junl.apps.service.imageupload;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.junl.apps.common.FileUtils;
import com.junl.apps.common.ImageUtils;
import com.junl.frame.tools.ConfigUtil;
import com.junl.frame.tools.UUIDGenerator;

@Service
public class UploadImgImpl implements IUploadImg {
	
	Logger log = Logger.getLogger(this.getClass());

	@Override
	public String uploadImage(CommonsMultipartFile image,String waterMarkStr)
			throws Exception {
		String imgServerPath = "";
		//相对路径  虚拟路径
		String imgServerXDPath = ConfigUtil.getValue("imgPath")+"/waterImg";
		// 是否存在图片
		if(!image.isEmpty()) {
			
			String suffix = image.getOriginalFilename()
					.substring(image.getOriginalFilename().lastIndexOf("."));
			
			// 重改图片名称并上传至服务器文件夹中
			String fileUuid = UUIDGenerator.generate();
			String fileName = fileUuid + suffix;
			if(imgServerPath.equals(""))
			{
				//获取当前服务器路径
				imgServerPath = FileUtils.getServerRootPath()+imgServerXDPath;
			}
			//讲文件写入指定位置
			FileUtils.copyInputStreamToFile(imgServerPath,fileName, image.getInputStream());
			String filePath = imgServerPath+"/"+fileName;
			String fileMinName = fileUuid+"-min"+suffix;
			String fileWaterMarkName = fileUuid+"-waterMark"+suffix;
			// 验证上传的图片是否存在
			File check = new File(filePath);
			if(check.exists())
			{
				// 相同目录下生成缩略图  0.05
				Thumbnails.of(filePath)   
		        .scale(0.05f)  
		        .toFile(imgServerPath+"/"+fileMinName);  
				
				//watermark(位置，水印图，透明度)  
				String waterMarkPath = imgServerPath+"\\"+fileWaterMarkName;
				//根据文字生成水印图
				String fontPath = FileUtils.getProjectServerRootPath()+"font/songti.TTF";
				
				Font font  = ImageUtils.customFont(fontPath);
				//获取原图的大小  添加水印
				BufferedImage bImage = ImageIO.read(check);
				
				ImageUtils.generratorImageByStr(waterMarkStr, waterMarkPath,font,bImage);
				
				//判断水印图是否存在
				File waterMark = new File(waterMarkPath);
				if(waterMark.exists())
				{
					Thumbnails.of(filePath)
					.size(bImage.getWidth(), bImage.getHeight())
			        .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(waterMark), 0.5f)   
			        .outputQuality(0.8f)   
			        .toFile(filePath);
				}
				return imgServerXDPath+"/"+fileName;
			}
			else
			{
				log.error("文件上传失败！");
			}
		}
		return "";
	}
	
	 public static void main( String args[] )   
	 {  
	    System.out.println( System.getProperty("os.name") );  
	 }  


}
