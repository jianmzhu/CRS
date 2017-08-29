package cn.crs.reserve.dao;

import cn.crs.reserve.entity.CarTimesDtl;
import cn.crs.reserve.entity.CarTimesDtlExample;
import cn.crs.reserve.entity.CarTimesDtlKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarTimesDtlMapper {
    long countByExample(CarTimesDtlExample example);

    int deleteByExample(CarTimesDtlExample example);

    int deleteByPrimaryKey(CarTimesDtlKey key);

    int insert(CarTimesDtl record);

    int insertSelective(CarTimesDtl record);

    List<CarTimesDtl> selectByExample(CarTimesDtlExample example);

    CarTimesDtl selectByPrimaryKey(CarTimesDtlKey key);

    int updateByExampleSelective(@Param("record") CarTimesDtl record, @Param("example") CarTimesDtlExample example);

    int updateByExample(@Param("record") CarTimesDtl record, @Param("example") CarTimesDtlExample example);

    int updateByPrimaryKeySelective(CarTimesDtl record);

    int updateByPrimaryKey(CarTimesDtl record);
}