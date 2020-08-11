package cmsconst;
/**
 * 标准的出字方式常量
 * 各种情报板在转换为各自的协议时，以此为标准转换
 * @author 孙冠义
 *
 */
public interface TransitionStand {
	/**
	 * 清屏（全黑）
	 */
	int ALL_BLACK = 0;
	/**
	 * 立即显示
	 */
	int STAT_DISPLAY = 1;
	/**
	 * 上移
	 */
	int UP_MOVE = 2;
	/**
	 * 下移
	 */
	int DN_MOVE = 3;
	/**
	 * 左移
	 */
	int LEFT_MOVE = 4;
	/**
	 * 	右移
	 */
	int RIGHT_MOVE = 5;
	/**
	 * 横百叶窗
	 */
	int HORIZONTAL_BLINDS = 6;
	/**
	 * 竖百叶窗
	 */
	int VERTICAL_BLINDS = 7;
	/**
	 * 上下合拢
	 */
	int ON_THE_CLOSURE = 8;
	/**
	 * 上下展开
	 */
	int ON_THE_NEXT_START = 9;
	/**
	 * 左右合拢
	 */
	int ABOUT_CLOSURE = 10;
	/**
	 * 左右展开
	 */
	int COMMENCE_AROUND = 11;
	/**
	 * 中心合拢
	 */
	int CENTER_CLOSURE = 12;
	/**
	 * 中心展开
	 */
	int CENTER = 13;
	/**
	 * 向下马赛克
	 */
	int MOSAIC_DOWN = 14;
	/**
	 * 向右马赛克
	 */
	int MOSAIC_RIGHT = 15;
	/**
	 * 淡入
	 */
	int FADE_IN = 16;
	/**
	 * 淡出
	 */
	int FADE_OUT = 17;
	/**
	 * 字符闪烁（闪后消失）
	 */
	int CHARACTER_BLINKING_AWAY = 18; 
	/**
	 * 字符闪烁（闪后停留）
	 */
	int CHARACTER_BLINKING_STAY = 19;
	/**
	 * 区域闪烁（闪后复原）
	 */
	int REGIONAL_FLICKER_RESTORE = 20;
	/**
	 * 区域闪烁（闪后区域为黑）
	 */
	int REGIONAL_FLICKER_BLACK = 21;
}
