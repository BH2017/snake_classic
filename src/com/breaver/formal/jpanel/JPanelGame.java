/**
 * 
 */
package com.breaver.formal.jpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.breaver.formal.bean.Snake;
import com.breaver.formal.config.ConstantsTCS;
import com.breaver.formal.enums.DirectionEnum;

/**
 * @author zzf
 * @date 2017年6月17日 下午3:45:04
 */
public class JPanelGame extends JPanel {

	// 游戏参数设置------------------------------
	private Snake snake = new Snake();
	private DirectionEnum directionEnum_current = DirectionEnum.SOUTH_direction;
	private DirectionEnum directionEnum_next = directionEnum_current;
	private Point point_food = new Point(0, 0);
	private Integer integer_keyCode;
	private Integer integer_score = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2440695318261072275L;
	private Graphics2D graphics2d = null;
	private ConstantsTCS constantsTCS = new ConstantsTCS();
	// private final Double leftAndRight = 2/3.0;//应该让左边为一个正方形
	private final Integer int_leftWidth = constantsTCS.getInt_windowHeight() - 30;
	// (int)(leftAndRight*constantsTCS.getInt_windowWidth());
	private final Integer int_rightWidth = constantsTCS.getInt_windowWidth() - int_leftWidth;
	private final Integer int_cutLineX = int_leftWidth;
	private final Integer int_heightY = constantsTCS.getInt_windowHeight() - 30;
	// 测试参数-----
	public static final Integer int_validHeight = 28;
	public static final Integer int_validStartX = 1;
	public static final Integer int_validSideLength = int_validHeight - 2;
	public static final Integer int_validSingleLength = 20;

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//------新一格与原来合并-----------------step4_3----------------------
	//-----按键输入--产生新一格---------------step4_2--------------------
	//-----当前基础前进一格---无方向改变----------------step4_1-----------------
	public Point createOnePointToForwardOneStep(){
		//---------------step4_1_1---------
		
		return null;
	}
	public JPanelGame() {
		super();
		// TODO Auto-generated constructor stub
		// snake = new Snake();
		// ------得到一个随机蛇身---------------step1-----------------------
		initSnakeBody();
		// ------得到一个随机食物--------------step2--------------------
		createFirstFood();
		// ------绘制到屏幕--------------step3------------------------
		/*构造完成后-可直接绘制*/
		// -------提供公有方法，运行流程------step4-------------------------
		
		//-------------test---------------console.log------------
		/*System.out.println("food:"+point_food.x+","+point_food.y);
		for(Point point:snake.getListBody())
			System.out.print("snake:"+point.x+","+point.y+"\n");*/
	}

	// ------------------------------step2.1------得到第一个食物-----------
	private void createFirstFood() {
		// 有效区域内查找------------------
		point_food=isFirstValidFood();
	}

	private Point isFirstValidFood() {
		Point a = new Point(0, 0);
		boolean same = false;
		while (true) {
			a.x = (int) (Math.random() * int_validSideLength)+1;
			a.y = (int) (Math.random() * int_validSideLength)+1;

			for (Point point : snake.getListBody())
				if (point.x == a.x && a.y == point.y) {
					same = true;
					break;
				}
			if (same) {
				same = false;
			} else {
				break;
			}
		}
		return a;
	}
	// ------------------------step1.1_1--------------判断头节点对不对------
/*	
	private boolean checkHeadIsLegal(Point point) {
		final int awayFromWall =4; 
		if (point.x >= awayFromWall && 
				point.x <= int_validSideLength -awayFromWall &&
				point.y >= awayFromWall && 
				point.y <= int_validSideLength - awayFromWall)
			return true; 
		return true;
	}
	 
*/
	// ------------------------step1.1_2--------明显成立---不需要判断-------
	private int getLegalHeadInitValue() {
		int a = 0;
		
		a=(int) (Math.random() * (int_validSideLength-4*2));
		return a;
	}

	// 随机初始化--蛇身--------限定头节点离四周-4格-----
	public void initSnakeBody() {
		// ------------------------step1.1-------------得到头节点---------
		Point head = this.snake.getListBody().get(0);
		head.x = getLegalHeadInitValue()+4;
		head.y = getLegalHeadInitValue()+4;
		// ------------------------step1.2------------初始化方向------------
		DirectionEnum directionEnum = DirectionEnum.SOUTH_direction;
		int a = (int) (Math.random() * 4);
		switch (a) {
		case 0:
			directionEnum = DirectionEnum.SOUTH_direction;
			for (int i = 1; i < 4; i++) {
				Point point = snake.getListBody().get(i);
				point.x = head.x;
				point.y = head.y - i;
			}
			break;
		case 1:
			directionEnum = DirectionEnum.EAST_direction;
			for (int i = 1; i < 4; i++) {
				Point point = snake.getListBody().get(i);
				point.y = head.y;
				point.x = head.x - i;
			}
			break;
		case 2:
			directionEnum = DirectionEnum.NORTH_direction;
			for (int i = 1; i < 4; i++) {
				Point point = snake.getListBody().get(i);
				point.x = head.x;
				point.y = head.y + i;
			}
			break;
		case 3:
			directionEnum = DirectionEnum.WEST_direction;
			for (int i = 1; i < 4; i++) {
				Point point = snake.getListBody().get(i);
				point.y = head.y;
				point.x = head.x + i;
			}
			break;
		default:
			JOptionPane.showMessageDialog(this, "这不可能的吧");
		}
		// ----------------------step1.3---------------初始化剩余3节点--------
		// ----转到上面step1.2
		this.directionEnum_current = directionEnum;
	}

	/**
	 * @return the snake
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * @param snake
	 *            the snake to set
	 */
	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		graphics2d = (Graphics2D) arg0;
		paint_comment(graphics2d);
		validate();
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
		validate();
		super.paint(graphics2d);
	}

	private void paint_comment(Graphics2D g) {
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		paint_backgroundLeft();
		paint_border();
		paint_testLine();
		showSnakeAndFood();
	}

	private void showSnakeAndFood() {
		//--------------step3.1-----绘制蛇身----------
		for (Point point : snake.getListBody()) {
			paint_brick(point.x * int_validSingleLength,
					point.y * int_validSingleLength, 
					int_validSingleLength,
					Color.WHITE, Color.ORANGE);
		}
		//----------------step3.2----------绘制蛇头-------------
		paint_brick(snake.getListBody().get(0).x * int_validSingleLength,
				snake.getListBody().get(0).y * int_validSingleLength, 
				int_validSingleLength, Color.ORANGE, Color.GRAY);
		//---------------step3.3------------------绘制食物-----------
		paint_brick(point_food.x*int_validSingleLength, 
				point_food.y*int_validSingleLength, 
				int_validSingleLength, 
				Color.blue, 
				Color.yellow);
	}

	private void paint_border() {
		graphics2d.setColor(Color.MAGENTA);
		int i;
		int v_x = 0;
		int v_y = 0;
		int v_temp = 0;
		int v_length_side = 20;
		v_temp = v_length_side * (int_validHeight - 1);
		for (i = 0; i < int_validHeight; i++) {
			paint_brick(v_x, v_y, v_length_side, Color.BLUE, Color.MAGENTA);
			paint_brick(v_temp, v_y, v_length_side, Color.BLUE, Color.MAGENTA);
			v_y += 20;
		}
		v_x = 0;
		v_y = 0;
		for (i = 0; i < int_validHeight; i++) {
			paint_brick(v_x, v_y, v_length_side, Color.BLUE, Color.MAGENTA);
			paint_brick(v_x, v_temp, v_length_side, Color.BLUE, Color.MAGENTA);
			v_x += 20;
		}

	}

	private void paint_testLine() {
		graphics2d.setColor(Color.RED);
		graphics2d.drawLine(int_validSingleLength * int_validStartX, 100, int_validSingleLength * int_validSideLength,
				100);
		graphics2d.drawLine(100, int_validSingleLength * int_validStartX, 100,
				int_validSingleLength * int_validSideLength);
	}

	private void paint_brick(int x, int y, int length, Color colorOutside, Color colorInside) {
		int padding_length = 2;
		int v_x = x + padding_length;
		int v_y = y + padding_length;
		int v_length = length - padding_length * 2;
		graphics2d.setColor(colorOutside);
		graphics2d.fillRect(x, y, length, length);
		graphics2d.setColor(colorInside);
		graphics2d.fillRect(v_x, v_y, v_length, v_length);
	}

	private void paint_backgroundLeft() {
		graphics2d.setColor(Color.DARK_GRAY);
		graphics2d.fillRect(0, 0, int_cutLineX, int_heightY);

	}

	/**
	 * @return the int_rightWidth
	 */
	public Integer getInt_rightWidth() {
		return int_rightWidth;
	}

	/**
	 * @return the directionEnum_current
	 */
	public DirectionEnum getDirectionEnum_current() {
		return directionEnum_current;
	}

	/**
	 * @param directionEnum_current
	 *            the directionEnum_current to set
	 */
	public void setDirectionEnum_current(DirectionEnum directionEnum_current) {
		this.directionEnum_current = directionEnum_current;
	}

	/**
	 * @return the directionEnum_next
	 */
	public DirectionEnum getDirectionEnum_next() {
		return directionEnum_next;
	}

	/**
	 * @param directionEnum_next
	 *            the directionEnum_next to set
	 */
	public void setDirectionEnum_next(DirectionEnum directionEnum_next) {
		this.directionEnum_next = directionEnum_next;
	}

	/**
	 * @return the point_food
	 */
	public Point getPoint_food() {
		return point_food;
	}

	/**
	 * @param point_food
	 *            the point_food to set
	 */
	public void setPoint_food(Point point_food) {
		this.point_food = point_food;
	}

	/**
	 * @return the integer_keyCode
	 */
	public Integer getInteger_keyCode() {
		return integer_keyCode;
	}

	/**
	 * @param integer_keyCode
	 *            the integer_keyCode to set
	 */
	public void setInteger_keyCode(Integer integer_keyCode) {
		this.integer_keyCode = integer_keyCode;
	}

	/**
	 * @return the integer_score
	 */
	public Integer getInteger_score() {
		return integer_score;
	}

	/**
	 * @param integer_score
	 *            the integer_score to set
	 */
	public void setInteger_score(Integer integer_score) {
		this.integer_score = integer_score;
	}

	/**
	 * @return the graphics2d
	 */
	public Graphics2D getGraphics2d() {
		return graphics2d;
	}

	/**
	 * @param graphics2d
	 *            the graphics2d to set
	 */
	public void setGraphics2d(Graphics2D graphics2d) {
		this.graphics2d = graphics2d;
	}

	/**
	 * @return the constantsTCS
	 */
	public ConstantsTCS getConstantsTCS() {
		return constantsTCS;
	}

	/**
	 * @param constantsTCS
	 *            the constantsTCS to set
	 */
	public void setConstantsTCS(ConstantsTCS constantsTCS) {
		this.constantsTCS = constantsTCS;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the int_leftWidth
	 */
	public Integer getInt_leftWidth() {
		return int_leftWidth;
	}

	/**
	 * @return the int_cutLineX
	 */
	public Integer getInt_cutLineX() {
		return int_cutLineX;
	}

	/**
	 * @return the int_heightY
	 */
	public Integer getInt_heightY() {
		return int_heightY;
	}

	/**
	 * @return the intValidheight
	 */
	public static Integer getIntValidheight() {
		return int_validHeight;
	}

	/**
	 * @return the intValidstartx
	 */
	public static Integer getIntValidstartx() {
		return int_validStartX;
	}

	/**
	 * @return the intValidsidelength
	 */
	public static Integer getIntValidsidelength() {
		return int_validSideLength;
	}

	/**
	 * @return the intValidsinglelength
	 */
	public static Integer getIntValidsinglelength() {
		return int_validSingleLength;
	}

}
