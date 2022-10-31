package com.kwei.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwei.mybatis.mapper.EmpMapper;
import com.kwei.mybatis.pojo.Emp;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class PageTest {
	/**
	 * PageInfo{			  //����ܹ�ڤ��
	 * pageNum=5, pageSize=2, size=2, 
	 * startRow=9, endRow=10, total=16, 
	 * pages=8, list=Page{count=true, pageNum=5, 
	 * pageSize=2, startRow=8, endRow=10, 
	 * total=16, pages=8, reasonable=false, 
	 * pageSizeZero=false}
	 * [Emp [empId=9, empName=���t, age=18, gender=M, deptId=6], 
	 *  Emp [empId=10, empName=���T, age=15, gender=F, deptId=6]], 
	 * prePage=4, nextPage=6, isFirstPage=false, 
	 * isLastPage=false, hasPreviousPage=true, hasNextPage=true, 
	 * navigatePages=6, navigateFirstPage=2, navigateLastPage=7, 
	 * navigatepageNums=[2, 3, 4, 5, 6, 7]}
	 * 
	 */
	@Test
	public void testPage() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmpMapper mapper = ss.getMapper(EmpMapper.class);
		// �d�ߥ\�ध�e�}�Ҥ����\��
		Page<Object> page = PageHelper.startPage(1, 2);
		List<Emp> list = mapper.selectByExample(null);
		// �b�d�ߥ\���i�H��������������Ҧ��ƾ�
		PageInfo<Emp> pageInfo = new PageInfo<>(list, 6);
		System.out.println(pageInfo);
//		page.forEach(System.out::println);
//		System.out.println(page); 
	}
	
}
