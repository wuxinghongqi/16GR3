package lanjieqi;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionEventListener;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.opensymphony.xwork2.util.ValueStack;


public abstract class CheckRightIntterceptor implements ActionInvocation {


    public String intercept(ActionInvocation invocation) throws Exception{
    	
    	Object value = invocation.getInvocationContext().getSession().get("username");
    	if(value==null) {//不存在，则是匿名用户
    	   return Action.LOGIN;//改变流程，应指向登陆页面	
    	}else {//存在，则是登陆用户
    		System.out.println("登录信息；"+value);
    		return invocation.invoke();
    		
    	}
    	
		
    	
    }

}