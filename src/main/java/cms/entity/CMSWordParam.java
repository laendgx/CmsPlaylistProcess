package cms.entity;

import java.io.Serializable;

/**
 * 情报板播放表文字部分描述
 * @author 孙冠义
 *
 */
public class CMSWordParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914839839013337769L;
	/**
	 * 文字起点x坐标
	 */
	private Integer wordXXX;
	/**
	 * 文字起点y坐标
	 */
	private Integer wordYYY;
	/**
	 * 字体颜色，使用RGB表示，例如：红色为#FF0000
	 */
	private String fontColor;
	/**
	 * 字体背景色，使用RGB表示，例如：红色#FF0000
	 */
	private String fontBackColor;
	/**
	 * 字符阴影颜色，使用RGB表示，例如：红色#FF0000
	 */
	private String fontShadowColor; 
	/**
	 * 字间距
	 */
	private Integer wordSpace;
	/**
	 * 字体
	 * s－宋体  h－黑体  k－楷体
	 */
	private String fontName;
	/**
	 * 字体高度
	 */
	private Integer fontSize_HH;
	/**
	 * 字体宽度
	 */
	private Integer fontSize_WW;
	/**
	 * 文字内容
	 */
	private String wordContent;
	/**
	 * anglar增加的字段
	 */
	private String $$hashKey;
	/**
	 * @return the 文字起点x坐标
	 */
	public Integer getWordXXX() {
		return wordXXX;
	}
	/**
	 * @param 文字起点x坐标 the wordXXX to set
	 */
	public void setWordXXX(Integer wordXXX) {
		this.wordXXX = wordXXX;
	}
	/**
	 * @return the 文字起点y坐标
	 */
	public Integer getWordYYY() {
		return wordYYY;
	}
	/**
	 * @param 文字起点y坐标 the wordYYY to set
	 */
	public void setWordYYY(Integer wordYYY) {
		this.wordYYY = wordYYY;
	}
	/**
	 * @return the 字体颜色，使用RGB表示，例如：红色为#FF0000
	 */
	public String getFontColor() {
		return fontColor;
	}
	/**
	 * @param 字体颜色，使用RGB表示，例如：红色为#FF0000 the fontColor to set
	 */
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	/**
	 * @return the 字体背景色，使用RGB表示，例如：红色#FF0000
	 */
	public String getFontBackColor() {
		return fontBackColor;
	}
	/**
	 * @param 字体背景色，使用RGB表示，例如：红色#FF0000 the fontBackColor to set
	 */
	public void setFontBackColor(String fontBackColor) {
		this.fontBackColor = fontBackColor;
	}
	/**
	 * @return the 字符阴影颜色，使用RGB表示，例如：红色#FF0000
	 */
	public String getFontShadowColor() {
		return fontShadowColor;
	}
	/**
	 * @param 字符阴影颜色，使用RGB表示，例如：红色#FF0000 the fontShadowColor to set
	 */
	public void setFontShadowColor(String fontShadowColor) {
		this.fontShadowColor = fontShadowColor;
	}
	/**
	 * @return the 字间距
	 */
	public Integer getWordSpace() {
		return wordSpace;
	}
	/**
	 * @param 字间距 the wordSpace to set
	 */
	public void setWordSpace(Integer wordSpace) {
		this.wordSpace = wordSpace;
	}
	/**
	 * @return the 字体高度
	 */
	public Integer getFontSize_HH() {
		return fontSize_HH;
	}
	/**
	 * @param 字体高度 the fontSize_HH to set
	 */
	public void setFontSize_HH(Integer fontSize_HH) {
		this.fontSize_HH = fontSize_HH;
	}
	/**
	 * @return the 字体宽度
	 */
	public Integer getFontSize_WW() {
		return fontSize_WW;
	}
	/**
	 * @param 字体宽度 the fontSize_WW to set
	 */
	public void setFontSize_WW(Integer fontSize_WW) {
		this.fontSize_WW = fontSize_WW;
	}	
	/**
	 * 文字内容
	 */
	public String getWordContent() {
		return wordContent;
	}
	/**
	 * 文字内容
	 */
	public void setWordContent(String wordContent) {
		this.wordContent = wordContent;
	}	
	/**
	 * 字体s－宋体h－黑体k－楷体
	 */
	public String getFontName() {
		return fontName;
	}
	/**
	 * 字体s－宋体h－黑体k－楷体
	 */
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	
	/**
	 * $$hashKey
	 */
	public String get$$hashKey() {
		return $$hashKey;
	}
	/**
	 * $$hashKey
	 */
	public void set$$hashKey(String $$hashKey) {
		this.$$hashKey = $$hashKey;
	}
	/**
	 * 无参构造方法
	 */
	public CMSWordParam(){}
	/**
	 * 有参构造方法
	 * @param wordXXX
	 * @param wordYYY
	 * @param fontColor
	 * @param fontBackColor
	 * @param fontShadowColor
	 * @param wordSpace
	 * @param fontName
	 * @param fontSize_HH
	 * @param fontSize_WW
	 * @param wordContent
	 */
	public CMSWordParam(Integer wordXXX, Integer wordYYY, String fontColor,
			String fontBackColor, String fontShadowColor, Integer wordSpace,
			String fontName, Integer fontSize_HH, Integer fontSize_WW,
			String wordContent) {
		super();
		this.wordXXX = wordXXX;
		this.wordYYY = wordYYY;
		this.fontColor = fontColor;
		this.fontBackColor = fontBackColor;
		this.fontShadowColor = fontShadowColor;
		this.wordSpace = wordSpace;
		this.fontName = fontName;
		this.fontSize_HH = fontSize_HH;
		this.fontSize_WW = fontSize_WW;
		this.wordContent = wordContent;
	}
	
}
