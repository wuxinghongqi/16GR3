package com.qhit.lh.xhq.test1;

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
		//User瀵硅�?
	User user=new User();
	user.setUname("灏忔�?");
	user.setUage(12);
	user.setBirthday("2006-02-01");
	//璐﹀彿�?�硅�?
	Info info=new Info("灏忔�?", "164050", "123456");
	//浜掔浉璧嬪��?
	user.setInfo(info);
	info.setUser(user);
	//閮ㄩ棬�?�硅�?
	Dept dept=(Dept) bs.getObject(Dept.class,1);
	//User娣诲姞閮ㄩ棬瀵硅�?
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
		System.out.println("user2涓嶄负绌�?");
	}
	Info info=(Info) bs.getObject(Info.class, 2);
	if(info!=null){
		System.out.println("info2涓嶄负绌�?");
	}
	Dept dept=(Dept) bs.getObject(Dept.class, 2);
	if(dept!=null){
		System.out.println("dept2涓嶄负绌�?");
	}
	}

	@Test
	public void update() {
		//鎷垮埌绗簩涓憳宸�?
	User user=(User) bs.getObject(User.class, 2);
	Dept dept=(Dept) bs.getObject(Dept.class, 2);
	//淇敼璇ュ憳宸ラ儴闂�?
	user.setDept(dept);
	//淇敼缁欏憳宸ヨ处鍙�?
	user.getInfo().setAccount("456789");
	bs.update(user);
	}
}
