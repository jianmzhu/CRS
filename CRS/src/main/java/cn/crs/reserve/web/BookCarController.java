package cn.crs.reserve.web;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.crs.common.pagination.BeanUtil;
import cn.crs.common.pagination.PagedResult;
import cn.crs.common.regutil.CommonPageHelper;
import cn.crs.reserve.entity.BookCarDtl;
import cn.crs.reserve.entity.BookCarDtlExample;
import cn.crs.reserve.entity.BookCarDtlExample.Criteria;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.service.BookCarDtlService;

@Controller
public class BookCarController extends JsonBaseController{
	private static Logger log = LoggerFactory.getLogger(BookCarController.class);
	
	@Autowired
	private CommonPageHelper pageHelper;
	
	@Autowired
	private BookCarDtlService bookCarDtlService;
	
	@Autowired
	private BookCarDtlExample bookCarDtlExample;
	
	@Autowired
	private HttpSession session;
	
	/**
     * 分页预约车辆信息（ajax的post请求）
     * @param page
     * @return
     */
	@RequestMapping(value = "/getBookCarDtl/list", method = RequestMethod.POST,  produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String bookCarDtlByPaginator(@RequestBody Map<String,Object> pageJsonMap,HttpServletResponse response) {
		log.debug("分页查询预约车辆信息列表请求入参：pageJsonMap{}", pageJsonMap);
		Map<String, Object> extraData = pageHelper.doPage(pageJsonMap);
//		log.debug("获取用户信息：userInfo{}", session.getAttribute("userInfo"));
		//用户工号不为空，进行筛选
		if(((SysUser)session.getAttribute("userInfo")).getUserJobno()!=null
				&&!"".equals(((SysUser)session.getAttribute("userInfo")).getUserJobno())){
			Criteria criteria = bookCarDtlExample.createCriteria();
			criteria.andBookUserJobnoEqualTo(((SysUser)session.getAttribute("userInfo")).getUserJobno());
		}else{
			return responseFail("用户信息出错");
		}
		try {
			PagedResult<BookCarDtl> pageResult = BeanUtil.toPagedResult(bookCarDtlService.selectByExample(bookCarDtlExample));
			return responseDataTablesSuccess(pageResult, extraData);
    	} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}
}
