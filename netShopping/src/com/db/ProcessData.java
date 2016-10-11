package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class ProcessData {
	 String url="jdbc:sqlserver://1214-18:1433;" +
				"databaseName=shopping;";
		//操作系统验证，此时要去掉integratedSecurity=true;  连接oracle就用oracle的密码
	 String user="sa";
	 String password="sasasa";
	//添加
	public boolean insert(String sql){
		boolean isSuccess=false;
		try{
			 //加载数据库驱动
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    //获取一个链接
		    Connection conn=DriverManager.getConnection(url, user, password);
		    //
		    Statement stm=conn.createStatement();
		    stm.executeUpdate(sql);
		    isSuccess=true;
		    conn.close();
		}catch(Exception e){
			System.err.println(e);
		}
		
		
		return isSuccess;
	}
	//查询
	public Vector getData(String sql){		  
		    Vector rows=new Vector();//存所有记录（行Vector对象的集合）
		    try{
			    //加载数据库驱动
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    //获取一个链接
			    Connection conn=DriverManager.getConnection(url, user, password);
			    //
			    Statement stm=conn.createStatement();
			    //
			    ResultSet rst=stm.executeQuery(sql);
			    
			    Vector rowData=null;
			    while(rst.next()){
			    	//一行记录存于一个Vector对象
			    	rowData=new Vector();
			    	int colCount=rst.getMetaData().getColumnCount();
			    	for(int i=0; i<colCount;i++){
				    	rowData.add(rst.getString(i+1));	
			    	}
			    	
			    	rows.add(rowData);
			    }
			    
			    
			   conn.close();
		    }catch(Exception e){
		    	System.out.print(e);
		    }
		    
		    return rows;
	}
}
