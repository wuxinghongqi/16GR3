package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.qhit.lh.gr3.xhq.bean.TRole;
import com.qhit.lh.gr3.xhq.bean.TUserinfo;
import com.qhit.lh.gr3.xhq.service.BaseService;
import com.qhit.lh.gr3.xhq.service.impl.BaseServiceImpl;

class Test {
	private BaseService bs = new BaseServiceImpl();

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
//		TRole role = new TRole();
//		role.setRname("瓒呯骇绠＄悊鍛�");
//		role.setRmsg("鏈�楂樻潈闄�");
//
//		TUserinfo info = new TUserinfo();
//		info.setUname("闄堢泭杈�");
//		info.setUpwd("123456");
//
//		role.getInfos().add(info);
//		
//			
//		bs.add(role);
	}
	
	@Test
	void del() {
//		TRole role = (TRole) bs.getObject(TRole.class, 8);
//		bs.delete(role);
//		
		TUserinfo info=(TUserinfo) bs.getObject(TUserinfo.class, 5);
		bs.delete(info);
	}
	
	@Test
	void upd() {
		TRole role = (TRole) bs.getObject(TRole.class, 1);
		role.setRname("瓒呯骇绠＄悊鍛�");
		role.setRmsg("鏈�楂樻潈闄�");

		Set<TUserinfo> infos=role.getInfos();
		for(TUserinfo info:infos) {
			info.setUpwd("456789");
		}
			
		bs.update(role);
	}
	
	@Test
	void getAll() {
		TRole role = (TRole) bs.getObject(TRole.class, 10);
		System.out.println();
		Set<TUserinfo> infos=role.getInfos();
		for(TUserinfo info:infos) {
			System.out.println(role.toString());
			System.out.println(info.toString());
		}
	}
}
