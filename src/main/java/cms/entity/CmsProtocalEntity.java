package cms.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 可变情报板播放表通用协议实体
 * @author 孙冠义
 *
 */
public class CmsProtocalEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6267554107556358819L;
	
	/**
	 * 可变情报板屏幕宽度
	 */
	private Integer displayWidth;
	/**
	 * 可变情报板屏幕高度度
	 */
	private Integer displayHeight;
	/**
	 * 显示屏类型  0-双基色或全彩；1－琥珀色；2-不需要设置颜色
	 */
	private Integer dispScrType;	
	/**
	 * 停留时间，单位：百分之一秒
	 */
	private Integer timeDelay;
	/**
	 * 出字方式
	 */
	private Integer transition;
	/**
	 * 出字方式：
	 * 当出字方式为 0 或 1 时，param 无用；当出字方式为 2-21 时，param 表速度，范围
   	 * 0-49，缺省为 0。其中 0 表示最快，即每幅画面停留 20 毫秒，param 每增加 1 停留
     * 时间就增加 20 毫秒。
	 * 单位：20毫秒
	 */
	private Integer param;
	/**
	 * 可变情报板每屏的图标参数列表
	 */
	private List<CMSIconParam> graphList;
	/**
	 * 可变情报板每屏的文字参数列表
	 */
	private List<CMSWordParam> wordList;
	/**
	 * 节目单标识号
	 */
	private String guid;
	/**
	 * 可变情报板屏幕宽度
	 */
	public Integer getDisplayWidth() {
		return displayWidth;
	}
	/**
	 * 可变情报板屏幕宽度
	 */
	public void setDisplayWidth(Integer displayWidth) {
		this.displayWidth = displayWidth;
	}
	/**
	 * 可变情报板屏幕高度度
	 */
	public Integer getDisplayHeight() {
		return displayHeight;
	}
	/**
	 * 可变情报板屏幕高度度
	 */
	public void setDisplayHeight(Integer displayHeight) {
		this.displayHeight = displayHeight;
	}
	/**
	 * 显示屏类型0-双基色或全彩；1－琥珀色；2-不需要设置颜色
	 */
	public Integer getDispScrType() {
		return dispScrType;
	}
	/**
	 * 显示屏类型0-双基色或全彩；1－琥珀色；2-不需要设置颜色
	 */
	public void setDispScrType(Integer dispScrType) {
		this.dispScrType = dispScrType;
	}
	/**
	 * 停留时间，单位：百分之一秒
	 */
	public Integer getTimeDelay() {
		return timeDelay;
	}
	/**
	 * 停留时间，单位：百分之一秒
	 */
	public void setTimeDelay(Integer timeDelay) {
		this.timeDelay = timeDelay;
	}
	/**
	 * 出字方式
	 */
	public Integer getTransition() {
		return transition;
	}
	/**
	 * 出字方式
	 */
	public void setTransition(Integer transition) {
		this.transition = transition;
	}
	/**
	 * 出字方式：当出字方式为0或1时，param无用；当出字方式为2-21时，param表速度，范围0-49，缺省为0。其中0表示最快，即每幅画面停留20毫秒，出字方式：当出字方式为0或1时，param无用；当出字方式为2-21时，param表速度，范围0-49，缺省为0。其中0表示最快，即每幅画面停留20毫秒，param每增加1停留时间就增加20毫秒。单位：20毫秒每增加1停留时间就增加20毫秒。单位：20毫秒
	 */
	public Integer getParam() {
		return param;
	}
	/**
	 * 出字方式：当出字方式为0或1时，param无用；当出字方式为2-21时，param表速度，范围0-49，缺省为0。其中0表示最快，即每幅画面停留20毫秒，出字方式：当出字方式为0或1时，param无用；当出字方式为2-21时，param表速度，范围0-49，缺省为0。其中0表示最快，即每幅画面停留20毫秒，param每增加1停留时间就增加20毫秒。单位：20毫秒每增加1停留时间就增加20毫秒。单位：20毫秒
	 */
	public void setParam(Integer param) {
		this.param = param;
	}
	/**
	 * 可变情报板每屏的图标参数列表
	 */
	public List<CMSIconParam> getGraphList() {
		return graphList;
	}
	/**
	 * 可变情报板每屏的图标参数列表
	 */
	public void setGraphList(List<CMSIconParam> graphList) {
		this.graphList = graphList;
	}
	/**
	 * 可变情报板每屏的文字参数列表
	 */
	public List<CMSWordParam> getWordList() {
		return wordList;
	}
	/**
	 * 可变情报板每屏的文字参数列表
	 */
	public void setWordList(List<CMSWordParam> wordList) {
		this.wordList = wordList;
	}
	/**
	 * 节目单标识号
	 */
	public String getGuid() {
		return guid;
	}
	/**
	 * 节目单标识号
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	
}
