package cn.crs.reserve.service;

import java.util.List;

import cn.crs.reserve.entity.CarTimesDtl;
import cn.crs.reserve.entity.CarTimesDtlExample;

public interface CarTimesDtlService {
	public List<CarTimesDtl> selectByExample(CarTimesDtlExample example);
}
