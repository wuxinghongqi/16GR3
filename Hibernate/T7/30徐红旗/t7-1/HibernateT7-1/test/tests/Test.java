package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.qhit.lh.gr3.cyh.ht6.bean.TRole;
import com.qhit.lh.gr3.cyh.ht6.bean.TUserinfo;
import com.qhit.lh.gr3.cyh.ht6.service.BaseService;
import com.qhit.lh.gr3.cyh.ht6.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.cyh.ht6.util.HibernateSessionFactory;

class Test {
	private BaseService bs = new BaseServiceImpl();

	@Test
	void add() {
		TRole role = new TRole();
		role.setRname("普�?�管理员1");
		role.setRmsg("普�?�权�?1");

		TUserinfo info = new TUserinfo();
		info.setUname("小明1");
		info.setUpwd("1234561");

		role.getInfos().add(info);

		bs.add(role);
		// TRole role = new TRole();
		// role.setRname("超级管理�?");
		// role.setRmsg("�?高权�?");
		//
		// TUserinfo info = new TUserinfo();
		// info.setUname("陈益�?");
		// info.setUpwd("123456");
		//
		// role.getInfos().add(info);
		//
		//
		// bs.add(role);
	}

	@Test
	void del() {
		// TRole role = (TRole) bs.getObject(TRole.class, 8);
		// bs.delete(role);
		//
		TUserinfo info = (TUserinfo) bs.getObject(TUserinfo.class, 5);
		bs.delete(info);
	}

	@Test
	void upd() {
		TRole role = (TRole) bs.getObject(TRole.class, 11);
		role.setRname("超级管理�?");
		role.setRmsg("�?高权�?");

		Set<TUserinfo> infos = role.getInfos();
		for (TUserinfo info : infos) {
			info.setUname("小强");
			info.setUpwd("456789");
		}

		bs.update(role);
	}

	@Test
	void getObject() {
		TRole role = (TRole) bs.getObject(TRole.class, 10);
		System.out.println();
		Set<TUserinfo> infos = role.getInfos();
		for (TUserinfo info : infos) {
			System.out.println(role.toString());
			System.out.println(info.toString());
		}
	}

	@Test
	void getAll() {
		//连接查询
		// String hql = "select r.rname,i.uname from TRole r join r.infos i where
		// r.rname = '超级管理�?'";
		// List<Object[]> roles = bs.getMsgArray(hql);
		// System.out.println();
		// for (Object[] o : roles) {
		// for(Object ob: o) {
		// System.out.println(ob);
		// }
		// System.out.println();
		// }
//		String hql = "select new TRole(r.rid,r.rname,r.rmsg) from TRole r join r.infos i where r.rname = '超级管理�?'";
//		String hql = "select r from TRole r where r.rname = '超级管理�?'";
//		String hql = "select distinct r from TRole r join fetch r.infos where r.rname = '超级管理�?'";
		//子查�?
//		String hql = "select r from TRole r where r.infos=(select i from TUserinfo i where i.uname='小强')";
//		String hql = "select r from TRole r where exists (select i from TUserinfo i where i.roles=r)";
//		List<Object> roles = bs.getAll(hql);
//		for (Object o : roles) {
//				TRole role=(TRole)o;
//				Set<TUserinfo> infos = role.getInfos();
//				for(TUserinfo info :infos) {
//					System.out.println(info.toString());
//				}
//				System.out.println(role.toString());
//			
//		}
		//多�?�查�?
		String hql = "select o from java.lang.Object o";
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
		List roles = query.list();
		for (Object o : roles) {
			System.out.println(o);
			System.out.println(o.toString());
		}
	}

	@Test
	void getAllTwo() {
//		String hql = "select r.rname,i.uname from TRole r join r.infos i where r.rname like ?";
		//统计函数,属�?�查询返回数�?
		String hql = "select r.rname, r.rmsg,i.uname,count(i) from TRole r left join r.infos i group by r.rmsg,r.rname,i.uname";
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
//		query.setString(0, "超级管理�?");
		List<Object[]> roles = query.list();
		System.out.println();
		for (Object[] o : roles) {
			for (Object ob : o) {
				System.out.println(ob);
			}
			System.out.println();
		}
	}

	//命名参数查询
	@Test
	void getAllThree() {
		String hql = "select r.rname,i.uname from TRole r join r.infos i where r.rname like:rname";
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
		// 使用命名参数查询�?,hql语句冒号:前后不允许有空格
		query.setString("rname", "超级管理�?");
		List<Object[]> roles = query.list();
		System.out.println();
		for (Object[] o : roles) {
			for (Object ob : o) {
				System.out.println(ob);
			}
			System.out.println();
		}
	}
}