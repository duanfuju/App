package com.junl.apps.model;

import java.sql.Timestamp;
/**
 * 
* @ClassName: WXYouWuModel
* @Description: TODO(这里用一句话描述这个类的作用)
* @author dfj
* @date 2016年8月25日 下午2:29:55
*
 */
public class WXYouWuModel {
	/**
	 * 主键
	 */
	private String ids;
	/**
	 * 天气状况
	 */
	private String weatherState;
	/**
	 * 气温
	 */
	private double qiWen;
	/**
	 * 开始桩号千米位
	 */
	private int startZHK;
	/**
	 * 开始桩号米位
	 */
	private int startZHM;
	/**
	 * 结束桩号千米位
	 */
	private int endZHK;
	/**
	 * 结束桩号米位
	 */
	private int endZHM;
	/**
	 * 面积
	 */
	private double mianJi;
	/**
	 * 处理时间
	 */
	private Timestamp disposeTime;
	/**
	 * 施工机械
	 */
	private String shiGongJiXie;
	/**
	 * 施工人员
	 */
	private String shiGongRenYuan;
	/**
	 * 现场专职安全员
	 */
	private String anQuanYuan;
	/**
	 * 现场施工负责人
	 */
	private String fuZeRen;
	/**
	 * 质量评价
	 */
	private String pingJia;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 图片
	 */
	private String imgs;
	/**
	 * 任务和巡查信息关联id
	 */
	private String taskInfoRelate;
	/**
	 * 
	 */
	private String createUserId;
	/**
	 * 状态值1代表计量，2代表退回
	 */
	private int state;
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
	 * 
	 */
	private String luBingType;
	/**
	 * 发现时间
	 */
	private Timestamp foundTime;
	/**
	 * 计量金额
	 */
	private int meteringNum;
	/**
	 * 计量金额
	 */
	private double meteringMoney;
	/**
	 * 损坏原因类型
	 */
	private String sunHuaiCauseType;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getWeatherState() {
		return weatherState;
	}
	public void setWeatherState(String weatherState) {
		this.weatherState = weatherState;
	}
	public double getQiWen() {
		return qiWen;
	}
	public void setQiWen(double qiWen) {
		this.qiWen = qiWen;
	}
	public int getStartZHK() {
		return startZHK;
	}
	public void setStartZHK(int startZHK) {
		this.startZHK = startZHK;
	}
	public int getStartZHM() {
		return startZHM;
	}
	public void setStartZHM(int startZHM) {
		this.startZHM = startZHM;
	}
	public int getEndZHK() {
		return endZHK;
	}
	public void setEndZHK(int endZHK) {
		this.endZHK = endZHK;
	}
	public int getEndZHM() {
		return endZHM;
	}
	public void setEndZHM(int endZHM) {
		this.endZHM = endZHM;
	}
	public double getMianJi() {
		return mianJi;
	}
	public void setMianJi(double mianJi) {
		this.mianJi = mianJi;
	}
	public Timestamp getDisposeTime() {
		return disposeTime;
	}
	public void setDisposeTime(Timestamp disposeTime) {
		this.disposeTime = disposeTime;
	}
	public String getShiGongJiXie() {
		return shiGongJiXie;
	}
	public void setShiGongJiXie(String shiGongJiXie) {
		this.shiGongJiXie = shiGongJiXie;
	}
	public String getShiGongRenYuan() {
		return shiGongRenYuan;
	}
	public void setShiGongRenYuan(String shiGongRenYuan) {
		this.shiGongRenYuan = shiGongRenYuan;
	}
	public String getAnQuanYuan() {
		return anQuanYuan;
	}
	public void setAnQuanYuan(String anQuanYuan) {
		this.anQuanYuan = anQuanYuan;
	}
	public String getFuZeRen() {
		return fuZeRen;
	}
	public void setFuZeRen(String fuZeRen) {
		this.fuZeRen = fuZeRen;
	}
	public String getPingJia() {
		return pingJia;
	}
	public void setPingJia(String pingJia) {
		this.pingJia = pingJia;
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
	public String getTaskInfoRelate() {
		return taskInfoRelate;
	}
	public void setTaskInfoRelate(String taskInfoRelate) {
		this.taskInfoRelate = taskInfoRelate;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public String getLuBingType() {
		return luBingType;
	}
	public void setLuBingType(String luBingType) {
		this.luBingType = luBingType;
	}
	public Timestamp getFoundTime() {
		return foundTime;
	}
	public void setFoundTime(Timestamp foundTime) {
		this.foundTime = foundTime;
	}
	public int getMeteringNum() {
		return meteringNum;
	}
	public void setMeteringNum(int meteringNum) {
		this.meteringNum = meteringNum;
	}
	public double getMeteringMoney() {
		return meteringMoney;
	}
	public void setMeteringMoney(double meteringMoney) {
		this.meteringMoney = meteringMoney;
	}
	public String getSunHuaiCauseType() {
		return sunHuaiCauseType;
	}
	public void setSunHuaiCauseType(String sunHuaiCauseType) {
		this.sunHuaiCauseType = sunHuaiCauseType;
	}
	
}
