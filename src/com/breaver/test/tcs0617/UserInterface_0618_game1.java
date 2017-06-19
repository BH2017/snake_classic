/**
 * 
 */
package com.breaver.test.tcs0617;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.breaver.formal.button.ButtonBack;
import com.breaver.formal.button.ButtonStart;
import com.breaver.formal.config.ConstantsTCS;
import com.breaver.formal.jpanel.JPanelGame;
import com.breaver.formal.jpanel.JPanelHelp;
import com.breaver.formal.jpanel.JPanelMenu;
import com.breaver.formal.jpanel.JPanelRankList;
import com.breaver.formal.jpanel.JPanelSetup;

/**
 * @author zzf--主要目的就是用硬数据实现游戏操作----
 *@date 2017年6月18日 下午10:39:49
 */
public class UserInterface_0618_game1 extends JFrame {
	
	/**
	 * 清除多余警告--有利于编码的不冗余，从侧面保证代码简洁，一般简洁就意味着高效
	 */
	private static final long serialVersionUID = -4197985112997095921L;
	private JPanel panelFirst = new JPanel();
	private JPanelGame game = new JPanelGame();
	private JPanelMenu menu = new JPanelMenu();
	private JPanelSetup setup = new JPanelSetup();
	private JPanelHelp help = new JPanelHelp();
	private JPanelRankList rankList = new JPanelRankList();
	private CardLayout cardLayout = new CardLayout();
	private ArrayList<JPanel> listJPanelCardlayout=new ArrayList<>();
	//
	private ButtonStart buttonStart_start = new ButtonStart("开始游戏");
	private ButtonStart buttonStart_setup = new ButtonStart("设置");
	private ButtonStart buttonStart_help  =new ButtonStart("帮助");
	private ButtonStart buttonStart_ranklist = new ButtonStart("排行");
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface_0618_game1 game1 = new UserInterface_0618_game1();
	}
	//-------------------step3_2_5------------ranklist--------
	public void configChildRankList(){
		
	}
	//-------------------step3_2_4------------help---------
	public void configChildHelp(){
		
	}
	//-------------------step3_2_3-----------setup-------
	public void configChildSetup(){
		
	}
	//--------------------step3_2_2-----------game-------
	public void configChildGame(){
		
	}
	//开始配置不同项---------step3_2--------------------------
	//--------------------step3_2_1-----------menu-------------
	public void configChildMenu(){
		menu.setLayout(null);
		menu.add(buttonStart_ranklist);
		menu.add(buttonStart_setup);
		menu.add(buttonStart_start);
		menu.add(buttonStart_help);
		ArrayList<ButtonStart> arrayList = new ArrayList<>();
		arrayList.add(buttonStart_help);
		arrayList.add(buttonStart_ranklist);
		arrayList.add(buttonStart_setup);
		arrayList.add(buttonStart_start);
		int i=50;
		for(ButtonStart buttonStart:arrayList){
			buttonStart.setBounds((800-100)/2,
				i, 100,50);
			i+=100;
		}
		//给按钮---响应事件----------------------
		buttonStart_help.addActionListener(event->{
			cardLayout.show(panelFirst, "id_help");
		});
		buttonStart_ranklist.addActionListener(event->{
			cardLayout.show(panelFirst, "id_ranklist");
		});
		buttonStart_setup.addActionListener(event->{
			cardLayout.show(panelFirst, "id_setup");
		});
		buttonStart_start.addActionListener(event->{
			cardLayout.show(panelFirst, "id_game");
		});
	}
	//------------------step3_1---------------------
	public void configEveryPageCommonOptions(){
		//----返回按钮----------------
		for(JPanel jPanel:listJPanelCardlayout){
			if(jPanel == menu)
				continue;
			jPanel.setLayout(null);
			ButtonBack back=new ButtonBack("返回");
			jPanel.add(back);
			back.setBounds(ConstantsTCS.getDemoUnique().getInt_windowWidth() - 100,
					0, 95, 50);
			back.addActionListener(event->{
				cardLayout.show(panelFirst, "id_menu");
			});
		}
	}
	//-------------------step2-----------------
	public void init(){
		this.add(panelFirst);
		panelFirst.setLayout(cardLayout);
		panelFirst.add(game, "id_game");
		panelFirst.add(menu, "id_menu");
		panelFirst.add(help, "id_help");
		panelFirst.add(rankList, "id_ranklist");
		panelFirst.add(setup, "id_setup");
		//------把这些面板加入---数组---------------------
		listJPanelCardlayout.add(game);
		listJPanelCardlayout.add(help);
		listJPanelCardlayout.add(menu);
		listJPanelCardlayout.add(setup);
		listJPanelCardlayout.add(rankList);
		//布置每个转换页----------------step3-------------
		configEveryPageCommonOptions();
		configChildMenu();
		
	}
	//设置基本JFrame层-----------step1---------------
	public UserInterface_0618_game1() {
		// TODO Auto-generated constructor stub
		this.setSize(new Dimension(ConstantsTCS.getDemoUnique().getInt_windowWidth(),
				ConstantsTCS.getDemoUnique().getInt_windowHeight()));
		this.setTitle(ConstantsTCS.getDemoUnique().getStr_windowTitle());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		init();
		this.setVisible(true);
	}
	/**
	 * @return the panelFirst
	 */
	protected JPanel getPanelFirst() {
		return panelFirst;
	}
	/**
	 * @param panelFirst the panelFirst to set
	 */
	protected void setPanelFirst(JPanel panelFirst) {
		this.panelFirst = panelFirst;
	}
	/**
	 * @return the game
	 */
	protected JPanelGame getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	protected void setGame(JPanelGame game) {
		this.game = game;
	}
	/**
	 * @return the menu
	 */
	protected JPanelMenu getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	protected void setMenu(JPanelMenu menu) {
		this.menu = menu;
	}
	/**
	 * @return the setup
	 */
	protected JPanelSetup getSetup() {
		return setup;
	}
	/**
	 * @param setup the setup to set
	 */
	protected void setSetup(JPanelSetup setup) {
		this.setup = setup;
	}
	/**
	 * @return the help
	 */
	protected JPanelHelp getHelp() {
		return help;
	}
	/**
	 * @param help the help to set
	 */
	protected void setHelp(JPanelHelp help) {
		this.help = help;
	}
	/**
	 * @return the rankList
	 */
	protected JPanelRankList getRankList() {
		return rankList;
	}
	/**
	 * @param rankList the rankList to set
	 */
	protected void setRankList(JPanelRankList rankList) {
		this.rankList = rankList;
	}
	/**
	 * @return the cardLayout
	 */
	protected CardLayout getCardLayout() {
		return cardLayout;
	}
	/**
	 * @param cardLayout the cardLayout to set
	 */
	protected void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	/**
	 * @return the buttonStart_start
	 */
	protected ButtonStart getButtonStart_start() {
		return buttonStart_start;
	}
	/**
	 * @param buttonStart_start the buttonStart_start to set
	 */
	protected void setButtonStart_start(ButtonStart buttonStart_start) {
		this.buttonStart_start = buttonStart_start;
	}
	/**
	 * @return the buttonStart_setup
	 */
	protected ButtonStart getButtonStart_setup() {
		return buttonStart_setup;
	}
	/**
	 * @param buttonStart_setup the buttonStart_setup to set
	 */
	protected void setButtonStart_setup(ButtonStart buttonStart_setup) {
		this.buttonStart_setup = buttonStart_setup;
	}
	/**
	 * @return the buttonStart_help
	 */
	protected ButtonStart getButtonStart_help() {
		return buttonStart_help;
	}
	/**
	 * @param buttonStart_help the buttonStart_help to set
	 */
	protected void setButtonStart_help(ButtonStart buttonStart_help) {
		this.buttonStart_help = buttonStart_help;
	}
	/**
	 * @return the buttonStart_ranklist
	 */
	protected ButtonStart getButtonStart_ranklist() {
		return buttonStart_ranklist;
	}
	/**
	 * @param buttonStart_ranklist the buttonStart_ranklist to set
	 */
	protected void setButtonStart_ranklist(ButtonStart buttonStart_ranklist) {
		this.buttonStart_ranklist = buttonStart_ranklist;
	}
	
}
