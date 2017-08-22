package cn.crs.reserve.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author ZJM
 *
 */
@Controller
public class HelpController {
	private static Logger log = LoggerFactory.getLogger(HelpController.class);
	/**
	 * 用户帮助首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String helpIndex(Model model) {
		log.debug("用户帮助首页...");
		return "help/helpIndex";
	}
}
