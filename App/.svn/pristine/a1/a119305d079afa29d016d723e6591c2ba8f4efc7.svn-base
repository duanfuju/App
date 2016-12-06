package com.junl.frame.tools.qrcode;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.junl.frame.tools.string.StringUtils;

/**
 * 
 * @author LEON
 * @date 2016年1月4日 下午5:28:13
 * @description 
 * 		二维码生成与解析工具类 方法内固定死，只能生成正方形的哦
 * 
 */
public class QRUtils {

	private static final Log logger = LogFactory.getLog(QRUtils.class);

	/**
	 * 默认编码格式
	 */
	private static final String CHARSET = "utf-8";

	/**
	 * 二维码图片格式
	 */
	private static final String FORMAT_NAME = "png";

	/**
	 * 二维码大小
	 */
	private static final int QRCODE_SIZE = 300;

	/**
	 * logo大小
	 */
	private static final int LOGO_SIZE = 60;
	
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午5:16:30
	 * @description 
	 *     初始化参数
	 * @return
	 *
	 */
	private static Hashtable<EncodeHintType, Object> initParam() {
		
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		
		return hints;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午5:21:38
	 * @description 
	 *     二维码生成核心方法
	 *     
	 * @param content 内容
	 * @param size 生成后大小 
	 * @param logoSize logo大小
	 * @param needLogo 是否需要logo true则需要
	 * @return
	 *
	 */
	private static BufferedImage generate(String content, String size, String logoSize
			, String logoPath, boolean needLogo) {
		
		BufferedImage image = null;
		try {
			// 配置参数
			Hashtable<EncodeHintType, Object> hints = QRUtils.initParam();
			// 生成矩阵 如果没有传入图片大小则使用默认的配置大小
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE
					, StringUtils.isEmpty(size) ? QRCODE_SIZE : Integer.parseInt(size)
					, StringUtils.isEmpty(size) ? QRCODE_SIZE : Integer.parseInt(size), hints);
			// 绘制二维码
			image = MatrixToImageWriter.toBufferedImage(bitMatrix);
			
			if(needLogo) {
				drawLogo(image, logoPath, logoSize);
			}
		} catch (Exception e) {
			logger.error("二维码生成失败。");
			e.printStackTrace();
		}
		return image;
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午6:25:13
	 * @description 
	 *     解析二维码核心方法
	 *      
	 * @param image 二维码图片
	 * @return
	 * @throws NotFoundException
	 *
	 */
	private static String analysis(BufferedImage image) throws NotFoundException {
		
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);  
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		// 配置参数
		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		// 对二维码进行解码
		Result result = new MultiFormatReader().decode(bitmap, hints);
		return result.getText();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午5:26:35
	 * @description 
	 *     绘制logo图片
	 *     
	 * @param qrImage 生成后的二维码图片
	 * @param logoPath logo图片地址
	 * 
	 * @throws IOException 
	 *
	 */
	private static void drawLogo(BufferedImage qrImage, String logoPath, String logoSize) throws IOException {
		
		// 判断LOGO文件是否存在
		File file = new File(logoPath);
		if (!file.exists()) {
			logger.error("文件:" + logoPath + "不存在。系统自动默认去除LOGO水印");
			return;
		}
		
		// 根据指定尺寸压缩logo图片
		Image logoImage = ImageIO.read(file);
		int width = StringUtils.isEmpty(logoSize) ? QRUtils.LOGO_SIZE : Integer.parseInt(logoSize);
		int height = StringUtils.isEmpty(logoSize) ? QRUtils.LOGO_SIZE : Integer.parseInt(logoSize);
		
		Image compressImage = logoImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(compressImage, 0, 0, null); // 绘制缩小后的图
		g.dispose();
		logoImage = compressImage;
		
		// 插入LOGO
		Graphics2D graph = qrImage.createGraphics();
		int x = (qrImage.getWidth() - width) / 2;
		int y = (qrImage.getHeight() - height) / 2;
		graph.drawImage(logoImage, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 2, 2);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午5:41:26
	 * @description 
	 *      生成二维码
	 *      
	 * @param content 内容
	 * @param size 二维码尺寸
	 * @param logoSize logo尺寸
	 * @param logoPath logo地址
	 * @param needLogo 是否需要logo
	 * 
	 * @return BufferedImage
	 *
	 */
	public static BufferedImage encode(String content, String size, String logoSize
			, String logoPath, boolean needLogo) {
		
		return QRUtils.generate(content, size, logoSize, logoPath, needLogo);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午5:43:17
	 * @description 
	 *     生成二维码
	 *     
	 * @param content 内容
	 * @param size 二维码尺寸
	 * @param logoSize logo尺寸
	 * @param logoPath logo地址
	 * @param needLogo 是否需要logo
	 * @param desPath 图片生成地址
	 * @throws IOException 
	 *
	 */
	public static void encode(String content, String size, String logoSize
			, String logoPath, boolean needLogo, String desPath) throws IOException {
		
		BufferedImage image = QRUtils.generate(content, size, logoSize, logoPath, needLogo);
		ImageIO.write(image, FORMAT_NAME, new File(desPath));
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午5:49:51
	 * @description 
	 *     生成不带logo的二维码
	 *     
	 * @param content 内容
	 * @param size 二维码尺寸
	 * @param desPath 图片生成地址
	 * @throws IOException
	 *
	 */
	public static void encodeNoLogo(String content, String size, String desPath) throws IOException {
		
		BufferedImage image = QRUtils.generate(content, size, null, null, false);
		ImageIO.write(image, FORMAT_NAME, new File(desPath));
	}
	
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午6:25:32
	 * @description 
	 *     解析二维码
	 * @param qrPath
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 *
	 */
	public static String decode(String qrPath) throws IOException, NotFoundException {
		
		File file = new File(qrPath);
		if (!file.exists()) {
			logger.error("文件:" + qrPath + "不存在。");
			return null;
		}
		BufferedImage image = ImageIO.read(file);
		return QRUtils.analysis(image);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2016年1月5日 下午6:27:50
	 * @description 
	 *     解析二维码 文件流形式
	 * @param stream
	 * @return
	 *
	 */
	public static String decode(InputStream stream) {
		
		String text = "";
		try {
			BufferedImage image = ImageIO.read(stream);
			text = QRUtils.analysis(image);
		} catch (IOException e) {
			logger.error("二维码文件流读取失败");
			e.printStackTrace();
		} catch (NotFoundException e) {
			logger.error("二维码解析异常");
			e.printStackTrace();
		}
		return text;
	}
}
