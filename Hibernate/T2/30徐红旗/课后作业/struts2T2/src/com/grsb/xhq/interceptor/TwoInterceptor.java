package com.grsb.xhq.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TwoInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String value=(String) arg0.getInvocationContext().getSession().get("Info");
		if(value!=null) {
			System.out.println("匿名用户");
			return Action.SUCCESS;
		}else {
			System.out.println("登录信息："+value);
			return arg0.invoke();
		}
		
	}

}
