/**
 * 
 */
package com.breaver.test.keyevent;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * @author zzf
 *@date 2017年6月17日 下午5:40:10
 */
public class KeyEventLis extends JFrame {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyEventLis();
	}

	public KeyEventLis() {
		super();
		// TODO Auto-generated constructor stub
		this.setSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("你-按下---："+e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("你-按下---："+e.getKeyCode());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("你-按下---："+e.getKeyCode());
			}
		});
		this.setVisible(true);
	}

	public KeyEventLis(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public KeyEventLis(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public KeyEventLis(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
