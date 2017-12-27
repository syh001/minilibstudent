package minilib.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import minilib.util.DBUtil;
import minilib.vo.CodeBookType;
import minilib.vo.CodePress;

public class ManageBookinfoDAO {
	public void savePress(CodePress codepress)
			throws 
			InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
				Connection conn = DBUtil.getConnection();
				Statement stmt=conn.createStatement();
				System.out.println(codepress.getCodeid());
				System.out.println(codepress.getCodename());
				String sql="insert into code_press(codeid,codename)"+"values('"+codepress.getCodeid()+"',"+"'"+codepress.getCodename()+"')";
				stmt.execute(sql);
				stmt.close();
				conn.close();
			}
	public List getALLPress()
	{
		List list = new ArrayList();
		try{
			Connection conn = DBUtil.getConnection();
			if(conn == null){
				System.out.println("database connection failure");
			}
			String sql = "select codeid, codename from code_press";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				CodePress cp = new CodePress();
				cp.setCodeid(rs.getString(1));
				cp.setCodename(rs.getString(2));
				list.add(cp);
			}
			rs.close();
			psmt.close();
			conn.close();
		}catch(Exception e){
			System.out.println("查询所有出版社信息有异常");
			System.out.println(e);
		}
		return list;
	}
	
	public void addType(CodeBookType type){
		Connection conn = null;
		try{
		conn=DBUtil.getConnection(); 
		String	sql="insert into code_booktype(codeid,codename) values('"+type.getCodeid()+"','"+type.getCodename()+"')";
		
		Statement stm=(Statement) conn.createStatement();
		stm.executeUpdate(sql);
		stm.close();
		conn.close();
		}catch(Exception e){
			System.out.println("增加图书类型失败！");
			System.out.println(e);
		}
	}
	
	public ArrayList<CodeBookType> findAllType(String codeId){
		ArrayList<CodeBookType> list = new ArrayList<CodeBookType>();
		Connection conn = null;
		try{
		conn=DBUtil.getConnection(); 
		String	sql="select * from code_booktype where codeid like '%"+codeId+"%'";
		PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()){
			CodeBookType type = new CodeBookType();
			type.setCodeid(rs.getString(1));
			type.setCodename(rs.getString(2));
			list.add(type);
			}
		}catch(Exception e){
			System.out.println("查询所有图书类型失败！");
			System.out.println(e);	
		}
		return list;
	}

}
/*public void deleteTitle(Title book)
throws 
InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	Connection conn = DBUtil.getConnection();
	Statement stmt=conn.createStatement();
	String sql = "delete from t_book where typeid='"+book.getTypeid()+"' AND title='"+book.getTitle()+"' " ;
	stmt.execute(sql);
	stmt.close();
	conn.close();
}*/
