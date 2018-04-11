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
    	if(value==null) {//�����ڣ����������û�
    	   return Action.LOGIN;//�ı����̣�Ӧָ���½ҳ��	
    	}else {//���ڣ����ǵ�½�û�
    		System.out.println("��¼��Ϣ��"+value);
    		return invocation.invoke();
    		
    	}
    	
		
    	
    }

}