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
 *@date 2017��6��17�� ����2:03:30
 */
/**
 * @author zzf
 *@date 2017��6��17�� ����4:56:25
 */
public class ValueAdvance {
	private final String str1;
	/**
	 * @param args
	 */
	static{
//		str1="";�����ھ�̬���и�ֵ
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ValueAdvance();
	}
	public ValueAdvance() {
		super();
		// TODO Auto-generated constructor stub
		this.str1="s";//������г��������ڹ��캯��������
		Properties properties = new Properties();
		try{
			InputStream inputStream = 
					new BufferedInputStream(
							new FileInputStream("src/test_properties.properties"));
			properties.load(inputStream);
			Iterator<String>  iterator = 
					properties.stringPropertyNames().iterator();
			while(iterator.hasNext()){
				System.out.println("�У���");
				iterator.next();
			}
			//get��ȡ
			System.out.println("name==:"+properties.getProperty("name"));
			inputStream.close();//д�벿��---��β��ע��
		}catch (Exception exception) {
			// TODO: handle exception
			exception.printStackTrace();
		}
	}
	public void testFinalAssignment(){
//		str1="2";//��������ͨmethod��ֵ
	}
}
/*///�������Ե�b.properties�ļ�----��ַ��http://www.cnblogs.com/xudong-bupt/p/3758136.html
23             FileOutputStream oFile = new FileOutputStream("b.properties", true);//true��ʾ׷�Ӵ�
24             prop.setProperty("phone", "10086");
25             prop.store(oFile, "The New properties file");
26             oFile.close();
27         }
28         catch(Exception e){
29             System.out.println(e);
30         }
*/