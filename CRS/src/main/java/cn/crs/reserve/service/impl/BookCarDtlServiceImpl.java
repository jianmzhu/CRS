package cn.crs.reserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.crs.reserve.dao.BookCarDtlMapper;
import cn.crs.reserve.entity.BookCarDtl;
import cn.crs.reserve.entity.BookCarDtlExample;
import cn.crs.reserve.service.BookCarDtlService;

@Service(value="bookCarDtlService")
public class BookCarDtlServiceImpl implements BookCarDtlService {
	
	@Autowired
	public BookCarDtlMapper bookCarDtlMapper;
	
	@Override
	public List<BookCarDtl> selectByExample(BookCarDtlExample example) {
		return bookCarDtlMapper.selectByExample(example);
	}

}
