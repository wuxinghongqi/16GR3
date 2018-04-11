package dtu.cyh.ht7;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.qhit.gr3.cyh.ht7.service.BaseService;
import com.qhit.gr3.cyh.ht7.service.impl.BaseServiceImpl;
import com.qhit.gr3.cyh.ht7.util.HibernateSessionFactory;

class Test1 {
	private BaseService bs = new BaseServiceImpl();

	@Test
	void test() {
		// 子查询
		// String hql = "select u from TUser u where u.dept=(select d from TDept d where d.dname='技术部')";
		String hql = "select d from TDept d where exists (select u from TUser u where u.dept=d)";
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();

		List<Object> objects = session.createQuery(hql).list();
		ts.commit();

		session.close();

		for (Object o : objects) {
			System.out.println(o.toString());
		}

	}

}
