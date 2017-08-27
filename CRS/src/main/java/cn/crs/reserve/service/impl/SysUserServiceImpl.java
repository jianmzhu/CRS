package cn.crs.reserve.service.impl;

import java.util.List;

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
	@Override
	public List<SysUser> getAllUserList() {
		// TODO Auto-generated method stub
		return sysUserMapper.getAllUserList();
	}
	@Override
	public List<SysUser> findSysUserByType(int start, int size) {
		// TODO Auto-generated method stub
		return sysUserMapper.getUserListWithPaginated(start, size);
	}
	@Override
	public int countSysUserByTypeNum() {
		// TODO Auto-generated method stub
		return sysUserMapper.countSysUserByTypeNum();
	}

}
