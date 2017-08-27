package cn.crs.reserve.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.crs.reserve.entity.SysUser;

@Controller
public class IndexPageController {
	private static Logger log = LoggerFactory.getLogger(IndexPageController.class);
	
	/**
	 * 项目根路径跳转到 用户登录页面 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(HttpSession session) {
		log.debug("用户使用项目根路径方位，判断是否已经登录，登录跳转index页面，未登录跳转login页面...");
		if(session.getAttribute("userInfo")!=null){
			log.debug("用户已经登录，跳转index页面");
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
	public String login(Model model, String userName, String userPassword, HttpSession session,
			HttpServletRequest request) {
		// 登录用户，并将登录后的状态码返回，如果是0用户不存在，如果是1那么密码错误，如果是2那么密码正确
//		int result = commonUserService.login(userEmail.trim(), userPassword, request);
		int result = 2;
		// 错误信息
		String error = "";
		// 查找这个用户
		SysUser sysUser = new SysUser();
		sysUser.setUserId(1);
		sysUser.setUserName("张三");
//		CommonUser commonUser = commonUserService.findCommonUserByEmail(userEmail.trim());
		if (result == 2) {
			// 如果是2，那么登录成功，返回index
			model.addAttribute("user", sysUser);
			session.setAttribute("userInfo", sysUser);
			return "indexPages/indexPage";
		} else if (result == 1) {
			error = "密码错误";
			log.info(error);
			model.addAttribute("error", error);
			return "loginPages/loginPage";
		} else {
			error = "该用户不存在";
			log.info(error);
			model.addAttribute("error", error);
			return "loginPages/loginPage";
		}

	}
	
	/**
	 * 首页日历显示
	 * 
	 * @return
	 */
	@RequestMapping(value = "/calendarPage", method = RequestMethod.GET)
	public String homeCalendarPage() {
		log.debug("用户主页日历显示...");
		return "indexPages/indexCalendarPage";
	}
	
	/**
	 * 用户联系我们
	 * 
	 * @return
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		log.debug("联系我们主页...");
		return "contact/contactIndex";
	}
	
	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logOff", method = RequestMethod.GET)
	public String logOff(HttpSession session) {
		session.invalidate();
		log.debug("用户登录主页...");
		return "indexPages/indexPage";
	}
}
