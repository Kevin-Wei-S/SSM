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
		// �@��ק�
		Emp emp = new Emp(34, "�p������", 28, "M", null);
		mapper.updateByPrimaryKeySelective(emp);
		// ����ק�
//		Emp emp = new Emp(null, "�M�w�����M�w", 35, "M", 0);
//		EmpExample ee = new EmpExample();
//		ee.createCriteria().andEmpNameEqualTo("�M�w�����M�w").andGenderEqualTo("M");
//		mapper.updateByExampleSelective(emp, ee);
		
	}
	
	@Test
	public void testMBGSelectByExample() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = ss.getMapper(EmpMapper.class);
		// �d�ߩҦ��ƾ�
		List<Emp> list = mapper.selectByExample(null);
		list.forEach(System.out::println);
		
		// �ھڱ���EmpExample�d�߼ƾ�
//		EmpExample ee = new EmpExample();
//		ee.createCriteria().andGenderEqualTo("M").andEmpNameLike("%��%");
		// SQL-OR���ϥ�
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
