package com.kwei.mybatis.mapper;

import com.kwei.mybatis.pojo.Emp;
import com.kwei.mybatis.pojo.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Emp record);

    // insertSelective(...): �p�ѼƦ�null, ���N�w�ק�Ƚ�Ȭ�null,
    //						 �Y�����. MySQL�|�ϥΨ�column�������q�{�w�]��.
    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empId);

    // �ھڱ����ܩʭק�
    // updateByExampleSelective(...): �p�ѼƦ�null, ���N�w�ק�Ƚ�Ȭ�null,
    // 								  �Y�����.
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);
    
    // updateByExample(...): �p�ѼƦ�null, �����N�w�ק�Ƚ�Ȭ�null.
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}