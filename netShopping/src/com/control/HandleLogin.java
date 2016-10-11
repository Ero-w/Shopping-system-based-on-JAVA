package com.control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.ProcessData;
import com.model.LoginInfo;

/**
 * Servlet implementation class HandleLogin
 */
public class HandleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//创建一个request周期的LoginInfo的bean
		LoginInfo loginInfo=new LoginInfo();
		request.setAttribute("loginInfo", loginInfo);
		//接受数据
		/*userName,pwd为login.jsp的name属性中的值*/
		String strName=request.getParameter("useName");
		String strPwd=request.getParameter("pwd");
		//验证数据
		if(strName==null || strName.equals("")
			|| strPwd==null || strPwd.equals("") )
		{
			//request.setAttribute("mess", "不能为空");
			loginInfo.setMess("不能为空！");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		
			return;
		}
		//处理数据
		String sql="select * from userinfo where userName='"+strName+"' and password='"+strPwd+"'";
		ProcessData data=new ProcessData();
		Vector rows=data.getData(sql);
		
		if(rows.size()==0){
			//request.setAttribute("mess", "用户名或密码不正确");
			loginInfo.setMess("用户名或密码不正确");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		//用户名存入session
		HttpSession session=request.getSession();
		session.setAttribute("userName",strName);
		response.sendRedirect("index.jsp");
	}

}
