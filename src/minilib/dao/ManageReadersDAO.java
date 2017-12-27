package minilib.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import minilib.util.DBUtil;
import minilib.vo.*;

public class ManageReadersDAO {
	public List getAllReader(){
		List list = new ArrayList();
		try{
			Connection conn = DBUtil.getConnection();
			if(conn == null){
				System.out.println("database connection failure");
			}
			String sql = "select userid, name from t_user";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//获得所有读者的结果集
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Reader reader = new Reader();
				reader.setReaderid(rs.getString(1));
				reader.setReadername(rs.getString(2));
				list.add(reader);
				
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("有异常");
			System.out.println(e);
			
		}
		return list;
	}
	
	public void addReader(Reader reader)
			throws 
			InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
				Connection conn = DBUtil.getConnection();
				Statement stmt=conn.createStatement();
				String sql = "insert into t_user (userid, name)" + "values('" + reader.getReaderid()+"',"+"'"+reader.getReadername()+"'"+")";
				stmt.execute(sql);
				stmt.close();
				conn.close();
			}

}
