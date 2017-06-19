/**
 * 
 */
package com.breaver.formal.bean;

import java.awt.Point;
import java.util.ArrayList;

import com.breaver.formal.enums.DirectionEnum;
import com.breaver.formal.jpanel.JPanelGame;

/**
 * @author zzf
 *@date 2017年6月17日 下午9:08:11
 */
public class Snake {
	private ArrayList<Point> listBody=null;
	private final Integer int_center = JPanelGame.int_validSideLength/2;
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	public void createOne
	public Snake() {
		super();
		// TODO Auto-generated constructor stub
		listBody = new ArrayList<>();
		test_Init();
	}
	public void moveForward(){
		//index1和0判断移动方式
	}
	public void test_dynamicImage(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					Thread.sleep(1000);
					for(Point point:listBody)
						point.y=point.y+1;
				}catch(InterruptedException exception){
					exception.printStackTrace();
				}
			}
		}).start();
	}
	//这个方法，自我判断方向，并前进一格
	public void goFrowardOneStep(){
		//使用--头节点和第二节点----
		Point head = listBody.get(0);
		Point second = listBody.get(1);
		//---direction----------------1------------------
		
		////不拐歪的-----一条线----
		DirectionEnum directionEnum = DirectionEnum.SOUTH_direction;
		if(head.getX() == second.getX()){//
			if(head.getY() > second.getY()){
				directionEnum = DirectionEnum.SOUTH_direction;
			}
			else if(head.getY() < second.getY()){
				directionEnum = DirectionEnum.NORTH_direction;
			}
			else{
				System.out.println("坐标错误。。");
			}
		}
		if(head.getY() == second.getY()){
			if(head.getX() > second.getX()){
				directionEnum = DirectionEnum.EAST_direction;
			}else if(head.getX() < second.getX()){
				directionEnum=DirectionEnum.WEST_direction;
			}else{
				System.out.println("坐标错误");
			}
		}
		//x1!=x2,y1!=y2;不存在这种
		
	}
	public void moveForward(Point point_front){
		Point pointTemp = new Point();
		
		for(Point point:listBody){
			pointTemp.x=point.x;
			pointTemp.y=point.y;
			point.x=point_front.x;
			point.y=point_front.y;
			point_front.x=point.x;
			point_front.y=point.y;
		}
	}
	private void test_Init(){
		listBody.add(new Point(int_center, int_center));
		listBody.add(new Point(int_center+1, int_center));
		listBody.add(new Point(int_center+2, int_center));
		listBody.add(new Point(int_center+3, int_center));
	}
	/**
	 * @return the listBody
	 */
	public ArrayList<Point> getListBody() {
		return listBody;
	}
	/**
	 * @param listBody the listBody to set
	 */
	/*public void setListBody(ArrayList<Point> listBody) {
		this.listBody = listBody;
	}*/
	
}
