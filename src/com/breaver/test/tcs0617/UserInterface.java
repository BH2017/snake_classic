/**
 * 
 */
package com.breaver.test.tcs0617;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.breaver.formal.config.ConstantsTCS;
import com.breaver.formal.jpanel.JPanelGame;

/**
 * @author zzf
 * @date 2017��6��17�� ����1:54:02
 */
public class UserInterface extends JFrame {

	private ConstantsTCS constantsTCS = new ConstantsTCS();
	private JPanel jPanelFirst = new JPanel();
	private JPanelGame jPanelGame = new JPanelGame();
	private JPanel jPanelMenu = new JPanel();
	private JPanel jPanelOthers = new JPanel();
	private JPanel jPanelHelp = new JPanel();
	private JPanel jPanelSetUp = new JPanel();
	private JTextField area; 
//	private JPan
	private CardLayout cardLayout1 = new CardLayout();
	private CardLayout cardLayout2 = new CardLayout();
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface interface1 = new UserInterface();
		
	}

	public UserInterface() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		this.setTitle(constantsTCS.getStr_windowTitle());
		this.setSize(new Dimension(constantsTCS.getInt_windowWidth(), constantsTCS.getInt_windowHeight()));
		this.setMaximumSize(new Dimension(constantsTCS.getInt_windowWidth(), constantsTCS.getInt_windowHeight()));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �����ʼ������------------------
		this.add(jPanelFirst);
		this.jPanelFirst.setLayout(cardLayout1);
		// cardLayout1.addLayoutComponent("", comp);
		jPanelFirst.add(jPanelGame, "game");
		jPanelFirst.add(jPanelMenu, "menu");
		jPanelFirst.add(jPanelOthers, "others");
		cardLayout1.show(jPanelFirst, "menu");
		jPanelMenu.add(new JLabel("menu"));
		JButton jbtn1 = new JButton("��ʼ��Ϸ");
		jPanelMenu.add(jbtn1);
		jbtn1.addActionListener(event -> {
			cardLayout1.show(jPanelFirst, "game");
		});
		JButton button2 = new JButton("�����˵�");
		jPanelMenu.add(button2);
		button2.addActionListener(event -> {
			cardLayout1.show(jPanelFirst, "others");
		});
		/*jPanelGame.add(new JLabel("game"));
		JButton button3 = new JButton("�������˵�");
		jPanelGame.add(button3);
		button3.addActionListener(event->{
			cardLayout1.show(jPanelFirst, "menu");
		});*/
		/*jPanelOthers.add(new JLabel("��������"));
		JButton button4 = new JButton("����");
		button4.addActionListener(event->{
			cardLayout1.show(jPanelFirst, "menu");
		});
		jPanelOthers.add(button4);
//		JTextArea area = new JTextArea();
		area = new JTextField(10);
		JButton button5 = new JButton("���Կ�Ƭ�Ƿ񱣴�״̬");
		button5.addActionListener(event->{
//			jPanelOthers.invalidate();//ʹ��Ч
			jPanelOthers.add(new JLabel(area.getText()));
//			jPanelOthers.repaint();
			jPanelOthers.revalidate();
		});
		jPanelOthers.add(button5);
		jPanelOthers.add(area);*/
		jPanelOthers.setLayout(cardLayout2);
		jPanelOthers.add(jPanelSetUp, "setup");
		jPanelOthers.add(jPanelHelp,"help");
		jPanelHelp.add(new JLabel("help"));
		jPanelSetUp.add(new JLabel("set-up"));
		JButton comp6 = new JButton("����");
		jPanelSetUp.add(comp6);
		JButton button6 = new JButton("����");
		jPanelHelp.add(button6);
		comp6.addActionListener(event->{
			cardLayout1.show(jPanelFirst, "menu");
		});
		button6.addActionListener(event->{
			cardLayout1.show(jPanelFirst, "menu");
		});
		JButton button7 = new JButton("������");
		jPanelSetUp.add(button7);
		button7.addActionListener(event->{
			cardLayout2.show(jPanelOthers, "help");
		});
		JTextField field = new JTextField(20);
		jPanelHelp.add(field);
//		jPanelHelp  = new JPanel();
		//����Ϸ������Ӧ
		jPanelGame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��-����---��"+e.getKeyCode());
			}
		});
		//----test--key----pressed-----
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���弶----key");
				
			}
		});
		this.getContentPane().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("JFrame����һ");
			}
		});
		jPanelFirst.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("menu�ĸ���");
			}
		});
		jPanelOthers.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("help�ĸ���");
			}
		});
		jPanelHelp.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��-����---��"+e.getKeyCode());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jPanelSetUp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				System.out.println("��-����---��"+e.getKeyCode());
			}
		});
		// ������ʾ����-------------------------
		this.setVisible(true);
	}

}
