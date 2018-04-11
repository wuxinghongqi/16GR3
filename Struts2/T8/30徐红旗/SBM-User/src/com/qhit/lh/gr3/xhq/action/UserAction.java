/**
 * 
 */
package com.qhit.lh.gr3.xhq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.xhq.bean.User;
import com.qhit.lh.gr3.xhq.service.UserService;
import com.qhit.lh.gr3.xhq.service.impl.UserServiceImpl;

/**
 * @author ���� TODO 2017��12��8������5:23:31
 */
public class UserAction extends ActionSupport {
	private User user;
	private List<User> userlist;
	private UserService us = new UserServiceImpl();
	private File userpic;
	private String userpicFileName;
	private String userpicContentType;
	private String pic;

	public String login() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		boolean canLogin = true;// �Ƿ�ǿգ�falseΪ�գ�true�ǿ�
		String userName = user.getUserName();
		String userPassword = user.getUserPassword();

		User user = us.getUser(userName, userPassword);// userId�������
		if (user == null) {// ���δ������û���֤���˻��б���û�и��û���Pass!!!
			super.addFieldError("EXP", "�˺Ż��������,����������~");
			return "index";
		} else {
			canLogin = true;
		}
		System.out.println(canLogin);// ����Ƿ���Ե�¼
		System.out.println("user�Ƿ�Ϊ��" + canLogin);
		User user1 = (User) session.getAttribute("user");// user1�Ѿ�����ID��

		String upPwd = (String) session.getAttribute("upPwd");
		// ������ִ���жϲ���������
		if (upPwd != null && user1 != null) {// ��ǰ��½��
			System.out.println("user1.getUserPassword()" + user1.getUserPassword());
			System.out.println("upPwd" + upPwd);
			canLogin = true;// ͨ��
			if (user.getUserId() == user1.getUserId() && user.getUserPassword() == user1.getUserPassword()) {// ����޸Ĺ�������ID���뻹��session��userһ�µĻ�Pass!!!
				super.addFieldError("EXP", "���Ѿ��޸Ĺ�����!");
				canLogin = false;// Pass!!!
			}
		} else {// ��ǰû�е�½��
			canLogin = true;// ͨ��
		}
		if (canLogin == true) {
			// ���canLoginΪtrue�����ͨ�������֤��½��
			session.setAttribute("user", user);
			if (ServletActionContext.getServletContext().getAttribute("users") == null) {
				List<User> users = new ArrayList<User>();
				ServletActionContext.getServletContext().setAttribute("users", users);
			}
			List<User> users = (List<User>) ServletActionContext.getServletContext().getAttribute("users");
			if (users.size() == 0) {
				users.add(user);
				ServletActionContext.getServletContext().setAttribute("users", users);
				return "userSuccess";
			} else {
				int v = -1;
				// ���ǰuserIDΪ�ظ���¼��ֱ����ת��������usersList
				for (User use : users) {
					if (use.getUserId() == user.getUserId()) {
						v = 1;
						// ServletActionContext.sendRedirect("AccountServlet?cmd=getPageBean");
						// return;
						return "userSuccess";
					}
				}
				if (v == -1) {
					users.add(user);
					ServletActionContext.getServletContext().setAttribute("users", users);
					return "userSuccess";
				}
			}
		} else {
			// ���canLoginΪfalse�ͻ�ȥ�صǣ�����
			return "index";
		}
		return null;
	}

	public String userlist() {
		userlist = us.getAllUser();
		return "userAdmin";
	}

	public String fileUpload() {
		if (userpic != null) {
			System.out.println("fileupUser");
			try {
				// ������,�������
				InputStream is = new FileInputStream(userpic);
				// ����·��
				String path = ServletActionContext.getServletContext().getRealPath("/") + "upload";
				File file = new File(path);
				if (!file.exists()) {
					file.mkdirs();
				}
				pic = "upload/" + userpicFileName;
				System.out.println(pic);
				user.setPic(pic);
				// �����,��������·���ļ�userpicFileName��
				FileOutputStream os = new FileOutputStream(path + "/" + userpicFileName);
				// ÿ�ζ�д8096�ֽ�
				byte[] buffer = new byte[8096];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				// �ر����������
				is.close();
				os.flush();
				os.close();
				us.insertUser(user);
				return "Success";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("add", "�ϴ��ļ�ʧ��,������!");
				return "userAdd";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("add", "δ�ҵ��ļ�!");
				return "userAdd";
			}
		} else {
			super.addFieldError("add", "δ�ҵ��ļ�!");
			return "userAdd";
		}

	}

	public String delUser() {
		int row = us.delUser(user.getUserId());
		if (row > 0) {
			return "Success";
		} else {
			super.addFieldError("admin", "ɾ��ʧ��!");
			return "userAdmin";
		}
	}

	public String getUserById() {
		System.out.println("getUserById");
		user = us.getUserById(String.valueOf(user.getUserId()));
		return "update";
	}

	public String uptUser() {
		if (userpic != null) {
			// ������,�������
			try {
				InputStream is = new FileInputStream(userpic);
				// ����·��
				String path = ServletActionContext.getServletContext().getRealPath("/") + "upload";
				File file = new File(path);
				if (!file.exists()) {
					file.mkdirs();
				}
				pic = "upload/" + userpicFileName;
				System.out.println(pic);
				user.setPic(pic);
				// �����,��������·���ļ�userpicFileName��
				FileOutputStream os = new FileOutputStream(path + "/" + userpicFileName);
				// ÿ�ζ�д8096�ֽ�
				byte[] buffer = new byte[8096];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				// �ر����������
				is.close();
				os.flush();
				os.close();

				System.out.println("uptUser");
				System.out.println(user.toString());
				int row = us.upUser(user, user.getUserId());
				if (row > 0) {
					return "Success";
				} else {
					super.addFieldError("admin", "ɾ��ʧ��!");
					return "userAdmin";
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("upt", "δ�ҵ��ļ�!");
				return "userUp";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("upt", "δ�ҵ��ļ�!");
				return "userUp";
			}
		} else {
			super.addFieldError("upt", "δ�ҵ��ļ�!");
			return "userUp";
		}
	}

	public String getUserByInfo() {
		userlist = us.getUserByName(user.getUserName());
		return "userAdmin";
	}

	public String exit() {
		ServletContext aplctn = ServletActionContext.getServletContext();
		List<User> users = (List<User>) aplctn.getAttribute("users");
		users.remove(user);
		aplctn.setAttribute("users", users);
		ServletActionContext.getRequest().getSession().invalidate();
		try {
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print("<script>window.top.location.href='http://localhost:8080/SBM-User/index.jsp'</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the userlist
	 */
	public List<User> getUserlist() {
		return userlist;
	}

	/**
	 * @param userlist
	 *            the userlist to set
	 */
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	/**
	 * @return the us
	 */
	public UserService getUs() {
		return us;
	}

	/**
	 * @param us
	 *            the us to set
	 */
	public void setUs(UserService us) {
		this.us = us;
	}

	/**
	 * @return the userpic
	 */
	public File getUserpic() {
		return userpic;
	}

	/**
	 * @param userpic
	 *            the userpic to set
	 */
	public void setUserpic(File userpic) {
		this.userpic = userpic;
	}

	/**
	 * @return the userpicFileName
	 */
	public String getUserpicFileName() {
		return userpicFileName;
	}

	/**
	 * @param userpicFileName
	 *            the userpicFileName to set
	 */
	public void setUserpicFileName(String userpicFileName) {
		this.userpicFileName = userpicFileName;
	}

	/**
	 * @return the userpicContentType
	 */
	public String getUserpicContentType() {
		return userpicContentType;
	}

	/**
	 * @param userpicContentType
	 *            the userpicContentType to set
	 */
	public void setUserpicContentType(String userpicContentType) {
		this.userpicContentType = userpicContentType;
	}

	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * @param pic
	 *            the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

}
