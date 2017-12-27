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
import com.opensymphony.xwork2.ActionSupport;

public class ManageReservationDAO extends ActionSupport {
	
	public List getAll(){
		List list = new ArrayList();
		try{
			Connection conn = DBUtil.getConnection();
			if(conn == null){
				System.out.println("database connection failure");
			}
			String sql = "select * from t_reserve order by readerid";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//获得结果集
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Reserve reservelist = new Reserve();
				reservelist.setReaderid(rs.getString(1));
				reservelist.setReadername(rs.getString(2));
				reservelist.setTypeid(rs.getString(3));
				reservelist.setTitle(rs.getString(4));
				reservelist.setPressid(rs.getString(5));
			
				list.add(reservelist);
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("======找到所有预定图书的信息有异常=====");
			System.out.println(e);
		}return list;
	}
	
	//在t_reserve表中 查询记录  只找特定人的记录
	public List<Reserve> findAll(String readerid){
		List<Reserve> list = new ArrayList();
		try{
			Connection conn = DBUtil.getConnection();
			if(conn == null){
				System.out.println("database connection failure");
			}
			String sql = "select * from t_reserve where readerid='"+readerid+"'";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//获得结果集
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Reserve record = new Reserve();
				record.setReaderid(rs.getString(1));
				record.setReadername(rs.getString(2));
				record.setTypeid(rs.getString(3));
				record.setTitle(rs.getString(4));
				record.setPressid(rs.getString(5));
				list.add(record);
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("有异常");
		}return list;
	}
	
	public void insertToReserve(String readerid, String readername, String typeid, String title, String pressid)
	{
		Connection conn = null;
		try{
		conn=DBUtil.getConnection(); 
		String	sql="insert into t_reserve(readerid,readername,typeid,title,pressid) values('"+readerid+"','"+readername+"','"+typeid+"','"+title+"','"+pressid+"')";
		
		Statement stm=(Statement) conn.createStatement();
		stm.executeUpdate(sql);
		stm.close();
		conn.close();
		}catch(Exception e){
			System.out.println("插入到t_reserve表失败！");
			System.out.println(e);
		}
	}
	
	public void deletefromReserve(String readerid, String title)
	{
		Connection conn = null;
		try{
		conn=DBUtil.getConnection(); 
		//delete from t_predict where bookid="+bookid+"
		String	sql="delete from t_reserve where title='"+title+"' and readerid='"+readerid+"'";
		
		Statement stm=(Statement) conn.createStatement();
		stm.executeUpdate(sql);
		stm.close();
		conn.close();
		}catch(Exception e){
			System.out.println("删除t_reserve表失败！");
			System.out.println(e);
		}
	}
	
	
	public List findId()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			
			List list =new ArrayList();
			Connection conn=DBUtil.getConnection();
			PreparedStatement pre=conn.prepareStatement("select readerid from t_reserve order by readerid");
			//System.out.println("select codeid, codename from code_booktype order by codeid");
			ResultSet rs = pre.executeQuery();
			/*Statement stmt=conn.createStatement();
			String strsql = "select codeid, codename from code_booktype order by codeid";*/
			//获得查询图书列表结果
			//ResultSet rs = stmt.executeQuery(strsql);
			while(rs.next()){
				Reserve  r = new Reserve();
				r.setReaderid(rs.getString(1));
				list.add(r);
			}
			rs.close();
			pre.close();
			conn.close();
			return list;
		}
	
	
	
	public void savePerson(Reserve reserve)
			throws 
			InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
				Connection conn = DBUtil.getConnection();
				Statement stmt=conn.createStatement();
				String sql = "insert into t_borrow (readerid, readername, typeid, title)" + "values('" +reserve.getReaderid()+"', '"+reserve.getReadername()+"', '"+reserve.getTypeid()+"', '"+reserve.getTitle()+"')";
				stmt.execute(sql);
				stmt.close();
				conn.close();
			}
	
	
	public void insertToBorrow(String readerid, String readername, String typeid, String title, String pressid)
	{
		Connection conn = null;
		try{
		conn=DBUtil.getConnection(); 
		String	sql="insert into t_reserve(readerid,readername,typeid,title,pressid) values('"+readerid+"','"+readername+"','"+typeid+"','"+title+"','"+pressid+"')";
		
		Statement stm=(Statement) conn.createStatement();
		stm.executeUpdate(sql);
		stm.close();
		conn.close();
		}catch(Exception e){
			System.out.println("插入到t_borrow表失败！");
			System.out.println(e);
		}
	}

}
