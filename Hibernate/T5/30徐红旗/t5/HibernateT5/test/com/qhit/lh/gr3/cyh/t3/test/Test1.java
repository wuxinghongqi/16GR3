package com.qhit.lh.gr3.cyh.t3.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.qhit.lh.gr3.cyh.t4.bean.TDept;
import com.qhit.lh.gr3.cyh.t4.bean.TInfo;
import com.qhit.lh.gr3.cyh.t4.bean.TUser;
import com.qhit.lh.gr3.cyh.t4.service.BaseService;
import com.qhit.lh.gr3.cyh.t4.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.cyh.t4.util.HibernateSessionFactory;

public class Test1 {
	private BaseService bs = new BaseServiceImpl();

	@Test
	public void add() {
		// user对象
		TUser user = new TUser();
		user.setUname("hui");
		user.setUage(18);
		user.setBirthday("1999-02-19");
		// info账号
		TInfo info = new TInfo();
		info.setName("hui");
		info.setAccount("187396");
		info.setPwd("123456");
		// 1-1 互相赋值
		info.settUser(user);
		user.setInfo(info);
		// n-1
		// TDept dept = (TDept) bs.getObject(TDept.class, 4);
		// user.setDept(dept);
		// 1-n
		TDept dept1 = new TDept();
		dept1.setDname("综合办");
		// 最后通过添加dept1部门对象时一起添加User和Info类
		dept1.getUsers().add(user);
		bs.add(dept1);
	}

	@Test
	public void delete() {
		// 获得dept对象
		// TDept dept = (TDept) bs.getObject(TDept.class, 6);
		// 删除第6个dept
		// bs.delete(dept);
		// 拿到用户对象
		TUser user = (TUser) bs.getObject(TUser.class, 13);
		// 删除操作
		bs.delete(user);
	}

	@Test
	public void update() {
		// 获得dept对象
		// TDept dept = (TDept) bs.getObject(TDept.class, 5);
		// dept.setDname("人力资源部");
		// bs.update(dept);
		// 获得用户
		// TUser user = (TUser) bs.getObject(TUser.class, 3);
		// 获得第四个部门赋值给user
		// TDept dept = (TDept) bs.getObject(TDept.class, 4);
		// user.setDept(dept);
		// TDept dept = (TDept) bs.getObject(TDept.class, 4);
		// dept.setDname("项目工程部");
		// user对象
		// TUser user = new TUser();
		// user.setUname("Yi");
		// user.setUage(18);
		// user.setBirthday("1999-02-19");
		// // info账号
		// TInfo info = new TInfo();
		// info.setName("Yi");
		// info.setAccount("187396");
		// info.setPwd("123456");
		// // 1-1 互相赋值
		// info.settUser(user);
		// user.setInfo(info);
		// 修改
		// user对象
		// TUser user2 = new TUser();
		// user2.setUname("hui");
		// user2.setUage(18);
		// user2.setBirthday("1999-02-19");
		// info账号
		// TInfo info2 = new TInfo();
		// info2.setName("hui");
		// info2.setAccount("187396");
		// info2.setPwd("123456");
		// 1-1 互相赋值
		// info2.settUser(user2);
		// user2.setInfo(info2);
		// 修改同时添加user对象
		// dept.getUsers().add(user);
		// dept.getUsers().add(user2);
		// 开始修改
		// bs.update(dept);
		// 获得dept对象
//		TDept dept = (TDept) bs.getObject(TDept.class, 5);
		// 修改部门名称
//		dept.setDname("国家资源部");
		// 新user
//		TUser user = new TUser();
//		user.setUname("陈益辉");
//		user.setUage(18);
//		user.setBirthday("1999-02-19");
//		TDept dept1 = (TDept) bs.getObject(TDept.class, 1);
		// 通过inverse="true"反转维护权利给user,所以user现在可以随便改部门id,然后被随便其他部门对象修改或添加了
//		user.setDept(dept1);
		// info账号
//		TInfo info = new TInfo();
//		info.setName("陈益辉");
//		info.setAccount("187396");
//		info.setPwd("123456");
		// 1-1 互相赋值
//		info.settUser(user);
//		user.setInfo(info);
		// 添加入第5个部门,此时被添加的user的deptid部门id为4,证明通过inverse="true"反转维护权利户,现在user的deptid部门id可以自己控制
		// 不再依赖执行添加或修改操作的部门对象通过关联赋值了
//		dept.getUsers().add(user);
//		bs.update(dept);
		TDept dept=(TDept) bs.getObject(TDept.class, 1);
		dept.setDname("信息科技部");
		
		Set<TUser> users=dept.getUsers();
		Iterator<TUser> iterator=users.iterator();
		while(iterator.hasNext()) {
			TUser user=iterator.next();
			user.setUname("于志胜");
			TDept dept1=(TDept) bs.getObject(TDept.class, 4);
			user.setDept(dept1);
		}
		bs.update(dept);
	}

	@Test
	public void getAll() {
		// 拿到第二个部门输出部门下员工和各自的账号信息
		// TDept dept = (TDept) bs.getObject(TDept.class, 4);
		// System.out.println(dept.toString());
		// Set<TUser> users = dept.getUsers();
		// System.out.println(users.size());
		// Iterator<TUser> iterator = users.iterator();
		// while (iterator.hasNext()) {
		// TUser user = iterator.next();
		// TInfo info = user.getInfo();
		// System.out.println(info.toString());
		// System.out.println(user.toString());
		// }
		// 拿到所有的部门TDept
		List<Object> depts = bs.getAll("from TDept");
		System.out.println();
		// 通过加强for循环赋值给每一个部门dept对象
		for (Object object : depts) {
			TDept dept = (TDept) object;
			// 拿到每一个部门下的所有用户赋值给Set用户集合
			Set<TUser> users = dept.getUsers();
			// 拿到用户的迭代器
			Iterator<TUser> iterator = users.iterator();
			// 检测是否有下一个
			while (iterator.hasNext()) {
				// 只要有下一个,把他给赋值给一个新的用户user对象
				TUser user = iterator.next();
				// 拿到该user用户的账号信息
				TInfo info = user.getInfo();
				// 输出账号和用户个人信息
				System.out.println(info.toString());
				System.out.println(user.toString() + "\n");
			}
		}
	}

	@Test
	public void updateTwo() {
//		TDept dept=(TDept) bs.getObject(TDept.class, 1);
//		dept.setDname("信息部");
//		Set<TUser> users=dept.getUsers();
//		Iterator<TUser> iterator=users.iterator();
//		while(iterator.hasNext()) {
//			TUser user=iterator.next();
//			user.setUname("陈益辉");
//			user.setDept(dept);
//			break;
//		}
//		bs.update(dept);
		//测试持久状态下会不会自动检测保存
		HibernateSessionFactory factory=new HibernateSessionFactory();
		Session session=factory.getSession();
		Transaction transaction=session.beginTransaction();
		//dept持久状态
		TDept dept=(TDept) session.get(TDept.class, 1);
		//未关闭session状态下改名字
		dept.setDname("信息部");
		transaction.commit();
		session.close();
		//结果,未执行update持久化方法,在持久状态下的对象改变能自动保存到数据库
		System.out.println(dept.toString());
	}

	@Test
	public void updateThree() {
		TUser user = (TUser) bs.getObject(TUser.class, 14);
		TDept dept = (TDept) bs.getObject(TDept.class, 1);
		user.setDept(dept);
		bs.update(user);
	}

	@Test
	public void getObjectById() {
//		TDept dept = (TDept) bs.getObject(TDept.class, 4);
//		System.out.println("\n");
//		Set<TUser> users=dept.getUsers();
//		Iterator<TUser> iterator=users.iterator();
//		while(iterator.hasNext()) {
//			TUser user=iterator.next();
//			TInfo info=user.getInfo();
//			System.out.println(info.toString());
//			System.out.println(user.toString()+"\n");
//		}
		TUser user=(TUser) bs.getObject(TUser.class, 14);
		TInfo info2=user.getInfo();
		System.out.println(user.toString());
		System.out.println(info2.toString());
	}
};