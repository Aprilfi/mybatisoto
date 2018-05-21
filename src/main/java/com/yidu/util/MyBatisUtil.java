package com.yidu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 * 
 * @author sinner
 */
public class MyBatisUtil {
	/**
	 * 提供一个获取SqlSession的方法
	 * @return SqlSession对象
	 */
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
	
	/**
	 * 获得会话工厂对象
	 * @return 会话工厂对象
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		// 1.主配置文件的位置字符串
		String resFile = "config/mybatis/SqlMapConfig.xml";
		// 2.定义输入流
		InputStream in = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			in = Resources.getResourceAsStream(resFile);
			// 先创建sqlSession工厂类对象
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
	
}
