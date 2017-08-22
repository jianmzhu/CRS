package cn.crs.reserve.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexPageController {
	private static Logger log = LoggerFactory.getLogger(IndexPageController.class);
	
	/**
	 * 用户主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		log.debug("用户登录主页...");
		return "indexPages/indexPage";
	}
	
	/**
	 * 用户主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		log.debug("用户登录主页...");
		return "indexPages/indexPage";
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
