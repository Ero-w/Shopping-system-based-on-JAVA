package com.control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.ProcessData;
import com.model.Product;

/**
 * Servlet implementation class HandleProduct
 */
public class HandleProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleProduct() {
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
		//连接数据库获取数据 
		String sql="select id, name, price, img, sale from product";
		
		ProcessData data = new ProcessData();
		Vector rows = data.getData(sql); //获取product数据
		request.setAttribute("product", rows);
		RequestDispatcher dispatcher=request.getRequestDispatcher("product.jsp");
		dispatcher.forward(request, response);
	}

}
