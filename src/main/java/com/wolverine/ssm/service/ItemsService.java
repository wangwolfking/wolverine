package com.wolverine.ssm.service;

import java.util.List;

import com.wolverine.ssm.model.ItemsCustomer;
import com.wolverine.ssm.model.ItemsQueryVo;

public interface ItemsService {
//	商品的查询列表
	public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsqueryVo) throws Exception;
}
