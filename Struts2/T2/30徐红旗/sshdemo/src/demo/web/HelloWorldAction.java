package demo.web;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String content;//�����Ӧ�������
    public String getContent(){
    	return content;
    }
    public void setContent(String content) {
    	this.content=content;
    }
	@Override
	//��Ӧ�û�����ҵ������
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content="Hello.World!";
		return Action.SUCCESS;
	}

}
