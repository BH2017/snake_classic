/**
 * 
 */
package com.breaver.test.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author zzf
 *@date 2017年6月17日 下午2:03:30
 */
/**
 * @author zzf
 *@date 2017年6月17日 下午4:56:25
 */
public class ValueAdvance {
	private final String str1;
	/**
	 * @param args
	 */
	static{
//		str1="";不能在静态块中赋值
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ValueAdvance();
	}
	public ValueAdvance() {
		super();
		// TODO Auto-generated constructor stub
		this.str1="s";//这个类中常量可以在构造函数中声明
		Properties properties = new Properties();
		try{
			InputStream inputStream = 
					new BufferedInputStream(
							new FileInputStream("src/test_properties.properties"));
			properties.load(inputStream);
			Iterator<String>  iterator = 
					properties.stringPropertyNames().iterator();
			while(iterator.hasNext()){
				System.out.println("有：：");
				iterator.next();
			}
			//get读取
			System.out.println("name==:"+properties.getProperty("name"));
			inputStream.close();//写入部分---见尾部注释
		}catch (Exception exception) {
			// TODO: handle exception
			exception.printStackTrace();
		}
	}
	public void testFinalAssignment(){
//		str1="2";//不能在普通method赋值
	}
}
/*///保存属性到b.properties文件----地址：http://www.cnblogs.com/xudong-bupt/p/3758136.html
23             FileOutputStream oFile = new FileOutputStream("b.properties", true);//true表示追加打开
24             prop.setProperty("phone", "10086");
25             prop.store(oFile, "The New properties file");
26             oFile.close();
27         }
28         catch(Exception e){
29             System.out.println(e);
30         }
*/