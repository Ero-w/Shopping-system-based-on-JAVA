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
		//����һ��request���ڵ�LoginInfo��bean
		LoginInfo loginInfo=new LoginInfo();
		request.setAttribute("loginInfo", loginInfo);
		//��������
		/*userName,pwdΪlogin.jsp��name�����е�ֵ*/
		String strName=request.getParameter("useName");
		String strPwd=request.getParameter("pwd");
		//��֤����
		if(strName==null || strName.equals("")
			|| strPwd==null || strPwd.equals("") )
		{
			//request.setAttribute("mess", "����Ϊ��");
			loginInfo.setMess("����Ϊ�գ�");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		
			return;
		}
		//��������
		String sql="select * from userinfo where userName='"+strName+"' and password='"+strPwd+"'";
		ProcessData data=new ProcessData();
		Vector rows=data.getData(sql);
		
		if(rows.size()==0){
			//request.setAttribute("mess", "�û��������벻��ȷ");
			loginInfo.setMess("�û��������벻��ȷ");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		//�û�������session
		HttpSession session=request.getSession();
		session.setAttribute("userName",strName);
		response.sendRedirect("index.jsp");
	}

}
