/**
 * 
 */
package com.breaver.formal.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

/**
 * @author zzf
 *@date 2017年6月18日 下午3:47:11
 */
public class ButtonStart extends JButton {
	private Graphics2D graphics2d;
	private Shape shape;
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ButtonStart(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.setContentAreaFilled(false);
		this.setForeground(Color.BLUE);
		this.setBackground(Color.DARK_GRAY);
	}
	@Override
	protected void paintChildren(Graphics g) {
		// TODO Auto-generated method stub
		super.paintChildren(g);
		graphics2d  = (Graphics2D)g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(this.getModel().isArmed())
			graphics2d.setColor(Color.BLACK);
		else
			graphics2d.setColor(Color.GREEN);
		graphics2d.fillOval(0, 0, getWidth()-1, getHeight()-1);
		super.paintComponent(graphics2d);
	}
	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
//		super.paintBorder(g);
		graphics2d = (Graphics2D)g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
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
