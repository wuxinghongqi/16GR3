package com.qhit.lh.xhq;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.xhq.bean.Dept;
import com.qhit.lh.xhq.bean.Info;
import com.qhit.lh.xhq.bean.User;
import com.qhit.lh.xhq.service.BaseService;
import com.qhit.lh.xhq.service.impl.BaseServiceImpl;

public class Test1 {
	private BaseService bs=new BaseServiceImpl();
	
	@Test
	public void add() {
		//User对象
	User user=new User();
	user.setUname("小明");
	user.setUage(12);
	user.setBirthday("2006-02-01");
	//账号对象
	Info info=new Info("小明", "164050", "123456");
	//互相赋值
	user.setInfo(info);
	info.setUser(user);
	//部门对象
	Dept dept=(Dept) bs.getObject(Dept.class,1);
	//User添加部门对象
	user.setDept(dept);
	bs.add(user);
	}
	
	@Test
	public void getAll(){
		List<Object> list=(List<Object>) bs.getAll("from User");
		for(Object o:list){
			User u=(User)o;
			System.out.print(u.getUname()+"/");
			Info info=u.getInfo();
			System.out.print(info.getAccount()+"/");
			Dept dept=u.getDept();
			System.out.println(dept.getDname());
		}
	}
	@Test
	public void delete() {
		User user=(User) bs.getObject(User.class, 2);
		bs.delete(user);
	}

	@Test
	public void getObject() {
	User user=(User) bs.getObject(User.class, 2);
	if(user!=null){
		System.out.println("user2不为空");
	}
	Info info=(Info) bs.getObject(Info.class, 2);
	if(info!=null){
		System.out.println("info2不为空");
	}
	Dept dept=(Dept) bs.getObject(Dept.class, 2);
	if(dept!=null){
		System.out.println("dept2不为空");
	}
	}

	@Test
	public void update() {
		//拿到第二个员工
	User user=(User) bs.getObject(User.class, 2);
	Dept dept=(Dept) bs.getObject(Dept.class, 2);
	//修改该员工部门
	user.setDept(dept);
	//修改给员工账号
	user.getInfo().setAccount("456789");
	bs.update(user);
	}
}
