package cn.crs.reserve.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.crs.reserve.entity.Notice;
import cn.crs.reserve.entity.NoticeExample;

public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
    
    /******************自定义查询**********************/
    // 查询所有的须知
 	public List<Notice> findNoticeByType(@Param("start") int start, @Param("size") int size);

 	// 查询所有通知的数量
 	public int countNoticeByTypeNum();

 	// 通过id查询通知
 	public Notice findNoticeById(int id);
}