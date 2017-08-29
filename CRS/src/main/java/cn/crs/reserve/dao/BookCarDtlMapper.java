package cn.crs.reserve.dao;

import cn.crs.reserve.entity.BookCarDtl;
import cn.crs.reserve.entity.BookCarDtlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookCarDtlMapper {
    long countByExample(BookCarDtlExample example);

    int deleteByExample(BookCarDtlExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(BookCarDtl record);

    int insertSelective(BookCarDtl record);

    List<BookCarDtl> selectByExample(BookCarDtlExample example);

    BookCarDtl selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") BookCarDtl record, @Param("example") BookCarDtlExample example);

    int updateByExample(@Param("record") BookCarDtl record, @Param("example") BookCarDtlExample example);

    int updateByPrimaryKeySelective(BookCarDtl record);

    int updateByPrimaryKey(BookCarDtl record);
}