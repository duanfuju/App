package com.junl.apps.form;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.junl.apps.common.BaseForm;
/**
 * 
 * @author dfj
 * @date 2016年8月19日上午10:01:00 
 * @description
 *
 */
public class FzhlForm extends BaseForm {

	private String ids;
	/**
	 * 维修人员
	 */
	private String weiXiuRenYuan;
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
	 * 维修开始时间
	 */
	private Timestamp weiXiuStartTime;
	/**
	 * 维修结束时间
	 */
	private Timestamp weiXiuEndTime;
	/**
	 * 施工机械
	 */
	private String shiGongJiXie;
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
	 * 整体线形
	 */
	private String ztXianXing;
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
	 * 维修长度
	 */
	private double weiXiuChangDu;
	/**
	 * 具体位置
	 */
	private String juTiWeiZhi;
	/**
	 * 损坏原因类型
	 */
	private String sunHuaiCauseType;
	/**
	 * 损坏原因
	 */
	private String sunHuaiCause;
	/**
	 * 事故时间
	 */
	private Timestamp shiGuTime;
	/**
	 * 未及时修补原因
	 */
	private String wjsxbCause;
	/**
	 * 损坏现状描述
	 */
	private String sunHuaiMiaoShu;
	/**
	 * 其他相关项目维修数量
	 */
	private String qiTaWeiXiuNum;
	/**
	 * 创建人id
	 */
	private String createUserId;
	/**
	 * 状态值1代表计量，2代表退回，3验收，4未通过
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
	private String createTime;
	/**
	 * 病害类型
	 */
	private String luBingType;
	/**
	 * 计量数
	 */
	private int meteringNum;
	/**
	 * 计量金额
	 */
	private double meteringMoney;
	
	private List<FzhlRelateForm> list=new ArrayList<FzhlRelateForm>();
	
	

	public List<FzhlRelateForm> getList() {
		return list;
	}

	public void setList(List<FzhlRelateForm> list) {
		this.list = list;
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

	public Timestamp getWeiXiuStartTime() {
		return weiXiuStartTime;
	}

	public void setWeiXiuStartTime(Timestamp weiXiuStartTime) {
		this.weiXiuStartTime = weiXiuStartTime;
	}

	public Timestamp getWeiXiuEndTime() {
		return weiXiuEndTime;
	}

	public void setWeiXiuEndTime(Timestamp weiXiuEndTime) {
		this.weiXiuEndTime = weiXiuEndTime;
	}

	public String getShiGongJiXie() {
		return shiGongJiXie;
	}

	public void setShiGongJiXie(String shiGongJiXie) {
		this.shiGongJiXie = shiGongJiXie;
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

	public String getZtXianXing() {
		return ztXianXing;
	}

	public void setZtXianXing(String ztXianXing) {
		this.ztXianXing = ztXianXing;
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

	public double getWeiXiuChangDu() {
		return weiXiuChangDu;
	}

	public void setWeiXiuChangDu(double weiXiuChangDu) {
		this.weiXiuChangDu = weiXiuChangDu;
	}

	public String getJuTiWeiZhi() {
		return juTiWeiZhi;
	}

	public void setJuTiWeiZhi(String juTiWeiZhi) {
		this.juTiWeiZhi = juTiWeiZhi;
	}

	public String getSunHuaiCauseType() {
		return sunHuaiCauseType;
	}

	public void setSunHuaiCauseType(String sunHuaiCauseType) {
		this.sunHuaiCauseType = sunHuaiCauseType;
	}

	public String getSunHuaiCause() {
		return sunHuaiCause;
	}

	public void setSunHuaiCause(String sunHuaiCause) {
		this.sunHuaiCause = sunHuaiCause;
	}

	public Timestamp getShiGuTime() {
		return shiGuTime;
	}

	public void setShiGuTime(Timestamp shiGuTime) {
		this.shiGuTime = shiGuTime;
	}

	public String getWjsxbCause() {
		return wjsxbCause;
	}

	public void setWjsxbCause(String wjsxbCause) {
		this.wjsxbCause = wjsxbCause;
	}

	public String getSunHuaiMiaoShu() {
		return sunHuaiMiaoShu;
	}

	public void setSunHuaiMiaoShu(String sunHuaiMiaoShu) {
		this.sunHuaiMiaoShu = sunHuaiMiaoShu;
	}

	public String getQiTaWeiXiuNum() {
		return qiTaWeiXiuNum;
	}

	public void setQiTaWeiXiuNum(String qiTaWeiXiuNum) {
		this.qiTaWeiXiuNum = qiTaWeiXiuNum;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLuBingType() {
		return luBingType;
	}

	public void setLuBingType(String luBingType) {
		this.luBingType = luBingType;
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

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getWeiXiuRenYuan() {
		return weiXiuRenYuan;
	}

	public void setWeiXiuRenYuan(String weiXiuRenYuan) {
		this.weiXiuRenYuan = weiXiuRenYuan;
	}

	
	
}
