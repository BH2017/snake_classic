/**
 * 
 */
package com.breaver.formal.jpanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * @author zzf
 *@date 2017年6月17日 下午3:47:41
 */
public class JPanelMenu extends JPanel {
	private Graphics2D graphics2d = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		graphics2d=(Graphics2D)g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
//		graphics2d.drawString("menu", 0, 60);
		
	}
}
