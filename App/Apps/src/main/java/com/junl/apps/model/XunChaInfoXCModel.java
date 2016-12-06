package com.junl.apps.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: XunChaInfoXCModel
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月25日 下午2:30:00
*
 */
public class XunChaInfoXCModel {
	
	private String ids;
	/**
	 * 巡查开始桩号千米位
	 */
	private int xunChaStartZHK;
	/**
	 * 巡查开始桩号米位
	 */
	private int xunChaStartZHM;
	/**
	 * 巡查结束桩号千米位
	 */
	private int xunChaEndZHK;
	/**
	 * 巡查结束桩号米位
	 */
	private int xunChaEndZHM;
	/**
	 * 修补损坏标识
	 */
	private String xiuBuBiaoZhi;
	/**
	 * 维修模块id
	 */
	private String wxmkId;
	/**
	 * 病害或缺陷类型(病害指标)
	 */
	private String binghaiOrQueXianType;
	/**
	 * 病害或缺陷描述
	 */
	private String binghaiOrQueXianMiaoShu;
	/**
	 * 紧急程度
	 */
	private String level;
	/**
	 * 预估工程量
	 */
	private String yuGuGongChengLiang;
	/**
	 * 预估工程量单位
	 */
	private String yuGuGongChengLiangDw;
	/**
	 * 巡查时间（可修改的）
	 */
	private Timestamp xunChaTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 图片
	 */
	private String imgs;
	/**
	 * 巡查人id
	 */
	private String xunChaUserId;
	/**
	 * 巡查头部信息id
	 */
	private String xunChaTouId;
	/**
	 * 路线
	 */
	private String luXian;
	/**
	 * 位置类型
	 */
	private String wzType;
	/**
	 * 位置名称
	 */
	private String wzName;
	/**
	 * 位置描述
	 */
	private String wzMiaoShu;
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	/**
	 * 0:表示已创建，1:表示已关联任务，2:已完成，3:未完成
	 */
	private String state;
	
	
	private List<XunChaInfoRelateModel> list=new ArrayList<XunChaInfoRelateModel>();
	
	public List<XunChaInfoRelateModel> getList() {
		return list;
	}
	public void setList(List<XunChaInfoRelateModel> list) {
		this.list = list;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public int getXunChaStartZHK() {
		return xunChaStartZHK;
	}
	public void setXunChaStartZHK(int xunChaStartZHK) {
		this.xunChaStartZHK = xunChaStartZHK;
	}
	public int getXunChaStartZHM() {
		return xunChaStartZHM;
	}
	public void setXunChaStartZHM(int xunChaStartZHM) {
		this.xunChaStartZHM = xunChaStartZHM;
	}
	public int getXunChaEndZHK() {
		return xunChaEndZHK;
	}
	public void setXunChaEndZHK(int xunChaEndZHK) {
		this.xunChaEndZHK = xunChaEndZHK;
	}
	public int getXunChaEndZHM() {
		return xunChaEndZHM;
	}
	public void setXunChaEndZHM(int xunChaEndZHM) {
		this.xunChaEndZHM = xunChaEndZHM;
	}
	public String getXiuBuBiaoZhi() {
		return xiuBuBiaoZhi;
	}
	public void setXiuBuBiaoZhi(String xiuBuBiaoZhi) {
		this.xiuBuBiaoZhi = xiuBuBiaoZhi;
	}
	public String getWxmkId() {
		return wxmkId;
	}
	public void setWxmkId(String wxmkId) {
		this.wxmkId = wxmkId;
	}
	public String getBinghaiOrQueXianType() {
		return binghaiOrQueXianType;
	}
	public void setBinghaiOrQueXianType(String binghaiOrQueXianType) {
		this.binghaiOrQueXianType = binghaiOrQueXianType;
	}
	public String getBinghaiOrQueXianMiaoShu() {
		return binghaiOrQueXianMiaoShu;
	}
	public void setBinghaiOrQueXianMiaoShu(String binghaiOrQueXianMiaoShu) {
		this.binghaiOrQueXianMiaoShu = binghaiOrQueXianMiaoShu;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getYuGuGongChengLiang() {
		return yuGuGongChengLiang;
	}
	public void setYuGuGongChengLiang(String yuGuGongChengLiang) {
		this.yuGuGongChengLiang = yuGuGongChengLiang;
	}
	public String getYuGuGongChengLiangDw() {
		return yuGuGongChengLiangDw;
	}
	public void setYuGuGongChengLiangDw(String yuGuGongChengLiangDw) {
		this.yuGuGongChengLiangDw = yuGuGongChengLiangDw;
	}
	
	public Timestamp getXunChaTime() {
		return xunChaTime;
	}
	public void setXunChaTime(Timestamp xunChaTime) {
		this.xunChaTime = xunChaTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getXunChaUserId() {
		return xunChaUserId;
	}
	public void setXunChaUserId(String xunChaUserId) {
		this.xunChaUserId = xunChaUserId;
	}
	public String getXunChaTouId() {
		return xunChaTouId;
	}
	public void setXunChaTouId(String xunChaTouId) {
		this.xunChaTouId = xunChaTouId;
	}
	public String getLuXian() {
		return luXian;
	}
	public void setLuXian(String luXian) {
		this.luXian = luXian;
	}
	public String getWzType() {
		return wzType;
	}
	public void setWzType(String wzType) {
		this.wzType = wzType;
	}
	public String getWzName() {
		return wzName;
	}
	public void setWzName(String wzName) {
		this.wzName = wzName;
	}
	public String getWzMiaoShu() {
		return wzMiaoShu;
	}
	public void setWzMiaoShu(String wzMiaoShu) {
		this.wzMiaoShu = wzMiaoShu;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
