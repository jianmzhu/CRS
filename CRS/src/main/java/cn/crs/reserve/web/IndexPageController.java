package cn.crs.reserve.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.crs.common.DateUtil;
import cn.crs.reserve.entity.CarTimesDtl;
import cn.crs.reserve.entity.CarTimesDtlExample;
import cn.crs.reserve.entity.CarTimesDtlExample.Criteria;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.exception.UserLoginException;
import cn.crs.reserve.service.CarTimesDtlService;
import cn.crs.reserve.service.SysUserService;

@Controller
public class IndexPageController {
	private static Logger log = LoggerFactory.getLogger(IndexPageController.class);
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private CarTimesDtlService carTimesDtlService;
	
	/**
	 * 项目根路径跳转到 用户登录页面 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(HttpSession session,Model model) {
		log.debug("用户使用项目根路径方位，判断是否已经登录，登录跳转index页面，未登录跳转login页面...");
		if(session.getAttribute("userInfo")!=null){
			log.debug("用户已经登录，跳转index页面");
			model.addAttribute("user", (SysUser)session.getAttribute("userInfo"));
			return "indexPages/indexPage";
		}else{
			log.debug("用户未登录跳转login页面...");
			return "loginPages/loginPage";
		}
	}
	
	/**
	 * 用户登陆验证
	 * 
	 * @param email
	 * @param passWord
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, String userJobNo, String userPassword, HttpSession session,
			HttpServletRequest request) {
		SysUser sysUser = null;
		// 登录用户，并将登录后的用户信息返回
		try {
			sysUser= sysUserService.login(userJobNo.trim(), userPassword, request);
		} catch (UserLoginException e) {
			log.error(e.getMessage());
			model.addAttribute("error", e.getMessage());
			return "loginPages/loginPage";
		} catch (Exception e) {
			log.error(e.getMessage());
			model.addAttribute("error", "数据库或系统错误");
			return "loginPages/loginPage";
		}
		
		//登录成功，返回index
		model.addAttribute("user", sysUser);
		session.setAttribute("userInfo", sysUser);
		return "indexPages/indexPage";

	}
	
	/**
	 * 预约车辆页面显示
	 * 
	 * @return
	 */
	@RequestMapping(value = "/bookCars", method = RequestMethod.GET)
	public String homeBookCarsPage() {
		log.debug("预约车辆页面显示...");
		return "bookCarsPages/bookCarsPage";
	}
	
	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		session.invalidate();
		log.debug("输入http://<ip>:<port>/CRS/loginOut 用户退出系统界面...");
		return "loginPages/loginPage";
	}
	
	/**
	 * 登录页面链接
	 * 
	 * @return
	 */
	@RequestMapping(value = {"/login","/Login"}, method = RequestMethod.GET)
	public String redirectlogin(HttpSession session) {
		log.debug("输入http://<ip>:<port>/CRS/[login|Login] 重定位到项目根地址...");
		return "redirect:/";
	}
	
	/**
	 * 用户联系我们（暂时不用）
	 * 
	 * @return
	 */
//	@RequestMapping(value = "/contact", method = RequestMethod.GET)
//	public String contact() {
//		log.debug("联系我们主页...");
//		return "contact/contactIndex";
//	}
}
