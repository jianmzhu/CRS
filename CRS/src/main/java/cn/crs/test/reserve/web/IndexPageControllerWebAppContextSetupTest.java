package cn.crs.test.reserve.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;

import cn.crs.reserve.web.IndexPageController;
import cn.crs.reserve.web.SysUserController;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-service.xml",
		"classpath:mybatisConf/mybatis-context.xml"/*,
		"classpath:log4j.xml"*/})
//@TransactionConfiguration(defaultRollback = true)  
//@Transactional  
public class IndexPageControllerWebAppContextSetupTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	private MockHttpSession session; 
	@Autowired
	private SysUserController SysUserController;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(SysUserController).build();
		this.session = new MockHttpSession();
	}

	@Test
	public void testView() throws Exception {
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.post("/getSysUser/list")
								.characterEncoding("UTF-8")
								.contentType(MediaType.APPLICATION_JSON)
								.param("t1", "[{\"allDay\":false,\"start\":\"2017-08-30 00:00\",\"end\":\"2017-08-30 01:00\",\"id\":1000000,\"title\":\"约车去耍 00:00-01:00\"},{\"allDay\":false,\"start\":\"2017-08-30 01:00\",\"end\":\"2017-08-30 02:00\",\"id\":1000000,\"title\":\"约车去耍 01:00-02:00\"},{\"allDay\":false,\"start\":\"2017-08-30 02:00\",\"end\":\"2017-08-30 03:00\",\"id\":1000000,\"title\":\"约车去耍 02:00-03:00\"}]"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status = result.getResponse().getStatus();
		Assert.assertEquals(200, status); 
		String strResult = result.getResponse().getContentAsString();  
        JSONObject jsonObject = JSONObject.parseObject(strResult);  
        Assert.assertEquals(true, jsonObject.containsKey("code"));  
        Assert.assertEquals(true, jsonObject.containsKey("msg"));  
        Assert.assertEquals(true, jsonObject.containsKey("data"));  
	}
}