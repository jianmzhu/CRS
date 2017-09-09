package cn.crs.reserve.web;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.crs.common.pagination.PagedResult;
import cn.crs.reserve.entity.SysUserPaginationSimple;
import cn.crs.reserve.service.SysUserPaginationSimpleService;

/**
 * 分页样例
 * 
 * @author xiaoming
 *
 */
@Controller
public class PaginationSimpleController extends JsonBaseController{
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private SysUserPaginationSimpleService sysUserPaginationSimpleService;
	
	@RequestMapping("/simple/mybatisPatinationSimple/{id}")  
    public ModelAndView getIndex(@PathVariable(value = "id") int id){    
		ModelAndView mav = new ModelAndView("simplePages/mybatisPatinationSimple/index"); 
		SysUserPaginationSimple user = sysUserPaginationSimpleService.selectUserById(id);
	    mav.addObject("user", user); 
        return mav;
    }  
	
	/**
	 * 显示分页的样例页面
	 * @return
	 */
	@RequestMapping("/simple/mybatisPatinationSimple/sysUserList")  
	public String bootStrapTest1(){
		return "simplePages/mybatisPatinationSimple/userlist";
	}
	
    /**
     * 分页查询用户信息
     * @param page
     * @return
     */
    @RequestMapping(value="/simple/mybatisPatinationSimple/list.do", method= RequestMethod.POST)
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize ,String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);
		try {
			PagedResult<SysUserPaginationSimple> pageResult = sysUserPaginationSimpleService.queryByPage(userName, pageNumber,pageSize);
    	    return responseSuccess(pageResult);
    	} catch (Exception e) {
			return responseFail(e.getMessage());
		}
    }
}
