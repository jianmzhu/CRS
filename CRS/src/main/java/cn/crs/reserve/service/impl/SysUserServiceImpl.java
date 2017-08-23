package cn.crs.reserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.crs.reserve.dao.SysUserMapper;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.service.SysUserService;

@Service(value="sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	@Override
	public SysUser getUserInfoById(int id) {
		// TODO Auto-generated method stub
		return sysUserMapper.getUserInfoById(id);
	}

}
