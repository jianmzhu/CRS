package cn.crs.reserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.crs.common.pagination.BeanUtil;
import cn.crs.common.pagination.PagedResult;
import cn.crs.reserve.dao.SysUserPaginationSimpleMapper;
import cn.crs.reserve.entity.SysUserPaginationSimple;
import cn.crs.reserve.service.SysUserPaginationSimpleService;

@Service(value = "sysUserPaginationSimpleService")
public class SysUserPaginationSimpleServiceImpl implements SysUserPaginationSimpleService {

	@Autowired
	private SysUserPaginationSimpleMapper sysUserPaginationSimpleMapper;
	
	@Override
	public SysUserPaginationSimple selectUserById(Integer userId) {
		return sysUserPaginationSimpleMapper.selectUserById(userId);
	}

	@Override
	public List<SysUserPaginationSimple> getAllUserList() {
		return sysUserPaginationSimpleMapper.getAllUserList();
	}

	@Override
	public List<SysUserPaginationSimple> selectUserByUserName(String userName) {
		return sysUserPaginationSimpleMapper.selectUserByUserName(userName);
	}

	@Override
	public PagedResult<SysUserPaginationSimple> queryByPage(String userName,
			Integer pageNo, Integer pageSize) {//页号查询
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(selectUserByUserName(userName));
	}

	@Override
	public PagedResult<SysUserPaginationSimple> queryByPageOffset(
			String userName, Integer pageOffset, Integer pageSize) {//位移查询
		
		pageOffset = pageOffset == null?0:pageOffset;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.offsetPage(pageOffset,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(selectUserByUserName(userName));
	}

}
