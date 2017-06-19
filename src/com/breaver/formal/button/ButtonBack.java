/**
 * 
 */
package com.breaver.formal.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

/**http://www.cnblogs.com/literature/archive/2009/07/07/gui.html
 * @author zzf
 *@date 2017年6月17日 下午7:22:25
 */
public class ButtonBack extends JButton {
	private Graphics2D graphics2d = null;
	private Shape shape = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ButtonBack(String text) {
		super(text);
		// TODO Auto-generated constructor stub
		Dimension dimension = getPreferredSize();
		dimension.width = dimension.height = (int) Math.max(dimension.width,
				dimension.getHeight());
		setPreferredSize(dimension);
		setContentAreaFilled(false);
		this.setForeground(Color.GREEN);
		this.setBackground(Color.YELLOW);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
//		super.paintComponent(g);
		graphics2d = (Graphics2D)g;
		if(getModel().isArmed()){
			graphics2d.setColor(Color.RED);
		}
		else{
			graphics2d.setColor(getBackground());
		}
		graphics2d.fillOval(0
				, 0,
				getSize().width-1,
				getSize().height-1);
		super.paintComponent(graphics2d);
		
	}
	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
//		super.paintBorder(g);
		graphics2d = (Graphics2D)g;
		graphics2d.setColor(getForeground());
		graphics2d.drawOval(0, 0, getWidth()-1, getHeight()-1);
	}
	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		if(shape == null || shape.getBounds().equals(getBounds()))
			shape = new Ellipse2D.Float(0,0,getWidth(),getHeight());
		return super.contains(x, y);
	}
}
