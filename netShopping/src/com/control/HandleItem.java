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
 * Servlet implementation class HandleItem
 */
public class HandleItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleItem() {
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
		//接收数据pid
		String strPid=request.getParameter("pid");
		
		String sql="select * from product where id="+strPid;
		ProcessData data=new ProcessData();
		Vector rows=data.getData(sql);
		Vector row=(Vector)rows.get(0); 
		//创建request周期的product的bean
		Product product=new Product();
		request.setAttribute("product", product);
		product.setId(Integer.parseInt((String)row.get(0)));
		product.setName((String)row.get(1));
		product.setSort(Integer.parseInt((String)row.get(2)));
		product.setPrice(Float.parseFloat((String)row.get(3)));
		product.setOnePrice(Float.parseFloat((String)row.get(4)));
		product.setImg((String)row.get(5));
		product.setSale(Integer.parseInt((String)row.get(7)));
		product.setFace((String)row.get(8));
		product.setBody((String)row.get(9));
		product.setLength(Float.parseFloat((String)row.get(10)));
		product.setQuantity(Integer.parseInt((String)row.get(11)));
		product.setSource((String)row.get(12));
		
		RequestDispatcher dipatcher=request.getRequestDispatcher("item.jsp");
		dipatcher.forward(request, response);
	}

}
