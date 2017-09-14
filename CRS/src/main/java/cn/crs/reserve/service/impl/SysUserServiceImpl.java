package cn.crs.reserve.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.crs.common.MD5Util;
import cn.crs.common.pagination.BeanUtil;
import cn.crs.common.pagination.PagedResult;
import cn.crs.reserve.dao.SysUserMapper;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.entity.SysUserExample;
import cn.crs.reserve.exception.UserLoginException;
import cn.crs.reserve.service.SysUserService;

@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getUserInfoById(int id) {
		return sysUserMapper.getUserInfoById(id);
	}

	@Override
	public List<SysUser> getAllUserList() {
		return sysUserMapper.getAllUserList();
	}

	@Override
	public List<SysUser> findSysUserByType(int start, int size) {
		return sysUserMapper.getUserListWithPaginated(start, size);
	}

	@Override
	public int countSysUserByTypeNum() {
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

	@Override
	public PagedResult<SysUser> selectByExampleAndOffsetPage(SysUserExample example, Integer pageOffset, Integer pageSize) {
		pageOffset = pageOffset == null?0:pageOffset;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.offsetPage(pageOffset,pageSize);  //pageOffset是告诉拦截器说我要开始分页了。分页参数是这两个,pageOffset为位移，pageSize为每页条数。
		return BeanUtil.toPagedResult(selectByExample(example));
	}

	@Override
	public List<SysUser> selectByExample(SysUserExample example) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectByExample(example);
	}

}
