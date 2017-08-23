package cn.crs.reserve.service;

import cn.crs.reserve.entity.SysUser;

public interface SysUserService {

	// 通过ID查询用户信息
	public SysUser getUserInfoById(int id);

}
