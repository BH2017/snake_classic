/**
 * 
 */
package com.breaver.formal.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.util.Iterator;
import java.util.Properties;

/**
 * @author zzf
 * @date 2017��6��17�� ����2:25:35
 */
public class ConstantsTCS {
	private final Integer int_windowWidth;
	private final Integer int_windowHeight;
	private final String str_windowTitle;
	private final Integer int_areaWidth;
	private final String v_defaultString = "�Ҳ���ֵ";
	private final Integer v_defaultInteger = 100;
	// ====================================
	private Properties properties = null;
	private InputStream inputStream = null;
	//��ҪĿ���ǳ��������ڼ�ֻ��ȡһ��----����
	private final static ConstantsTCS demoUnique = new ConstantsTCS();
	// private Iterator<String> iterator = null;
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @return the demoUnique
	 */
	public static ConstantsTCS getDemoUnique() {
		return demoUnique;
	}

	public ConstantsTCS() {
		super();
		// TODO Auto-generated constructor stub
		String v_windowTtitle = v_defaultString;
		Integer v_windowWidth = v_defaultInteger;
		Integer v_windowHeight = v_defaultInteger;
		Integer v_areaWidth = v_defaultInteger;
		properties = new Properties();
		try {
			inputStream = new BufferedInputStream(new FileInputStream("src/constants.properties"));
			//�����������
			
			properties.load(new InputStreamReader(inputStream, "UTF-8"));
			// --------------------------��ֵ��--------��-------
			v_windowTtitle = properties.getProperty("window_title");
			v_windowHeight = Integer.parseInt(properties.getProperty("window_height"));
			v_windowWidth=Integer.parseInt(properties.getProperty("window_width"));
			v_areaWidth = Integer.parseInt(properties.getProperty("area_width"));
			// -------------------------��ֵ��--------��---------
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {// �����м����ͻ���������-----------------
			str_windowTitle = v_windowTtitle;
			int_windowHeight = v_windowHeight;
			int_windowWidth = v_windowWidth;
			int_areaWidth = v_areaWidth;
		}
		// ����������ܴ����ļ�----����������---��ֵ����
		// str_windowTitle = properties.getProperty("window_title");
		// str_windowTitle
	}
	
	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return the int_areaWidth
	 */
	public Integer getInt_areaWidth() {
		return int_areaWidth;
	}

	/**
	 * @return the v_defaultString
	 */
	public String getV_defaultString() {
		return v_defaultString;
	}

	/**
	 * @return the v_defaultInteger
	 */
	public Integer getV_defaultInteger() {
		return v_defaultInteger;
	}

	/**
	 * @return the demounique
	 */
	public static ConstantsTCS getDemounique() {
		return demoUnique;
	}

	public Integer getInt_windowWidth() {
		return int_windowWidth;
	}

	public Integer getInt_windowHeight() {
		return int_windowHeight;
	}

	public String getStr_windowTitle() {
		return str_windowTitle;
	}

}
