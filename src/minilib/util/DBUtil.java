package minilib.util;

import com.mysql.jdbc.Connection;
import java.sql.*;
public class DBUtil {
	//数据库的用户信息
	private static String rootname="root";
	private static String rootpass="19970715";
	
	//mysql驱动程序
	private static String driver="com.mysql.jdbc.Driver";
	
	//数据库的位置（注意远程时连接）
	private static String url="jdbc:mysql://localhost:3306/book";
	
	//创建于数据库的连接
	public static Connection getConnection() throws 
	InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Class.forName(driver).newInstance();
		return (Connection) DriverManager.getConnection(url, rootname, rootpass);
	}
	

}
