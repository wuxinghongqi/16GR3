package com.qhit.xhq.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.qhit.cyh.bean.TLogin;
import com.qhit.cyh.service.BaseService;
import com.qhit.cyh.service.impl.BaseServiceImpl;

public class LoginAction implements Action {
	private String nam;
	private String pwd;
	private TLogin login;
	private BaseService bs=new BaseServiceImpl();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		login=(TLogin) bs.getObject(TLogin.class, 1);
		if (nam == "" || pwd == "" || nam == null || pwd == null) {
			ServletActionContext.getRequest().setAttribute("Info", "账号和密码不能为空,请重新输入!");
			return "shibai";
		}

		if (nam.equals(login.getUname()) && pwd.equals(login.getUpwd())) {
			ServletActionContext.getRequest().setAttribute("haha", "登陆成功");
			return "chengg";
		} else {
			ServletActionContext.getRequest().setAttribute("Info", "登录失败,请重新输入~");
			return "shibai";
		}
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public TLogin getLogin() {
		return login;
	}

	public void setLogin(TLogin login) {
		this.login = login;
	}
	
	
}
