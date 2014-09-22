package com.gofaner.game.lswht.dao;

import com.gofaner.game.lswht.model.ExchangeCode;
import com.gofaner.game.lswht.model.ExchangeCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExchangeCodeMapper {
    int countByExample(ExchangeCodeExample example);

    int deleteByExample(ExchangeCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeCode record);

    int insertSelective(ExchangeCode record);

    List<ExchangeCode> selectByExampleWithRowbounds(ExchangeCodeExample example, RowBounds rowBounds);

    List<ExchangeCode> selectByExample(ExchangeCodeExample example);

    ExchangeCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExchangeCode record, @Param("example") ExchangeCodeExample example);

    int updateByExample(@Param("record") ExchangeCode record, @Param("example") ExchangeCodeExample example);

    int updateByPrimaryKeySelective(ExchangeCode record);

    int updateByPrimaryKey(ExchangeCode record);
    
    ExchangeCode getUniqueCode(@Param("codeType")Integer codeType, @Param("status")int status);

	Integer getCountByOwnerIPForUpdate(@Param("ownerIP")String ownerIP);
}