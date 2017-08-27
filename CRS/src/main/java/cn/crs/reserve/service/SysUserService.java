package cn.crs.reserve.service;

import java.util.List;

import cn.crs.reserve.entity.SysUser;

public interface SysUserService {

	// 通过ID查询用户信息
	public SysUser getUserInfoById(int id);
	
	//直接查找所有用户列表
    public List<SysUser> getAllUserList();
    
    // 查询所有的须知
 	public List<SysUser> findSysUserByType(int start, int size);

 	// 查询所有的须知的数量
 	public int countSysUserByTypeNum();

}
