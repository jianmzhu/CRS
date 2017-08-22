package cn.crs.reserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.crs.reserve.dao.NoticeMapper;
import cn.crs.reserve.entity.Notice;
import cn.crs.reserve.service.NoticeService;

@Service(value="noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	@Override
	public List<Notice> findNoticeByType(int start,int size) {
		// TODO Auto-generated method stub
		return noticeMapper.findNoticeByType(start,size);
	}
	@Override
	public int countNoticeByTypeNum() {
		// TODO Auto-generated method stub
		return noticeMapper.countNoticeByTypeNum();
	}
	@Override
	public Notice findNoticeById(int id) {
		// TODO Auto-generated method stub
		return noticeMapper.findNoticeById(id);
	}

}
