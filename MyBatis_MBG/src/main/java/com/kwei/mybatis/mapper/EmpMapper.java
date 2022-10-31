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

    // insertSelective(...): 把计Τnull, ぃ盢箇э结null,
    //						 ぃ结. MySQL穦ㄏノㄤcolumn摸纐粄箇砞.
    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empId);

    // 沮兵ン匡拒┦э
    // updateByExampleSelective(...): 把计Τnull, ぃ盢箇э结null,
    // 								  ぃ结.
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);
    
    // updateByExample(...): 把计Τnull, 钡盢箇э结null.
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}