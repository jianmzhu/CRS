package cn.crs.reserve.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.crs.common.MD5Util;
import cn.crs.reserve.dao.SysUserMapper;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.exception.UserLoginException;
import cn.crs.reserve.service.SysUserService;

@Service(value = "sysUserService")
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

	/**
	 * 用户登录 
	 */
	@Transactional
	@Override
	public SysUser login(String userJobNo, String userPassword,
			HttpServletRequest request) throws UserLoginException{
		SysUser sysUser = sysUserMapper.getUserInfoByJobNo(userJobNo);
		if (sysUser == null) {
			throw new UserLoginException("用户不存在"); // 用户不存在就返回0
		} else {
			if (MD5Util.getMD5(userPassword).equals(sysUser.getUserPassword())) {
				//记录IP地址
//				sysUser.setLastLoginTime(dateUtil
//						.getCurrentTime(DateFormat.YYYY_MM_DD_HH_mm_ss));
//				commonUser.setLastLoginIp(GetIP.getIpAddr(request));
//				commonUserDao.modifyIpAndTime(commonUser);
			} else {
				throw new UserLoginException("输入密码错误");
			}
		}
		return sysUser;//用户密码正确返回
	}

}
