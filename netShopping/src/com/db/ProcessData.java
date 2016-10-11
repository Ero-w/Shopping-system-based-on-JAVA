package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class ProcessData {
	 String url="jdbc:sqlserver://1214-18:1433;" +
				"databaseName=shopping;";
		//����ϵͳ��֤����ʱҪȥ��integratedSecurity=true;  ����oracle����oracle������
	 String user="sa";
	 String password="sasasa";
	//���
	public boolean insert(String sql){
		boolean isSuccess=false;
		try{
			 //�������ݿ�����
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    //��ȡһ������
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
	//��ѯ
	public Vector getData(String sql){		  
		    Vector rows=new Vector();//�����м�¼����Vector����ļ��ϣ�
		    try{
			    //�������ݿ�����
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    //��ȡһ������
			    Connection conn=DriverManager.getConnection(url, user, password);
			    //
			    Statement stm=conn.createStatement();
			    //
			    ResultSet rst=stm.executeQuery(sql);
			    
			    Vector rowData=null;
			    while(rst.next()){
			    	//һ�м�¼����һ��Vector����
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
