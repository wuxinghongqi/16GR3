package demo.web;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
    private String content;//�����Ӧ�������
    private String uname;//����
 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content="���ã�"+uname;
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
