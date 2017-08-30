package cn.crs.reserve.service;

import java.util.List;

import cn.crs.reserve.entity.BookCarDtl;
import cn.crs.reserve.entity.BookCarDtlExample;

public interface BookCarDtlService {
	public List<BookCarDtl> selectByExample(BookCarDtlExample example);
}
