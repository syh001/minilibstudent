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

public class ManageTitlesDAO {
	private static int m=10;
	//仅完成一个查询返回所有图书
	public List findAll(){
		List list = new ArrayList();
		try{
			Connection conn = DBUtil.getConnection();
			if(conn == null){
				System.out.println("database connection failure");
			}
			String sql = "select isbn, title, authors, pressid from t_book";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//获得结果集
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Title title = new Title();
				title.setIsbn(rs.getString(1));
				title.setTitle(rs.getString(2));
				title.setAuthors(rs.getString(3));
				title.setPressid(rs.getString(4));
				list.add(title);
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("======有异常=====");
			System.out.println(e);
		}return list;
	}
	/*public List findSpecific(Title book)
	{
		List list = new ArrayList();
		try{
			Connection conn = DBUtil.getConnection();
			if(conn == null){
				System.out.println("database connection failure"); 
			}
			String sql = "select title from t_book where title like '%"+book.getTitle()+"%'";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//获得结果集
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Title title1 = new Title();
				title1.setIsbn(rs.getString(1));
				title1.setTitle(rs.getString(2));
				title1.setAuthors(rs.getString(3));
				title1.setPressid(rs.getString(4));
				list.add(title1);
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("模糊查询有异常");
		}return list;
		
	}*/
	
	public List findBookType()
		throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		List list =new ArrayList();
		Connection conn=DBUtil.getConnection();
		PreparedStatement pre=conn.prepareStatement("select codeid, codename from code_booktype order by codeid");
		//System.out.println("select codeid, codename from code_booktype order by codeid");
		ResultSet rs = pre.executeQuery();
		/*Statement stmt=conn.createStatement();
		String strsql = "select codeid, codename from code_booktype order by codeid";*/
		//获得查询图书列表结果
		//ResultSet rs = stmt.executeQuery(strsql);
		while(rs.next()){
			CodeBookType booktype = new CodeBookType();
			booktype.setCodeid(rs.getString(1));
			booktype.setCodename(rs.getString(2));
			list.add(booktype);
		}
		rs.close();
		pre.close();
		conn.close();
		return list;
	}
	
	
	public List<Title> findSpecificBook(String title){
		List<Title> list = new ArrayList<Title>();
		Connection conn = null;
		try{
		conn=DBUtil.getConnection(); 
		String	sql="select * from t_book where title like '%"+title+"%'";
		PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()){
			Title title1=new Title();
			title1.setTypeid(rs.getString(2));
			title1.setIsbn(rs.getString(3));
			title1.setTitle(rs.getString(5));
			title1.setAuthors(rs.getString(6));
			title1.setPressid(rs.getString(8));
			
			list.add(title1);
			
			}
		}catch(Exception e){
			System.out.println("模糊查询有异常");
			System.out.println(e);
		}
		return list;
	}
	public void saveTitle(Title book)
		throws 
		InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			Connection conn = DBUtil.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "insert into t_book (typeid, title)" + "values('" + book.getTypeid()+"',"+"'"+book.getTitle()+"'"+")";
			stmt.execute(sql);
			stmt.close();
			conn.close();
		}
	public void deleteTitle(Title book)
			throws 
			InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
				Connection conn = DBUtil.getConnection();
				Statement stmt=conn.createStatement();
				String sql = "delete from t_book where typeid='"+book.getTypeid()+"' AND title='"+book.getTitle()+"' " ;
				stmt.execute(sql);
				stmt.close();
				conn.close();
			}
	
	
	public List findEach(String i){
		int num=Integer.parseInt(i);
		m+=num;
		List list=new ArrayList();
		try{
			Connection conn=DBUtil.getConnection();
			String sql="select * from t_book order by t_book.bookid limit "+m+" ,10";
			PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Title title=new Title();
				//title.setBookid(rs.getInt(1));
				title.setTypeid(rs.getString(2));
				title.setIsbn(rs.getString(3));
				title.setTitle(rs.getString(5));
				title.setAuthors(rs.getString(6));
				title.setPressid(rs.getString(8));
				list.add(title);
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		}
		catch(Exception e){
			System.out.println("分页失败！");
			System.out.println(e);
			
			
		}
		return list;
	}
	
	
	
	//根据书名找到一本图书的typeid title pressid
	public List findOneRecord(String booktitle){
		List list = new ArrayList();
		try{
			Connection conn = DBUtil.getConnection();
			if(conn == null){
				System.out.println("database connection failure");
			}
			String sql = "select typeid, pressid from t_book where title='"+booktitle+"'";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//获得结果集
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Reserve reservebookrecord = new Reserve();
				reservebookrecord.setTypeid(rs.getString(1));
				reservebookrecord.setPressid(rs.getString(2));
				list.add(reservebookrecord);
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("有异常");
		}return list;
	}
}
