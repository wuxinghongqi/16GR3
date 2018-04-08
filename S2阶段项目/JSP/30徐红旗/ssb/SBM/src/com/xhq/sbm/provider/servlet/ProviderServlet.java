package com.xhq.sbm.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.common.service.CommonService;
import com.xhq.sbm.common.service.impl.CommonServiceImpl;
import com.xhq.sbm.provider.bean.Provider;
import com.xhq.sbm.provider.service.ProviderService;
import com.xhq.sbm.provider.service.Impl.ProviderServiceImpl;

/**
 * Servlet implementation class ProviderServlet
 */
@WebServlet("/ProviderServlet")
public class ProviderServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProviderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getParameter("cmd");
		switch (cmd) {
		case "getprovider":
			getProvider(request, response);
			break;
		case "selectProviders":
			SelectProviders(request, response);
			break;
		case "getproviderById":
			getproviderById(request, response);
			break;
		case "Updateprovider":
			Updateprovider(request, response);
			break;
		case "insertprovider":
			insertProvider(request, response);
			break;
		case "getproviderByInfo":
			getproviderByInfo(request, response);
			break;
		default:
			break;
		}
		
	}

	private void getproviderByInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String providerName=request.getParameter("providerName");
		String providerDetail=request.getParameter("providerDetail");
		List<String> wheres=new ArrayList<String>();
		List<String> values=new ArrayList<String>();
		if(providerName!=null && providerName!="") {
			wheres.add("providerName");
			values.add(providerName);
		}
		if(providerDetail!=null && providerDetail!="") {
			wheres.add("providerDetail");
			values.add(providerDetail);
		}
		ProviderService ps=new ProviderServiceImpl();
		PageBean pagebean=new PageBean();
		int count=ps.getCount("tb_provider", wheres, values);
		pagebean.setCount(count);
		int up=1;
		String p=request.getParameter("p");
		if(p!=null&&p!="") {
			up=Integer.parseInt(p);
		}
		pagebean.setP(up);
		pagebean=ps.getPageBeanByInfo(pagebean, wheres, values);
		request.setAttribute("pagebean",pagebean);
		if(pagebean.getData().size()==0) {
			response.sendRedirect("ProviderServlet?cmd=selectProviders&sel=No");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("providerSel.jsp");
			rd.forward(request, response);
		}
		}

	private void insertProvider(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Provider provider=(Provider) request.getAttribute("provider");
		System.out.println("providername"+provider.getProviderName());
		ProviderService ps=new ProviderServiceImpl();
		int count=ps.insertProvider(provider);
		if(count == 1) {
			response.sendRedirect("ProviderServlet?cmd=selectProviders");
		}else {
			response.sendRedirect("ProviderServlet?cmd=selectProviders&ins=No");
		}
	}

	private void Updateprovider(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//接受修改表值
			String act=request.getParameter("act");
			String providerName = request.getParameter("providerName");
			String providerDetail = request.getParameter("providerDetail");
			String contact = request.getParameter("contact");
			String telephone = request.getParameter("telephone");
			String facsimile = request.getParameter("facsimile");
			String address = request.getParameter("address");
			
			if(act.equals("insertprovider")) {
				Provider provider=new Provider(providerName, providerDetail, contact, telephone, facsimile, address);
				request.setAttribute("provider", provider);
				RequestDispatcher rd=request.getRequestDispatcher("ProviderServlet?cmd=insertprovider");
				rd.forward(request, response);
				return;
			}else {
		//组装对象，调用方法修改
				int	providerId = Integer.parseInt(request.getParameter("providerId"));
				System.out.println("providerId:"+providerId);
			Provider provider=new Provider(providerId, providerName, providerDetail, contact, telephone, facsimile, address);
			ProviderService ps=new ProviderServiceImpl();
			int count = ps.Updateprovider(provider);
			if(count == 1) {
				response.sendRedirect("ProviderServlet?cmd=selectProviders");
			}else {
				response.sendRedirect("ProviderServlet?cmd=selectProviders&ins=No");
			}
		}
	}

	private void getproviderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ProviderService ps=new ProviderServiceImpl();
		int providerId=Integer.parseInt(request.getParameter("providerId"));
		Provider provider=ps.getProviderById(providerId);
		request.setAttribute("provider", provider);
		if(provider != null) {
			RequestDispatcher rd=request.getRequestDispatcher("providerUp.jsp");
			rd.forward(request, response);
		}else {
			out.print("<script>alert('系统错误，请重新尝试！');</script>");
		}
	}

	private void SelectProviders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//接受传输隐藏值
//		String act=request.getParameter("act");
		String ins=request.getParameter("ins");
		String sel=request.getParameter("sel");
		String providerId=request.getParameter("providerId");
		CommonService cs=new CommonServiceImpl();
		ProviderService ps=new ProviderServiceImpl();
		List<String> wheres=new ArrayList<String>();
		List<String> values=new ArrayList<String>();
		//PageBean总条数
		PageBean pagebean=new PageBean();
		int count=ps.getCount("tb_provider", wheres, values);
		pagebean.setCount(count);
		//PageBean页数
		String p=request.getParameter("p");
		int up=1;
		if( p != null&& p != "") {
			up=Integer.parseInt(p);
		}
		pagebean.setP(up);
		//pagetotal和pagesize已经产生，现在仅需要数据List了
		pagebean=ps.getPageBean(pagebean);
		request.setAttribute("pagebean", pagebean);
		//现在PageBean数据已经加载完成，开始传值
		if(pagebean.getData().size() == 0) {
			response.sendRedirect("providerAdmin.jsp?sels=No&ins="+ins+"sel="+sel);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("providerAdmin.jsp");
			rd.forward(request, response);
		}
	}

	private void getProvider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act=request.getParameter("act");
		String accountId=request.getParameter("accountId");
		ProviderService ps=new ProviderServiceImpl();
		List<Provider> providers=ps.getProvider();
		
		request.setAttribute("providers", providers);
		RequestDispatcher rd=request.getRequestDispatcher("modify.jsp");
		rd.forward(request, response);
	}

}
