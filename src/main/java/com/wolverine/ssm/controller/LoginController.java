package com.wolverine.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wolverine.ssm.model.*;

@Controller
public class LoginController {
	public static Map<String, List<SysProModel>> tempMap=new HashMap<String, List<SysProModel>>();

	public static Log LOG = LogFactory.getLog(LoginController.class);
	Log log = LogFactory.getLog("org.lavasoft.test");

	@RequestMapping("/login.action")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("LoginController.login() method=====begin");
		String username = request.getParameter("username");
		request.getSession().setAttribute("username", username);
		ModelAndView mav = new ModelAndView("forward:/findDeployFlow.action");
		LOG.info("LoginController.login() method=====end");
		return mav;
	}
	public static Map<String, List<SysProModel>> getTempMap() {
		return tempMap;
	}
	public static void setTempMap(Map<String, List<SysProModel>> tempMap) {
		LoginController.tempMap = tempMap;
	}
	@RequestMapping("/login1.action")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.info("LoginController.login() method=====begin");
		String orgcode="YKKKKYY";
		String sysPor="22@c-12-2;d-34-5";		
		List<SysProModel> spmList=this.getSysProModel(orgcode, sysPor);
		this.tempMap.put(orgcode, spmList);	
		getMcSysPro(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/jsp/index");
		LOG.info("LoginController.login() method=====end");
		return mav;
	}
	@RequestMapping("/login2.action")
	public ModelAndView test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String orgcode="ggggg";
		String sysPor="345345@c-12-23;d-34-56";		
		List<SysProModel> spmList=this.getSysProModel(orgcode, sysPor);
		this.tempMap.put(orgcode, spmList);	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/jsp/login");
		return mav;
	}
	public void  getMcSysPro(HttpServletRequest request) {
		String orgcode="YYYYYY";
		String sysPor="123456@c-12-23;d-34-56";		
		List<SysProModel> spmList=this.getSysProModel(orgcode, sysPor);
		this.tempMap.put(orgcode, spmList);	
		
	}
	public List<SysProModel> getSysProModel(String orgcode, String sysPor) {
		List<SysProModel> spmList=new ArrayList<SysProModel>();
		String [] str=sysPor.split("@");
		String temp =str[0];
		String[] str1=str[1].split(";");
		for (int i = 0; i < str1.length; i++) {
			SysProModel spm=new SysProModel();
			spm.setOrgCode(orgcode);
			spm.setName(temp);
			String[] str2=str1[i].split("-");
			spm.setDriver(str2[0]);
			spm.setTotal(Integer.parseInt(str2[1]));
			spm.setFree(Integer.parseInt(str2[2]));
			spm.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			spmList.add(spm);
		}
		return spmList;
		
	}
}
