package com.xhq.sbm.account.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhq.sbm.account.bean.AccountRetrieval;
import com.xhq.sbm.account.bean.AddAccount;
import com.xhq.sbm.account.service.AccountService;
import com.xhq.sbm.account.service.Impl.AccountServiceImpl;
import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.common.service.CommonService;
import com.xhq.sbm.common.service.impl.CommonServiceImpl;
import com.xhq.sbm.goods.bean.Goods;
import com.xhq.sbm.goods.service.GoodsService;
import com.xhq.sbm.goods.service.Impl.GoodsServiceImpl;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
		case "getPageBean":
			getPageBean(request,response);
			break;
		case "insertRoupAccount":
			insertRoupAccount(request,response);
			break;
		case "selAccount":
			SelAccount(request,response);
			break;
		case "delAccount":
			delAccount(request,response);
			break;
		default:
			break;
		}
		
	}

	private void delAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int accountId=Integer.parseInt(request.getParameter("accountId"));
		AccountService as=new AccountServiceImpl();
		int count=as.delAccount(accountId);
		if(count > 0) {
			response.sendRedirect("AccountServlet?cmd=getPageBean&addd=yes");
		}else {
			response.sendRedirect("admin_bill_list.jsp?del=NO");
		}
	}

	private void SelAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String goodsName=request.getParameter("goodsName");
		String isPayed=request.getParameter("isPayed");
		List<String> wheres=new ArrayList<String>();
		List<String> values=new ArrayList<String>();
		if(goodsName != null && goodsName!= "") {
			wheres.add("goodsName");
			values.add(goodsName);
		}
		if(isPayed != null && isPayed!= "") {
			wheres.add("isPayed");
			values.add(isPayed);
		}
		for(int i=0;i<wheres.size();i++) {
			System.out.println(wheres.get(i)+":"+values.get(i));
		}
		AccountService as=new AccountServiceImpl();
		PageBean pageb=as.getPagebeanByTerm(wheres, values);
		if(pageb == null) {
			response.sendRedirect("admin_bill_list.jsp?sele=No");
			return;
		}
		request.getSession().setAttribute("pagebean", pageb);
		request.setAttribute("sl", "slcg");
		request.setAttribute("goodsName", goodsName);
		RequestDispatcher rd=request.getRequestDispatcher("admin_bill_list.jsp");
		rd.forward(request, response);
	}

	private void insertRoupAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		GoodsService gs=new GoodsServiceImpl();
		AccountService as=new AccountServiceImpl();
		String goodsName=request.getParameter("goodsName");//商品名称
		int providerid=Integer.parseInt(request.getParameter("providerid"));//供应商Id
		int isPayed=Integer.parseInt(request.getParameter("isPayed"));//是否付款，1为已付，0为未付.
		System.out.println("isPayed:"+isPayed);
		int businessNum=Integer.parseInt(request.getParameter("businessNum"));//交易数量
		//如果goodsName为null的话证明是要进行修改操作
		if(goodsName == null) {
			int accountId=Integer.parseInt(request.getParameter("accountId"));
			System.out.println("accountId:"+accountId);
			int count=as.updateAccount(providerid, isPayed, businessNum, accountId);
			if(count > 0) {
				response.sendRedirect("AccountServlet?cmd=getPageBean&addd=yes");
				return;
			}else {
				response.sendRedirect("admin_bill_list.jsp?upAc=No");
				return;
			}
		}
		Goods good=gs.getGoods(goodsName);//根据商品名称查到商品对象
		float goodsPrice=good.getGoodsPrice();
		int goodsId=good.getGoodsId();
		float totalPrice=goodsPrice*businessNum;
		AddAccount adda=new AddAccount(providerid, totalPrice, isPayed, "Getdate()", goodsId, businessNum);
		int goodsNum=good.getGoodsNum();
		goodsNum=goodsNum-businessNum;
		int count1=gs.upGoods(goodsNum, goodsId);
		int count2 =as.insertAccount(adda);
		if(count1 > 0 && count2 > 0) {
			response.sendRedirect("AccountServlet?cmd=getPageBean&addd=yes");
		}else {
			response.sendRedirect("admin_bill_list.jsp?bill=No");
		}
	} 

	private void getPageBean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getParameter("p");
		String addd=request.getParameter("addd");
		PageBean pBean=new PageBean();
		CommonService cs=new CommonServiceImpl();
		List<String> wheres=new ArrayList<String>();
		List<String> values=new ArrayList<String>();
		int count=cs.getCount("tb_account", wheres, values);
		pBean.setCount(count);
		int up=1;
		if(p != null) {
			up=Integer.parseInt(p);
		}
		pBean.setP(up);
		System.out.println(up);
		System.out.println(pBean.getP());
		AccountService as=new AccountServiceImpl();
		pBean=as.getAllAccount(pBean);
		if(pBean.getData().size() == 0) {
			response.sendRedirect("admin_bill_list.jsp?sele=No");
			return;
		}
		request.getSession().setAttribute("pagebean", pBean);
		if(addd != null) {
			response.sendRedirect("admin_bill_list.jsp");
			return;
		}
		response.sendRedirect("admin_index.jsp");
	}

}
