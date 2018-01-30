package com.yocaly.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yocaly.ssm.model.ItemsCustomer;
import com.yocaly.ssm.model.ItemsQueryVo;
import com.yocaly.ssm.service.ItemsService;

@Controller
public class ItermsController {
	@Autowired
	private ItemsService itemsService;

	// 商品的查询
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ItemsQueryVo itemsqueryVo =  new ItemsQueryVo();
		ItemsCustomer itemsCustomer = new ItemsCustomer();
		itemsCustomer.setName("笔记本");
		itemsqueryVo.setItemsCustomer(itemsCustomer);
		List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsqueryVo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemsList", itemsList);
		mav.setViewName("test/jsp/items/itemsList");
		//mav.setViewName("login/jsp/login");
		return mav;
	}
}
