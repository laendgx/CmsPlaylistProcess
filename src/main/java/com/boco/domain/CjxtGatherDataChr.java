package com.boco.domain;

import java.io.Serializable;

public class CjxtGatherDataChr  implements Serializable {
    private static final long serialVersionUID = -6323934412505491007L;
    /**
     * 机构编码
     */
    private Integer orgId;
    /**
     * 设备编码
     */
    private Integer deviceId;
    /**
     * 设备变量类型
     */
    private Integer deviceVarTypeId;
    /**
     * 下发时间
     */
    private String gatherTime;
    /**
     * 下发成功标识
     */
    private Integer sendFlag;
    /**
     * 下发数据
     */
    private String data;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceVarTypeId() {
        return deviceVarTypeId;
    }

    public void setDeviceVarTypeId(Integer deviceVarTypeId) {
        this.deviceVarTypeId = deviceVarTypeId;
    }

    public String getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(String gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Integer getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(Integer sendFlag) {
        this.sendFlag = sendFlag;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
