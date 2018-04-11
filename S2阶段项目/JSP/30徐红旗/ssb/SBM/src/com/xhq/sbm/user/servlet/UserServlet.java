package com.xhq.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.common.finalItems.Fclass;
import com.xhq.sbm.common.service.CommonService;
import com.xhq.sbm.common.service.impl.CommonServiceImpl;
import com.xhq.sbm.user.bean.User;
import com.xhq.sbm.user.service.UserService;
import com.xhq.sbm.user.service.impl.UserServiceImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		switch (cmd) {
		case "login":
			doLogin(request,response);
			break;
		case "exit":
			doExit(request,response);
			break;
		case "selectUsers":
			SelectUsers(request,response);
			break;
		case "UserFile":
			UserFile(request,response);
			break;
		case "insertUser":
			insertUser(request,response);
			break;
		case "retrievalUser":
			RetrievalUser(request,response);
			break;
		case "upUser":
			upUser(request,response);
			break;
		case "delUser":
			delUser(request,response);
			break;
		case "getUser":
			getUser(request,response);
			break;
		case "upPwd":
			upPwd(request,response);
			break;
		default:
			break;
		}
	}

	private void upPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		UserService us=new UserServiceImpl();
		String userPassword=request.getParameter("userPassword");
		User user=(User) request.getSession().getAttribute("user");
		User user2=us.getUserByInfo(user.getUserId());//根据当前Id查出所有数据
		user.setUserPassword(userPassword);
		int count = us.upUserPwd(user, user.getUserId());
		if(count > 0){
			request.getSession().setAttribute("upPwd", "Yes");
			doExit(request,response);
		}else{
			response.sendRedirect("PwdUp.jsp?PwdUp=no");
		}
	}

	private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getParameter("p");
		CommonService cs=new CommonServiceImpl();
		UserService us=new UserServiceImpl();
		PageBean pagebean =new PageBean();
		//拿到userName根据userName获取值
		String userName=request.getParameter("userName");
		//获取总条数
		List<String> wheres=new ArrayList<String>();
		List<String> values=new ArrayList<String>();
		if( userName !=null && userName !="") {
			wheres.add("userName");
			values.add(userName);
		}
		int count=cs.getCount("tb_user", wheres, values);
		pagebean.setCount(count);
		//再拿页数
		int up=1;
		if( p != "" && p !=null) {
			up=Integer.parseInt(p);
		}
		pagebean.setP(up);
		System.out.println("userName:"+userName);
		System.out.println("count:"+pagebean.getCount());
		System.out.println("up:"+up);
		System.out.println("p:"+pagebean.getP());
		//拿到数据bean
		pagebean=us.getUserPageBean(pagebean, userName);
		request.setAttribute("pagebean", pagebean);
		if(pagebean.getData().size()>0) {
			RequestDispatcher rd=request.getRequestDispatcher("userSel.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("userAdmin.jsp?sele=No");
		}
	}

	private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(request.getParameter("userId"));
		UserService us=new UserServiceImpl();
		int count=us.delUser(userId);
		if(count > 0) {
			response.sendRedirect("UserServlet?cmd=selectUsers");
		}else {
			response.sendRedirect("UserServlet?cmd=selectUsers&del=No");
		}
	}

	private void upUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		UserService us=new UserServiceImpl();
		System.out.println("传过来了up");
		String userId=(String) request.getAttribute("userId");
		int userid=Integer.parseInt(userId);
		System.out.println("up"+userId);
		User u=(User)request.getAttribute("u");
		System.out.println("age"+u.getUserAge());
		int count =us.upUser(u, userid);
		if(count > 0) {
			response.sendRedirect("UserServlet?cmd=selectUsers");
		}else {
			response.sendRedirect("UserServlet?cmd=selectUsers&ups=No");
			
		}
	}

	private void RetrievalUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService us=new UserServiceImpl();
		String userId =request.getParameter("userId");
		User u=us.getUserById(userId);
		request.setAttribute("u", u);
		RequestDispatcher rd=request.getRequestDispatcher("userUp.jsp");
		rd.forward(request, response);
	}

	private void UserFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		SmartUpload su=new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setAllowedFilesList("png,jpg,pvg,JPEG");
		try {
			su.setDeniedFilesList("txt,doc,ppt,html,htm");
			su.setMaxFileSize(1024*1024*5);
			su.upload();
			
			String realpath=request.getRealPath("/");
			String filepath=Fclass.FILE_USER_PIC_PHOTO_PATH;
			java.io.File f=new java.io.File(realpath+filepath);
			if(!f.exists()) {
				f.mkdirs();
			}
			Files files=su.getFiles();
			File file=files.getFile(0);
			String fileExt=file.getFileExt();
			String uuid=Fclass.getUUID();
			
			String path = filepath+uuid+fileExt;
			file.saveAs(path);
			
			Request req=su.getRequest();
			String act=req.getParameter("act");
			String userName=req.getParameter("userName");
			String userPassword=req.getParameter("userPassword");
			String userSex=req.getParameter("userSex");
			String userAge=req.getParameter("userAge");
			String telephone=req.getParameter("telephone");
			String address=req.getParameter("address");
			String type=req.getParameter("type");
			String pic=path;
			String userId=req.getParameter("userId");
			System.out.println("act"+act);
			
			User u=new User(userName, userPassword, userSex, Integer.parseInt(userAge), telephone, address, pic, Integer.parseInt(type));
			request.setAttribute("u", u);
			request.setAttribute("userId", userId);
				RequestDispatcher rd=request.getRequestDispatcher("UserServlet?cmd="+act);
				rd.forward(request, response);
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			out.print("<script>alert('上传头像失败，请检查图片格式和大小');</script>");
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		UserService us=new UserServiceImpl();
		User u=(User) request.getAttribute("u");
		int count=us.insertUser(u);
		if(count > 0) {
			response.sendRedirect("UserServlet?cmd=selectUsers");
		}else {
			response.sendRedirect("UserServlet?cmd=selectUsers&ins=No");
		}
			
	}

	private void SelectUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String ins=request.getParameter("ins");
		String ups=request.getParameter("ups");
		CommonService cs=new CommonServiceImpl();
		UserService us=new UserServiceImpl();
		PageBean pagebean =new PageBean();
		List<String> wheres=new ArrayList<String>();
		List<String> values=new ArrayList<String>();
		int count =cs.getCount("tb_user", wheres, values);
		pagebean.setCount(count);
		String p=request.getParameter("p");
		int up=1;
		if(p != null && p != "") {
			up=Integer.parseInt(p);
		}
		pagebean.setP(up);
		pagebean=us.getPageBean(pagebean);
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("ins", ins);
		request.setAttribute("ups", ups);
		System.out.println(pagebean.getData().size());
		if(pagebean.getData().size() == 0 ) {
			response.sendRedirect("userAdmin.jsp?sele=No");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("userAdmin.jsp");
			rd.forward(request, response);
		}
	}


	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("user");
		List<User> users=(List<User>) request.getServletContext().getAttribute("users");
		users.remove(user);
		request.getServletContext().setAttribute("users", users);
		PrintWriter out=response.getWriter();
		out.print("<script>window.top.location.href='http://localhost:8080/SBM/login.jsp'</script>");
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean canLogin=true;//是否非空，false为空，true非空
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		UserService us=new UserServiceImpl();
		User user = us.getUser(userName, userPassword);//userId查出来了
		if(user == null) {//如果未查出该用户，证明账户列表里没有该用户，Pass!!!
			response.sendRedirect("login.jsp?detection=No");//Pass!!!
			return;
		}else {
			canLogin=true;
		}
	  System.out.println(canLogin);//输出是否可以登录
		System.out.println("user是否为空"+canLogin);
		User user1=(User) request.getSession().getAttribute("user");//user1已经是有ID的
		
		String upPwd=(String) request.getSession().getAttribute("upPwd");
		//接下来执行判断操作！！！
		  if(upPwd !=null&&user1 != null ){//以前登陆过
			  System.out.println("user1.getUserPassword()"+user1.getUserPassword());
			  System.out.println("upPwd"+upPwd);
		  canLogin=true;//通过
		  if(upPwd != null && user.getUserId() == user1.getUserId() && user.getUserPassword() == user1.getUserPassword()){//如果修改过密码了ID密码还和session里user一致的话Pass!!!
		  canLogin=false;//Pass!!!
		  }else if(upPwd ==null && user.getUserId() == user1.getUserId() && user.getUserPassword() == user1.getUserPassword()){//如果没有修改过密码，Id密码和session里一致的话可以通过
		  canLogin=true;//通过
		  }else{//没有修改过密码，Id密码也和session里的不一致，可以通过
		  canLogin=true;//通过
		  }
		  }else if(upPwd == null && user1 != null){
			  
			  canLogin=true;
			  
		  }
		  else{//以前没有登陆过
			  
		   canLogin=true;//通过
		   
		 }
		  
		  if(canLogin == true){
		 // 如果canLogin为true则可以通过，可以验证登陆了
		  request.getSession().setAttribute("user", user);
			List<User> users=(List<User>) request.getServletContext().getAttribute("users");
			//如果当前userID为重复登录则直接跳转，不放入usersList
			for(User use:users) {
				if (use.getUserId() == user.getUserId()) {
					response.sendRedirect("AccountServlet?cmd=getPageBean");
					return;
				}
			}
			users.add(user);
			request.getServletContext().setAttribute("users", users);
			response.sendRedirect("AccountServlet?cmd=getPageBean");
		  }else{
		  //如果canLogin为false就回去重登！！！
		  response.sendRedirect("login.jsp?detection=No");
		  }
		 
//			if(user != null) {
//			request.getSession().setAttribute("user", user);
//			List<User> users=(List<User>) request.getServletContext().getAttribute("users");
//			//如果当前userID为重复登录则直接跳转，不放入usersList
//			for(User use:users) {
//				if (use.getUserId() == user.getUserId()) {
//					response.sendRedirect("AccountServlet?cmd=getPageBean");
//					return;
//				}
//			}
//			users.add(user);
//			request.getServletContext().setAttribute("users", users);
//			response.sendRedirect("AccountServlet?cmd=getPageBean");
//		}else {
//			response.sendRedirect("login.jsp?detection=No");
//		}
	}
}
		



