package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.qhit.lh.gr3.xhq.bean.TRole;
import com.qhit.lh.gr3.xhq.bean.TUserinfo;
import com.qhit.lh.gr3.xhq.service.BaseService;
import com.qhit.lh.gr3.xhq.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.xhq.util.HibernateSessionFactory;

class Test1 {
	private BaseServiceImpl bs = new BaseServiceImpl();

	@Test
	void add() {
		TRole role = new TRole();
		role.setRname("鏅�氱鐞嗗憳1");
		role.setRmsg("鏅�氭潈闄�1");

		TUserinfo info = new TUserinfo();
		info.setUname("灏忔槑1");
		info.setUpwd("1234561");

		role.getInfos().add(info);

		bs.add(role);
		// TRole role = new TRole();
		// role.setRname("瓒呯骇绠＄悊鍛�");
		// role.setRmsg("鏈�楂樻潈闄�");
		//
		// TUserinfo info = new TUserinfo();
		// info.setUname("闄堢泭杈�");
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
		role.setRname("瓒呯骇绠＄悊鍛�");
		role.setRmsg("鏈�楂樻潈闄�");

		Set<TUserinfo> infos = role.getInfos();
		for (TUserinfo info : infos) {
			info.setUname("灏忓己");
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
		//杩炴帴鏌ヨ
		// String hql = "select r.rname,i.uname from TRole r join r.infos i where
		// r.rname = '瓒呯骇绠＄悊鍛�'";
		// List<Object[]> roles = bs.getMsgArray(hql);
		// System.out.println();
		// for (Object[] o : roles) {
		// for(Object ob: o) {
		// System.out.println(ob);
		// }
		// System.out.println();
		// }
//		String hql = "select new TRole(r.rid,r.rname,r.rmsg) from TRole r join r.infos i where r.rname = '瓒呯骇绠＄悊鍛�'";
//		String hql = "select r from TRole r where r.rname = '瓒呯骇绠＄悊鍛�'";
//		String hql = "select distinct r from TRole r join fetch r.infos where r.rname = '瓒呯骇绠＄悊鍛�'";
		//瀛愭煡璇�
//		String hql = "select r from TRole r where r.infos=(select i from TUserinfo i where i.uname='灏忓己')";
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
		//澶氭�佹煡璇�
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
		//缁熻鍑芥暟,灞炴�ф煡璇㈣繑鍥炴暟缁�
		String hql = "select r.rname, r.rmsg,i.uname,count(i) from TRole r left join r.infos i group by r.rmsg,r.rname,i.uname";
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
//		query.setString(0, "瓒呯骇绠＄悊鍛�");
		List<Object[]> roles = query.list();
		System.out.println();
		for (Object[] o : roles) {
			for (Object ob : o) {
				System.out.println(ob);
			}
			System.out.println();
		}
	}

	//鍛藉悕鍙傛暟鏌ヨ
	@Test
	void getAllThree() {
		String hql = "select r.rname,i.uname from TRole r join r.infos i where r.rname like:rname";
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql);
		// 浣跨敤鍛藉悕鍙傛暟鏌ヨ鏃�,hql璇彞鍐掑彿:鍓嶅悗涓嶅厑璁告湁绌烘牸
		query.setString("rname", "瓒呯骇绠＄悊鍛�");
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