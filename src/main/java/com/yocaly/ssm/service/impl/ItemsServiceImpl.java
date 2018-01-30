package com.yocaly.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yocaly.ssm.dao.ItemsMapperCustom;
import com.yocaly.ssm.model.ItemsCustomer;
import com.yocaly.ssm.model.ItemsQueryVo;
import com.yocaly.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

//	@Override
	public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsqueryVo) throws Exception {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsqueryVo);
	}

}
