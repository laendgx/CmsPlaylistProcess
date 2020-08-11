package com.boco.domain;

import java.io.Serializable;

/**
 * 发布记录查询关键字
 * @author dgx
 *
 */
public class IssueLogQueryConBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7613118004234082532L;
	/**
	 * 机构编码
	 */
	private Integer orgid;
	/**
	 * 设备类型
	 */
	private Integer devicetypeid;
	/**
	 * 关键字
	 */
	private String keywords;
	/**
	 * @return the 机构编码
	 */
	public Integer getOrgid() {
		return orgid;
	}
	/**
	 * @param //机构编码 the orgid to set
	 */
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}
	/**
	 * @return the 设备类型
	 */
	public Integer getDevicetypeid() {
		return devicetypeid;
	}
	/**
	 * @param //设备类型 the devicetypeid to set
	 */
	public void setDevicetypeid(Integer devicetypeid) {
		this.devicetypeid = devicetypeid;
	}
	/**
	 * @return the 关键字
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * @param //关键字 the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	
}
