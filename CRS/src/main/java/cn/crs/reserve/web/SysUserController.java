package cn.crs.reserve.web;

import java.util.List;

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
@Controller
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private PageUtils pageUtils;

//	/**
//	 * 公告首页
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/noticeIndex/{page}")
//	public String noticeIndex(Model model, @PathVariable("page") int page) {
//		// 设置页面
//		pageUtils.setCurrentPage(page);
//		pageUtils.setTotalRecord(noticeService.countNoticeByTypeNum());
//		int start;
//		if (pageUtils.getCurrentPage() == 0) {
//			start = 0;
//		} else {
//			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
//		}
//		// 查询所有通知
//		List<Notice> notice = noticeService.findNoticeByType(start, pageUtils.getPageRecord());
//		model.addAttribute("notice", notice);
//		model.addAttribute("pages", pageUtils);
//		return "notice/noticeIndex";
//	}

	/**
	 * 用户信息详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sysUserInfo/{id}", method = RequestMethod.GET)
	public String hosInfoShow(Model model, @PathVariable(value = "id") int id) {
		SysUser sysUser = sysUserService.getUserInfoById(id);
		model.addAttribute("sysUser", sysUser);
		return "sys/sysUser/userInfo";
	}

}