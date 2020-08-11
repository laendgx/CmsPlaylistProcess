package com.boco.domain;

import java.io.Serializable;
/**
 * 情报板发布日志实体
 * @author dgx
 *
 */
public class JkptTxxtIssueLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626015708991654280L;
	/**
	 * 信息发布序号
	 */
	private Integer id;	
	/**
	 * 机构编码
	 */
	private Integer orgId;	
	/**
	 * 设备编码
	 */
	private Integer deviceId;
	/**
	 * 设备变量类型id
	 */
	private Integer devVarTypeId;
	/**
	 * 设备类型
	 */
	private Integer deviceTypeId;
	/**
	 * 人员编号，与JKPT_BASE_USER中的userid对应
	 */
	private String operatorId;	
	/**
	 * 下发时间
	 */
	private String controlDate;
	/**
	 * 下发的文字内容
	 */
	private String issueWordContent;	
	/**
	 * 发布信息－下发的情报板播放表
	 */
	private String issueInfo;	
	/**
	 * 成功标志。与JKPT_COMM_PARAMDIC中的OPERATFLAG对应
	 */
	private String operatFlag;
	/**
	 * @return the 信息发布序号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param //信息发布序号 the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the 机构编码
	 */
	public Integer getOrgId() {
		return orgId;
	}
	/**
	 * @param //机构编码 the orgId to set
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the 设备编码
	 */
	public Integer getDeviceId() {
		return deviceId;
	}
	/**
	 * @param //设备编码 the deviceId to set
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the 人员编号，与JKPT_BASE_USER中的userid对应
	 */
	public String getOperatorId() {
		return operatorId;
	}
	/**
	 * @param //人员编号，与JKPT_BASE_USER中的userid对应 the operatorId to set
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * @return the 下发的文字内容
	 */
	public String getIssueWordContent() {
		return issueWordContent;
	}
	/**
	 * @param //下发的文字内容 the issueWordContent to set
	 */
	public void setIssueWordContent(String issueWordContent) {
		this.issueWordContent = issueWordContent;
	}
	/**
	 * @return the 发布信息－下发的情报板播放表
	 */
	public String getIssueInfo() {
		return issueInfo;
	}
	/**
	 * @param //发布信息－下发的情报板播放表 the issueInfo to set
	 */
	public void setIssueInfo(String issueInfo) {
		this.issueInfo = issueInfo;
	}
	/**
	 * @return the 成功标志。与JKPT_COMM_PARAMDIC中的OPERATFLAG对应
	 */
	public String getOperatFlag() {
		return operatFlag;
	}
	/**
	 * @param //成功标志。与JKPT_COMM_PARAMDIC中的OPERATFLAG对应 the operatFlag to set
	 */
	public void setOperatFlag(String operatFlag) {
		this.operatFlag = operatFlag;
	}
	
	
	/**
	 * @return the 设备类型
	 */
	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}
	/**
	 * @param //设备类型 the deviceTypeId to set
	 */
	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	/**
	 * 有参构造函数	
	 * @param orgId
	 * @param deviceId
	 * @param deviceTypeId
	 * @param operatorId
	 * @param controldate
	 * @param issueWordContent
	 * @param issueInfo
	 * @param operatFlag
	 */
	public JkptTxxtIssueLog(Integer orgId, Integer deviceId,Integer devvartypeId,
			Integer deviceTypeId, String operatorId, String controldate,
			String issueWordContent, String issueInfo, String operatFlag) {
		super();
		this.orgId = orgId;
		this.deviceId = deviceId;
		this.devVarTypeId =devvartypeId;
		this.deviceTypeId = deviceTypeId;
		this.operatorId = operatorId;
		this.controlDate = controldate;
		this.issueWordContent = issueWordContent;
		this.issueInfo = issueInfo;
		this.operatFlag = operatFlag;
	}
	/**
	 * 无参构造函数
	 */
	public JkptTxxtIssueLog() {
		super();
	}

	public String getControlDate() {
		return controlDate;
	}

	public void setControlDate(String controlDate) {
		this.controlDate = controlDate;
	}

	public Integer getDevVarTypeId() {
		return devVarTypeId;
	}

	public void setDevVarTypeId(Integer devVarTypeId) {
		this.devVarTypeId = devVarTypeId;
	}
}
