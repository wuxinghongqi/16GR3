package com.xhq.sbm.goods.service;

import java.util.List;

import com.xhq.sbm.goods.bean.Goods;

public interface GoodsService {

	public Goods getGoods(String goodsName);
	public int upGoods(int goodsNum,int goodsId);
}
