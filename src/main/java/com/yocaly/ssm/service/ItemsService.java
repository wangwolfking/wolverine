package com.yocaly.ssm.service;

import java.util.List;

import com.yocaly.ssm.model.ItemsCustomer;
import com.yocaly.ssm.model.ItemsQueryVo;

public interface ItemsService {
//	商品的查询列表
	public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsqueryVo) throws Exception;
}
