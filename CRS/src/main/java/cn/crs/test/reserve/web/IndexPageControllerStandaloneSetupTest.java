package cn.crs.test.reserve.web;

import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.crs.reserve.web.IndexPageController;

public class IndexPageControllerStandaloneSetupTest {
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		IndexPageController indexPageController = new IndexPageController();
		mockMvc = MockMvcBuilders.standaloneSetup(indexPageController).build();
	}
}