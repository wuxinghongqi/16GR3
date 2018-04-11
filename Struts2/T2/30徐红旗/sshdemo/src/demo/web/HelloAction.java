package demo.web;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
    private String content;//保存回应结果数据
    private String uname;//大名
 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content="您好，"+uname;
		return Action.SUCCESS;
	}
   
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
