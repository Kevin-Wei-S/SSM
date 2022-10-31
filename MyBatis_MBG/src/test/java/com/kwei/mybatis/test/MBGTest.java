package com.kwei.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kwei.mybatis.mapper.EmpMapper;
import com.kwei.mybatis.pojo.Emp;
import com.kwei.mybatis.pojo.EmpExample;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class MBGTest {

	@Test
	public void testMBGDeleteByExample() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = ss.getMapper(EmpMapper.class);
//		mapper.deleteByPrimaryKey(36);
		EmpExample ee = new EmpExample();
		ee.createCriteria().andEmpIdIn(List.of(35, 37));
		mapper.deleteByExample(ee);
		
	}
	
	@Test
	public void testMBGInsertSelective() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = ss.getMapper(EmpMapper.class);
		// 0 null 0 null 0
		mapper.insertSelective(new Emp(null,"iS", null, null, null));
		
	}
	
	@Test
	public void testMBGUpdateByExampleSelective() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = ss.getMapper(EmpMapper.class);
		// 一般修改
		Emp emp = new Emp(34, "小李探花", 28, "M", null);
		mapper.updateByPrimaryKeySelective(emp);
		// 條件修改
//		Emp emp = new Emp(null, "尋歡的李尋歡", 35, "M", 0);
//		EmpExample ee = new EmpExample();
//		ee.createCriteria().andEmpNameEqualTo("尋歡的李尋歡").andGenderEqualTo("M");
//		mapper.updateByExampleSelective(emp, ee);
		
	}
	
	@Test
	public void testMBGSelectByExample() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = ss.getMapper(EmpMapper.class);
		// 查詢所有數據
		List<Emp> list = mapper.selectByExample(null);
		list.forEach(System.out::println);
		
		// 根據條件EmpExample查詢數據
//		EmpExample ee = new EmpExample();
//		ee.createCriteria().andGenderEqualTo("M").andEmpNameLike("%韋%");
		// SQL-OR的使用
//		ee.or().andGenderEqualTo("F");
//		List<Emp> list = mapper.selectByExample(ee);
//		list.forEach(System.out::println);
		
	}
	
	
	@Test
	public void testMBGBySelectByPrimaryKey() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = ss.getMapper(EmpMapper.class);
		Emp emp = mapper.selectByPrimaryKey(3);
		System.out.println(emp);
		
	}
	
}
