package com.xhq.sbm.goods.dao;

import java.util.List;

import com.xhq.sbm.goods.bean.Goods;

public interface GoodsDao {

	public Goods getGoods(String goodsName);
	public int upGoods(int goodsNum,int goodsId);
}
