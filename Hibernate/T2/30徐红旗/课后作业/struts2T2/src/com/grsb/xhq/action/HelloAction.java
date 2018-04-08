package com.grsb.xhq.action;

import org.apache.struts2.ServletActionContext;

import com.grsb.cyh.bean.TLogin;
import com.grsb.cyh.service.BaseService;
import com.grsb.cyh.service.impl.BaseServiceImpl;
import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String account;
	private String pwd;
	private TLogin login;
	private BaseService bs=new BaseServiceImpl();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		login = (TLogin) bs.getObject(TLogin.class, 1);
		if (account == null || account == null || pwd == "" || pwd == null) {
			ServletActionContext.getRequest().getSession().setAttribute("Info", "账号和密码不能为空！");
			System.out.println(account+pwd);
			System.out.println("账号密码为空");
			return "shibai";
		}

		if (account.equals(login.getUname()) && pwd.equals(login.getUpwd())) {
			ServletActionContext.getRequest().getSession().setAttribute("name", "欢迎你，陈益辉！");
			System.out.println(account+pwd);
			System.out.println("登陆成功");
			return "chengg";
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("Info", "账号密码不正确！");
			System.out.println(account+pwd);
			System.out.println("账号密码不正确！");
			return "shibai";
		}
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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
