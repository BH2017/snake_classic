/**
 * 
 */
package com.breaver.test.costom.button;
import java.awt.Color;
/*import <a href="http://lib.csdn.net/base/java" 
class='replace_word' 
title="Java 知识库" 
target='_blank' 
style='color:#df3434; font-weight:bold;'>
Java</a>.awt.Color;*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JComponent;


/**
 * 带有放射性颜色过滤效果的椭圆按钮的简单实现
 * 默认是三种颜色的渐变，最少要设定三种颜色
 * 
 * @author sunsnowad
 * @date 2009-7-29
 */
public class JRadialEllipseButton extends JComponent{
	private static final Color[] DEFAULT_RADIO_COLORS = 
		{Color.ORANGE, Color.PINK, Color.GREEN};//默认放射颜色
	private static final float[] DEFAULT_DISTANCE_COLORS = 
		{0.0f, 0.6f, 1.0f};//默认放射颜色间距离
	
	ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();
	
	private boolean isPressed;
	private Ellipse2D.Double region;
	private Color[] radioColors;//放射颜色
	private float[] disOfColors;//放射颜色间距离，不允许自定义
	private Color[] reversalRadioColors;//反转的放射颜色，按钮按下时显示
	private float[] reversalDisOfColors;//反转放射距离，按钮按下时显示
	private JRadialEllipseButton thisButton;//标识当前对象
	private int radius;//半径
	
	public JRadialEllipseButton(){
		isPressed = false;
		this.addMouseListener(new CustomMouseListener());
		region = new Ellipse2D.Double();
		radius = 0;
		radioColors = DEFAULT_RADIO_COLORS;
		disOfColors = DEFAULT_DISTANCE_COLORS;
		reversalRadioColors = DEFAULT_RADIO_COLORS;
		reversalDisOfColors = DEFAULT_DISTANCE_COLORS;
		thisButton = this;
		recalcuteReverse();
	}


	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		RadialGradientPaint paint;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//根据按下状态设置颜色
		if(isPressed){
			paint = new RadialGradientPaint(
						getWidth()/2,getHeight()/2, radius, disOfColors, radioColors,CycleMethod.REFLECT);
			
		}else{
			paint = new RadialGradientPaint(
						getWidth()/2,getHeight()/2, radius, reversalDisOfColors, reversalRadioColors,CycleMethod.REFLECT);
		}
		
		g2.setPaint(paint);
		g2.fill(new Ellipse2D.Double(0.0, 0.0, region.width, region.height));
	}
	
	/**
	 * 设置放射按钮的放射颜色
	 * @param c
	 */
	public void setRadioColor(Color[] c ){
		if(c.length < 3){
			System.err.println("颜色值设置的书目太少，程序修改为默认状态");
			radioColors = DEFAULT_RADIO_COLORS;
			disOfColors = DEFAULT_DISTANCE_COLORS;
		}
		radioColors = c;
		recalculateDist();
		recalcuteReverse();
		if(isShowing())
			repaint();
	}
	/**
	 * 设置放射颜色为默认值
	 */
	public void setDefaultColor(){
		radioColors = DEFAULT_RADIO_COLORS;
		disOfColors = DEFAULT_DISTANCE_COLORS;
		recalcuteReverse();
		if(isShowing())
			repaint();
	}
	/**
	 * 重新计算放射颜色的距离
	 */
	private void recalculateDist(){
		int numOfRadioColors = radioColors.length;
		if(numOfRadioColors < 3){
			System.err.println("颜色值设置的书目太少，不应小于3");
			radioColors = DEFAULT_RADIO_COLORS;
			disOfColors = DEFAULT_DISTANCE_COLORS;
			return;
		}
		disOfColors = new float[numOfRadioColors];
		for(int i = 0; i < numOfRadioColors; i ++){
			disOfColors[i] = i*1.0f/numOfRadioColors;
		}
		disOfColors[0] = 0.0f;
		disOfColors[numOfRadioColors - 1] = 1.0f;
	}
	
	/**
	 * 重新计算反转数组
	 */
	private void recalcuteReverse() {
		int length = radioColors.length;//放射颜色数目临时变量
		reversalRadioColors = new Color[length];
		reversalDisOfColors = new float[length];
		for(int i = 0; i < length; i ++){
			reversalRadioColors[i] = new Color(radioColors[length-i-1].getRGB());
			reversalDisOfColors[i] = disOfColors[i];
		}
	}


	/**
	 * 设置边界，在此方法中重新计算半径、区域等参数
	 * @see java.awt.Component.setBounds(int, int, int, int)
	 */
	@Override
	public void setBounds(int x, int y, int width, int height){
		region = new Ellipse2D.Double(x, y, width, height);
		radius = (width > height) ? width/2 : height/2;
		super.setBounds(x, y, width, height);
	}
	
	/**
	 * 设置位置
	 * @see java.awt.Component.setLocation(int,int)
	 */
	@Override
	public void setLocation(int x, int y){
		region.x = (double)x;
		region.y = (double)y;
		super.setLocation(x, y);
	}
	
	/**
	 * 设置大小，在此方法中重新计算半径、区域等参数
	 * @see java.awt.Component.setSize(int, int)
	 */
	@Override 
	public void setSize(int width, int height){
		region.width = (double)width;
		region.height = (double)height;
		radius = (int) ((region.width > region.height) ? region.width/2 : region.height/2);
		super.setSize(width, height);
	}
	
	public void addActionListener(ActionListener l){
		listeners.add(l);
	}
	
	public void removeActionListener(ActionListener l){
		listeners.remove(l);
	}
	
	public void fireActionPerformed(ActionEvent e){
		for(ActionListener l : listeners){
			l.actionPerformed(e);
		}
	}
	
	/** 
	 * @return 返回按钮的实际被绘制的区域
	 */
	public Ellipse2D getRegion(){
		return region;
	}
	
	/**
	 * @param region 按钮实际被绘制的区域
	 */
	public void setRegion(Ellipse2D.Double region){
		this.region = region;
		if(isShowing())
			repaint();
	}
	//TODO 关于相对坐标的问题解决？？
	class CustomMouseListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e){
			if(e.getButton() == MouseEvent.BUTTON1 && 
					new Ellipse2D.Double(0.0, 0.0, region.width, region.height).contains(e.getPoint())){
				isPressed = true;
				repaint();
				fireActionPerformed(new ActionEvent(thisButton, 0, null));
			}
		}
		@Override
		public void mouseReleased(MouseEvent e){
			if(e.getButton() == MouseEvent.BUTTON1 && 
					new Ellipse2D.Double(0.0, 0.0, region.width, region.height).contains(e.getPoint())){
				isPressed = false;
				repaint();
			}
		}
	}
}
