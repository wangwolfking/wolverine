package com.wolverine.ssm.dao;

import java.util.List;

import com.wolverine.ssm.model.ItemsCustomer;
import com.wolverine.ssm.model.ItemsQueryVo;

public interface ItemsMapperCustom {
//	商品查询列表
	public List<ItemsCustomer> findItemsList(ItemsQueryVo itemsqueryVo) throws Exception;
}
