/**
 * 
 */
package com.breaver.test.costom.button;

/**
 * @author zzf
 *@date 2017年6月17日 下午7:14:58
 */
import java.awt.Color;
import java.awt.Container;
/*import java.awt.<a href="http://lib.csdn.net/base/docker"
class='replace_word' 
title="Docker知识库" 
target='_blank' 
style='color:#df3434; font-weight:bold;'>Container</a>;*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;



/**
 * 
 * @author sunsnowad
 * @date 2009-7-27
 */
public class JCustomButtonTest extends JFrame{
	
	public JCustomButtonTest(){
		initFrame();
	}
	/**
	 * 界面初始化
	 */
	private void initFrame() {
		Container c = getContentPane();
		setLayout(null);

		setBounds(100, 100, 500, 400);
		c.setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*JRegularStarButton jb = new JRegularStarButton();
		jb.setBounds(0, 50, 50, 50);
		
		JRegularStarButton jb2 = new JRegularStarButton();
		jb2.setBounds(100, 100, 100, 150);
		jb2.setTopColor(new Color(100,100,100,1));
		jb2.setBottomColor(new Color(255,0,255,200));
		jb2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomTask((JRegularStarButton)(e.getSource())).execute();
//				JOptionPane.showMessageDialog(null, "actionPerformed");
//				((JRegularStarButton)e.getSource()).setPressed(false);
			}
			
		});*/
		
		JRadialEllipseButton jb3 = new JRadialEllipseButton();
		jb3.setLocation(200, 150);
		jb3.setSize(110, 110);

		JRadialEllipseButton jb4 = new JRadialEllipseButton();
		jb4.setBounds(320, 100, 50, 80);
		jb4.setRadioColor(new Color[]{
				new Color(200,100,0), 
				new Color(150,200,150),
				new Color(100,150,0),
				new Color(200,255,100)});
		/*add(jb);
		add(jb2);*/
		add(jb3);
		add(jb4);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
//			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceTwilightLookAndFeel");//SubstanceRavenGraphiteLookAndFeel");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				JCustomButtonTest buttonTestFrame= new JCustomButtonTest();
				buttonTestFrame.setVisible(true);
			}
		});
	}
	

}
//TODO SwingWorker 学习需要
class CustomTask extends SwingWorker<Void, Void>{
	/*JRegularStarButton jrb;
	public CustomTask(JRegularStarButton getSource) {
		this.jrb = getSource;
	}*/

	@Override
	protected Void doInBackground() throws Exception {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, "actionPerformed");
			}
		});

	/*	jrb.setPressed(false);*/
		return null;
	}
	
}