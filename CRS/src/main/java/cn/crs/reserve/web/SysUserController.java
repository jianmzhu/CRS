package cn.crs.reserve.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.crs.common.PageUtils;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.service.SysUserService;

/**
 * 
 * @author ZJM
 *
 * @date 2017年6月2日
 */
@SuppressWarnings("unused")
@Controller
public class SysUserController {
	
	private static Logger log = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private PageUtils pageUtils;

	/**
	 * 用户分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sysUserListPage/{page}")
	public String sysUserListByPaged(Model model, @PathVariable("page") int page) {
		// 设置页面
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(sysUserService.countSysUserByTypeNum());
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		// 分页查询用户信息
		List<SysUser> users = sysUserService.findSysUserByType(start, pageUtils.getPageRecord());
		model.addAttribute("users", users);
		model.addAttribute("pages", pageUtils);
		return "notice/noticeIndex";
	}

	/**
	 * 用户信息详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sysUserInfo/{id}", method = RequestMethod.GET)
	public String sysUserInfoShow(Model model, @PathVariable(value = "id") int id) {
		SysUser sysUser = sysUserService.getUserInfoById(id);
		model.addAttribute("sysUser", sysUser);
		return "sysUser/userInfo";
	}
	
	/**
	 * 项目跳转到 用户记录页面 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/AllSysUser", method = RequestMethod.GET)
	public String sysUserList(Model model) {
		// 查询所有通知
		List<SysUser> users = sysUserService.getAllUserList();
		model.addAttribute("users", users);
		return "userInfo/allSysUserPage";
	}
	
}
