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
	 *  MyBatis���@�Žw�s(�w�]):
	 *  	MyBatis���@�Žw�s�OSqlSession�ŧO��, 
	 *      �Y�q�L�P�@��SqlSession�d�ߪ��ƾڷ|�Q�w�s.
	 *      �p�ۦPSQL�y�y�A���Q����, �h�|�����q�@�Žw�s������ƾ�. 
	 *      �Ϥ@�Žw�s���Ī��|�ر��p:
	 *      	1. ���PSqlSession
	 *      	2. �P�@��SqlSession, �����PSQL�y�y.
	 *      	3. �P�@��SqlSession, �����g�LSQL�W�B�R�B���, �|�N�@�Žw�s�M��.
	 *      	4. �P�@��SqlSession, ��ʲM���@�Žw�s.
	 *      
	 *  MyBatis���G�Žw�s:
	 *  	MyBatis���G�Žw�s�OSqlSessionFactory�ŧO
	 *  	�Y�q�L�P�@��SqlSessionFactory�ҳЫت����PSqlSession,
	 *  	�p�ۦPSQL�y�y�A���Q����, �|�q�G�Žw�s����������ƾ�.
	 *		�G�Žw�s�}�Ҫ�����:
	 *			1. �b�֤߰t�m���, �]�m�����t�m�ݩ�cacheEnabled="true", �q�{��true, �����t�m.
	 *			2. �b�M�g��󤤳]�m����<cache />
	 *			3. �G�Žw�s�����bSqlSession�����δ����ͮ�
	 *			4. �d�߼ƾ��ഫ�᪺������������{�ǦC�Ʊ��f
	 *      �G�Žw�s���Ī����p:
	 *      	�bSqlSession�Ϯg�N�z��{���եΨ⦸SQL�y�y��, 
	 *      	�p������SQL�W�B�R�B��, �|�۰ʲM���]�t�@�šB�G�Ū��w�s.
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
			// SqlSession���D�����Τ�ʴ���, �_�h�ƾڶȽw�s�bSqlSession�@�Žw�s
			// �p�����δ���, �h�ƾڶi�JSqlSessionFactory�G�Žw�s.
			ss1.close();
			
			CacheMapper mapper2 = ss2.getMapper(CacheMapper.class);
//			mapper2.insertEmp(new Emp(null, "���M�w", 32, "M"));
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

//		mapper1.insertEmp(new Emp(null, "�p����", 18, "M"));
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
