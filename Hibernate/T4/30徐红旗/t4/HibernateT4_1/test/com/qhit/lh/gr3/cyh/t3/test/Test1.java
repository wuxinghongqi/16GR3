package com.qhit.lh.gr3.cyh.t3.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.qhit.lh.gr3.xhq.bean.TDept;
import com.qhit.lh.gr3.xhq.bean.TInfo;
import com.qhit.lh.gr3.xhq.bean.TUser;
import com.qhit.lh.gr3.xhq.service.BaseService;
import com.qhit.lh.gr3.xhq.service.impl.BaseServiceImpl;

public class Test1 {
	private BaseService bs = new BaseServiceImpl();

	@Test
	public void add() {
		// user����
		TUser user = new TUser();
		user.setUname("hui");
		user.setUage(18);
		user.setBirthday("1999-02-19");
		// info�˺�
		TInfo info = new TInfo();
		info.setName("hui");
		info.setAccount("187396");
		info.setPwd("123456");
		// 1-1 ���ำֵ
		info.settUser(user);
		user.setInfo(info);
		// n-1
//		TDept dept = (TDept) bs.getObject(TDept.class, 4);
//		user.setDept(dept);
		 //1-n
		 TDept dept1=new TDept();
		 dept1.setDname("�ۺϰ�");
//		 ���ͨ�����dept1���Ŷ���ʱһ�����User��Info��
		 dept1.getUsers().add(user);
		bs.add(dept1);
	}

	@Test
	public void delete() {
		// ���dept����
		// TDept dept = (TDept) bs.getObject(TDept.class, 6);
		// ɾ����6��dept
		// bs.delete(dept);
		//�õ��û�����
		TUser user = (TUser) bs.getObject(TUser.class, 12);
		//ɾ������
		bs.delete(user);
	}

	@Test
	public void update() {
		// ���dept����
//		 TDept dept = (TDept) bs.getObject(TDept.class, 5);
//		 dept.setDname("������Դ��");
//		 bs.update(dept);
		// ����û�
		 TUser user = (TUser) bs.getObject(TUser.class, 3);
		// ��õ��ĸ����Ÿ�ֵ��user
		 TDept dept = (TDept) bs.getObject(TDept.class, 4);
		 user.setDept(dept);
//		TDept dept = (TDept) bs.getObject(TDept.class, 4);
//		dept.setDname("��Ŀ���̲�");
		// user����
//		TUser user = new TUser();
//		user.setUname("Yi");
//		user.setUage(18);
//		user.setBirthday("1999-02-19");
//		// info�˺�
//		TInfo info = new TInfo();
//		info.setName("Yi");
//		info.setAccount("187396");
//		info.setPwd("123456");
//		// 1-1 ���ำֵ
//		info.settUser(user);
//		user.setInfo(info);
		// �޸�
		// user����
//				TUser user2 = new TUser();
//				user2.setUname("hui");
//				user2.setUage(18);
//				user2.setBirthday("1999-02-19");
				// info�˺�
//				TInfo info2 = new TInfo();
//				info2.setName("hui");
//				info2.setAccount("187396");
//				info2.setPwd("123456");
				// 1-1 ���ำֵ
//				info2.settUser(user2);
//				user2.setInfo(info2);
		//�޸�ͬʱ���user����
//		dept.getUsers().add(user);
//		dept.getUsers().add(user2);
		//��ʼ�޸�
//		 bs.update(dept);
		bs.update(user);
	}

	@Test
	public void getAll() {
		// �õ��ڶ����������������Ա���͸��Ե��˺���Ϣ
//		TDept dept = (TDept) bs.getObject(TDept.class, 4);
//		System.out.println(dept.toString());
//		Set<TUser> users = dept.getUsers();
//		System.out.println(users.size());
//		Iterator<TUser> iterator = users.iterator();
//		while (iterator.hasNext()) {
//			TUser user = iterator.next();
//			TInfo info = user.getInfo();
//			System.out.println(info.toString());
//			System.out.println(user.toString());
//		}
		//�õ����еĲ���TDept
		List<Object> depts = bs.getAll("from TDept");
		System.out.println();
		//ͨ����ǿforѭ����ֵ��ÿһ������dept����
		for(Object object:depts) {
			TDept dept=(TDept) object;
			//�õ�ÿһ�������µ������û���ֵ��Set�û�����
			Set<TUser> users=dept.getUsers();
			//�õ��û��ĵ�����
			Iterator<TUser> iterator=users.iterator();
			//����Ƿ�����һ��
			while(iterator.hasNext()) {
				//ֻҪ����һ��,��������ֵ��һ���µ��û�user����
				TUser user = iterator.next();
				//�õ���user�û����˺���Ϣ
				TInfo info = user.getInfo();
				//����˺ź��û�������Ϣ
				System.out.println(info.toString());
				System.out.println(user.toString()+"\n");
			}
		}
	}
}
