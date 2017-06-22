/**
 * 
 */
package com.breaver.test.random;

/**
 * @author zzf
 *@date 2017年6月22日 下午7:53:35
 */
public class TestRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.print(" "+(int)(Math.random()*4));
			if((i+1)%10 == 0)
				System.out.println("");
		}
	}

}
