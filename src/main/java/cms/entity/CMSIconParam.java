package cms.entity;

import java.io.Serializable;

/**
 * 可变情报板固定图片显示参数
 * @author Administrator
 *
 */
public class CMSIconParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4805582065861085199L;
	/**
	 * 可变情报板固定图片起点X坐标
	 */
	private Integer graphXXX;
	/**
	 * 可变情报板固定图片起点Y坐标
	 */
	private Integer graphYYY;
	/**
	 * 可变情报板固定图片id
	 */
	private String graphId;
	/**
	 * 可变情报板固定图片名称
	 */
	private String graphName;
	/**
	 * @return the 可变情报板固定图片X坐标
	 */
	public Integer getGraphXXX() {
		return graphXXX;
	}
	/**
	 * @param 可变情报板固定图片X坐标 the graphXXX to set
	 */
	public void setGraphXXX(Integer graphXXX) {
		this.graphXXX = graphXXX;
	}
	/**
	 * @return the 可变情报板固定图片Y坐标
	 */
	public Integer getGraphYYY() {
		return graphYYY;
	}
	/**
	 * @param 可变情报板固定图片Y坐标 the graphYYY to set
	 */
	public void setGraphYYY(Integer graphYYY) {
		this.graphYYY = graphYYY;
	}
	/**
	 * @return the 可变情报板固定图片id
	 */
	public String getGraphId() {
		return graphId;
	}
	/**
	 * @param 可变情报板固定图片id the graphId to set
	 */
	public void setGraphId(String graphId) {
		this.graphId = graphId;
	}	
	
	/**
	 * 可变情报板固定图片名称
	 */
	public String getGraphName() {
		return graphName;
	}
	/**
	 * 可变情报板固定图片名称
	 */
	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}
	/**
	 * 无参构造方法
	 */
	public CMSIconParam(){}
	
	/**
	 * 有参构造方法
	 * @param graphXXX
	 * @param graphYYY
	 * @param graphId
	 * @param graphName
	 */
	public CMSIconParam(Integer graphXXX, Integer graphYYY, String graphId,
			String graphName) {
		super();
		this.graphXXX = graphXXX;
		this.graphYYY = graphYYY;
		this.graphId = graphId;
		this.graphName = graphName;
	}
	
	
	
	
}
