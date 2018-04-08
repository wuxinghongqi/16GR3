package com.qhit.gr3.xhq;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.qhit.gr3.xhq.bean.User;
import com.qhit.gr3.xhq.service.BaseService;
import com.qhit.gr3.xhq.service.impl.BaseServiceImpl;

public class Test1 {
	private BaseService bs=new BaseServiceImpl();
	@Test
	public void addUser() {
		User user=new User("陈晨", "123456", 18, "1999-02-19");
		bs.add(user);
	}
	
	@Test
	public void getUser(){
		User user=null;
		user=(User) bs.getObject(User.class, new Integer(1));
		System.out.println(user.getUname());
	}
	@Test
	public void getAllUser(){
		List<Object> list=new ArrayList<Object>();
		list=bs.getAll("from User");
		for(Object object:list){
				User user=(User)object;
				System.out.println(user.toString());
		}
	}
	
	@Test
	public void delete(){
		User user=null;
		user=(User) bs.getObject(User.class, new Integer(4));
		bs.delete(user);
	}
	
	@Test
	public void update(){
		User user=null;
		user=(User) bs.getObject(User.class, new Integer(2));
		user.setBirthday("1997-05-07");
		user.setUage(19);
		bs.update(user);
	}
}
