package cn.crs.reserve.service;

import java.util.List;

import cn.crs.reserve.entity.Notice;

public interface NoticeService {

	// 查询所有的须知
	public List<Notice> findNoticeByType(int start, int size);

	// 查询所有的须知的数量
	public int countNoticeByTypeNum();

	// 通过id查询通知
	public Notice findNoticeById(int id);
	

}
