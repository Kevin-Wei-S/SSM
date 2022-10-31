package com.kwei.mybatis.mapper.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kwei.mybatis.mapper.DynamicSQLMapper;
import com.kwei.mybatis.pojo.Emp;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class DynamicSQLMapperTest {

	@Test
	public void testDeleteMoreEmpsByEmpIds() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper = ss.getMapper(DynamicSQLMapper.class);
		Integer[] empIds = new Integer[6];
		for(int i = 0; i <empIds.length; i++) {
			empIds[i] = 27 + i;
		}
		mapper.deleteMoreEmpsByEmpIds(empIds);
		
	}
	
	@Test
	public void testInsertMoreEmps() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper = ss.getMapper(DynamicSQLMapper.class);
		List<Emp> emps = List.of(new Emp(null, "�p����", 18, "M"), 
								 new Emp(null, "���p�G", 15, "M"), 
								 new Emp(null, "���h", 16, "F"), 
								 new Emp(null, "�c��", 25, "M"),
								 new Emp(null, "����N�h", 22, "M"),
								 new Emp(null, "�k�L", 18, "F"));
		mapper.insertMoreEmps(emps);
		
	}
	
	@Test
	public void testGetEmpByChoose() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper = ss.getMapper(DynamicSQLMapper.class);
		Emp emp = new Emp();
		emp.setAge(20);
		emp.setGender(null);
		System.out.println(emp);
		List<Emp> list = mapper.getEmpByChoose(emp);
		list.forEach(System.out::println);
		
	}	
	
	@Test
	public void  testGetEmpByConditions() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		DynamicSQLMapper mapper = ss.getMapper(DynamicSQLMapper.class);
		Emp emp = new Emp();
//		emp.setEmpName("���p�_");
//		emp.setAge(18);
//		emp.setGender("F");
		List<Emp> list = mapper.getEmpByConditions(emp);
		list.forEach(System.out::println);
		
	}
	
	@Test
	public void test1() {
		String str = "";
		str = new String("");
		System.out.println("" == str.intern());
	}
	
	@Test
	public void test2() {
		System.out.println("M".equals("M"));
	}
	
	
}
