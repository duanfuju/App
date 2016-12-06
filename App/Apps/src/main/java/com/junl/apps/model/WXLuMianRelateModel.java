package com.junl.apps.model;
/**
 * 
* @ClassName: WXLuMianRelateModel
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月25日 下午3:49:18
*
 */
public class WXLuMianRelateModel {
	
	private String ids;
	/**
	 * 尺寸-长
	 */
	private double chiCunChang;
	/**
	 * 尺寸-宽
	 */
	private double chiCunKuan;
	/**
	 * 深度
	 */
	private double shenDu;
	/**
	 * 修补材料
	 */
	private String xiuBuCaiLiao;
	/**
	 * 施工材料温度
	 */
	private int caiLiaoWenDu;
	/**
	 * 层的类型(1为上面层，2为中面层，3为下面层，4为基层)
	 */
	private int cengType;
	/**
	 * 路面病害维修id
	 */
	private String weiXiuId;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public double getChiCunChang() {
		return chiCunChang;
	}
	public void setChiCunChang(double chiCunChang) {
		this.chiCunChang = chiCunChang;
	}
	public double getChiCunKuan() {
		return chiCunKuan;
	}
	public void setChiCunKuan(double chiCunKuan) {
		this.chiCunKuan = chiCunKuan;
	}
	public double getShenDu() {
		return shenDu;
	}
	public void setShenDu(double shenDu) {
		this.shenDu = shenDu;
	}
	public String getXiuBuCaiLiao() {
		return xiuBuCaiLiao;
	}
	public void setXiuBuCaiLiao(String xiuBuCaiLiao) {
		this.xiuBuCaiLiao = xiuBuCaiLiao;
	}
	public int getCaiLiaoWenDu() {
		return caiLiaoWenDu;
	}
	public void setCaiLiaoWenDu(int caiLiaoWenDu) {
		this.caiLiaoWenDu = caiLiaoWenDu;
	}
	public int getCengType() {
		return cengType;
	}
	public void setCengType(int cengType) {
		this.cengType = cengType;
	}
	public String getWeiXiuId() {
		return weiXiuId;
	}
	public void setWeiXiuId(String weiXiuId) {
		this.weiXiuId = weiXiuId;
	}
	
	
}
