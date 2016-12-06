package com.junl.apps.service.imageupload;

import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public interface IUploadImg {
	
	
	/**
	 * 上传图片
	 * @param file
	 * @return 上传之后的路径
	 * @throws Exception
	 */
	public String uploadImage(CommonsMultipartFile image,String waterMatkStr) throws Exception;
	
}
