package com.xhq.sbm.goods.service.Impl;

import java.util.List;

import com.xhq.sbm.goods.bean.Goods;
import com.xhq.sbm.goods.dao.Impl.GoodsDaoImpl;
import com.xhq.sbm.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {


	@Override
	public Goods getGoods(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().getGoods(goodsName);
	}

	@Override
	public int upGoods(int goodsNum, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().upGoods(goodsNum, goodsId);
	}

}
