package com.xhq.sbm.common.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
private int pagesize;
private int count;
private int pagetotal;
private List<Object> data;
private int p;

public PageBean() {
	super();
	this.pagesize=5;
	this.data=new ArrayList<Object>();
}

public int getPagesize() {
	return pagesize;
}

public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
	this.pagetotal=(int)Math.ceil((count*1.0)/pagesize);
}

public int getPagetotal() {
	return pagetotal;
}


public List<Object> getData() {
	return data;
}

public void setData(List list) {
	this.data = list;
}

public void addData(Object object) {
	data.add(object);
}
public int getP() {
	return p;
}

public void setP(int up) {
	if(up<1) {
		this.p=1;
	}else if(up>pagetotal){
		this.p=pagetotal;
	}else {
		this.p = up;
	}
}

}
