package cn.crs.reserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.crs.reserve.dao.CarTimesDtlMapper;
import cn.crs.reserve.entity.CarTimesDtl;
import cn.crs.reserve.entity.CarTimesDtlExample;
import cn.crs.reserve.service.CarTimesDtlService;

@Service(value="carTimesDtlService")
public class CarTimesDtlServiceImpl implements CarTimesDtlService{
	@Autowired
	private CarTimesDtlMapper carTimesDtlMapper;
	
	@Override
	public List<CarTimesDtl> selectByExample(CarTimesDtlExample example) {
		// TODO Auto-generated method stub
		return carTimesDtlMapper.selectByExample(example);
	}
}
