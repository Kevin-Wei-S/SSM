package com.kwei.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kwei.mybatis.mapper.CacheMapper;
import com.kwei.mybatis.pojo.Emp;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class CacheMapperTest {

	/**
	 *  MyBatis的一級緩存(預設):
	 *  	MyBatis的一級緩存是SqlSession級別的, 
	 *      即通過同一個SqlSession查詢的數據會被緩存.
	 *      如相同SQL語句再次被執行, 則會直接從一級緩存中獲取數據. 
	 *      使一級緩存失效的四種情況:
	 *      	1. 不同SqlSession
	 *      	2. 同一個SqlSession, 但不同SQL語句.
	 *      	3. 同一個SqlSession, 中間經過SQL增、刪、改後, 會將一級緩存清空.
	 *      	4. 同一個SqlSession, 手動清除一級緩存.
	 *      
	 *  MyBatis的二級緩存:
	 *  	MyBatis的二級緩存是SqlSessionFactory級別
	 *  	即通過同一個SqlSessionFactory所創建的不同SqlSession,
	 *  	如相同SQL語句再次被執行, 會從二級緩存中直接獲取數據.
	 *		二級緩存開啟的條件:
	 *			1. 在核心配置文件中, 設置全局配置屬性cacheEnabled="true", 默認為true, 不須配置.
	 *			2. 在映射文件中設置標籤<cache />
	 *			3. 二級緩存必須在SqlSession關閉或提交後生效
	 *			4. 查詢數據轉換後的實體類必須實現序列化接口
	 *      二級緩存失效的情況:
	 *      	在SqlSession反射代理實現類調用兩次SQL語句間, 
	 *      	如有執行SQL增、刪、改, 會自動清除包含一級、二級的緩存.
	 */
	
	@Test
	public void testCache() {
		
		try(InputStream is = Resources.getResourceAsStream("mybatis_config.xml")) 
		{
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			SqlSession ss1 = ssf.openSession(true);
			SqlSession ss2 = ssf.openSession(true);
			
			CacheMapper mapper1 = ss1.getMapper(CacheMapper.class);
			Emp emp1 = mapper1.getEmpByEmpId(3);
			System.out.println(emp1);
			// SqlSession除非關閉或手動提交, 否則數據僅緩存在SqlSession一級緩存
			// 如關閉或提交, 則數據進入SqlSessionFactory二級緩存.
			ss1.close();
			
			CacheMapper mapper2 = ss2.getMapper(CacheMapper.class);
//			mapper2.insertEmp(new Emp(null, "李尋歡", 32, "M"));
			Emp emp2 = mapper2.getEmpByEmpId(3);
			System.out.println(emp2);
			ss2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testGetEmpByEmpId() {
		
		SqlSession ss1 = SqlSessionUtil.getSqlSession();
		CacheMapper mapper1 = ss1.getMapper(CacheMapper.class);
		Emp emp1 = mapper1.getEmpByEmpId(3);
		System.out.println(emp1);

//		mapper1.insertEmp(new Emp(null, "小蝦米", 18, "M"));
//		ss1.clearCache();
		
//		Emp emp2 = mapper1.getEmpByEmpId(3);
//		System.out.println(emp2);
		
		SqlSession ss2 = SqlSessionUtil.getSqlSession();
		CacheMapper mapper2 = ss2.getMapper(CacheMapper.class);	
		Emp emp3 = mapper2.getEmpByEmpId(3);
		System.out.println(emp3);
		
	}
	
	@Test
	public void test1() {
		
	}
	
}
