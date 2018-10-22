package cn.sdut.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";

	//创建属性的对象
	//private static Properties props = new Properties();

	private DbUtils() {
		
	}

	/**
	* 加载驱动
	*/
	static {
	   try {
		   //加载属性文件
	       //props.load(new FileReader("src/cn/sdut/dao/db.properties"));
	       //通过键去获取到所对应的值
	       //Class.forName(props.getProperty("driver"));
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   } catch (ClassNotFoundException e) {
	       e.printStackTrace();
	   } 
	}

	/**
	* 建立连接
	* @return
	*/
	public static Connection getConnection() {
		Connection conn = null;
	    try {
	        //conn = DriverManager.getConnection(props.getProperty("url"),
	        		//props.getProperty("user"), props.getProperty("password"));
	    	 conn = DriverManager.getConnection(URL,USER,PASSWORD);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}

	/**
	* 关闭连接
	* @param rs
	* @param st
	* @param conn
	*/
	public static void closeAll(ResultSet rs, Statement st, Connection conn) {
		try {
			if( rs != null ) {
				rs.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    try {
	        if( st != null ) {
	            st.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    try {
	        if( conn != null ) {
	           conn.close();
	        }
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	}
}
