package com.xhq.sbm.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xhq.sbm.user.bean.User;

/**
 * Application Lifecycle Listener implementation class SessionLisenter
 *
 */
@WebListener
public class SessionLisenter implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionLisenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  {
    	System.out.println("Session监听器创建");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	HttpSession session=arg0.getSession();
    	//拿到当前user
    	User user=(User) session.getAttribute("user");
    	//拿到application，从中拿到users List删除当前user再把List放回application
    	ServletContext application=session.getServletContext();
    	List<User> users=(List<User>) application.getAttribute("users");
    	users.remove(user);
    	application.setAttribute("users", users);
    	System.out.println("Session监听器销毁");
    }
}
