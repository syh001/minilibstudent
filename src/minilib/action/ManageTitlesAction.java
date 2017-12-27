package minilib.action;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import minilib.dao.ManageTitlesDAO;
import minilib.vo.Title;

public class ManageTitlesAction extends ActionSupport {
	private Title book;
	public Title getBook() {
		return book;
	}
	public void setBook(Title book) {
		this.book = book;
	}
	String i;
	public String getI() {
		return i;
	}
	public void setI(String i) {
		this.i = i;
	}
	public String addTitle() throws Exception{
		String restadd = INPUT;
		ManageTitlesDAO mtadd = new ManageTitlesDAO();
		mtadd.saveTitle(book);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", "添加成功请继续");
		System.out.println("添加图书");
		restadd="addbook";
		return restadd;
	}
	
	public String deleteTitle() throws Exception{
		String restadd = INPUT;
		ManageTitlesDAO mtadd = new ManageTitlesDAO();
		mtadd.deleteTitle(book);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", "删除成功请继续");
		System.out.println("删除图书");
		restadd="bookdeleting";
		return restadd;
	}
	public String findBookType () throws Exception{
		String restType = INPUT;
		ManageTitlesDAO mttype = new ManageTitlesDAO();
		List allTypelist = mttype.findBookType();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("alltypelist", allTypelist);
		restType="booktype";
		return restType;
	}
	public String deleteBookType() throws Exception{
		String restType = INPUT;
		ManageTitlesDAO mttype = new ManageTitlesDAO();
		List allTypelist = mttype.findBookType();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("alltypelist", allTypelist);
		restType="deletebook";
		return restType;
	}
	public String findTitle() throws Exception{
		System.out.println("=========find========");
		String restType = INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		ManageTitlesDAO mtfind = new ManageTitlesDAO();
			//直接查找所有书
			List allTitleslist = mtfind.findAll();
			request.setAttribute("alltitleslist", allTitleslist);
			restType = "querybook";
		return restType;
	}
	//模糊查询
	public String findSpecificTitle(){
		String restType =INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		ManageTitlesDAO mt = new ManageTitlesDAO();
		List<Title> findSpecificTitle = mt.findSpecificBook(book.getTitle());
		session.setAttribute("findSpecificTitle", findSpecificTitle);
		System.out.println(findSpecificTitle.size()+book.getTitle());
		restType = "findSpecificTitle";
		return restType;
	}
	//分页
	public String findEach() throws Exception{
		ManageTitlesDAO mt=new ManageTitlesDAO();
		List eachTitlesList=mt.findEach(i);
		//System.out.println(i);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("alltitleslist", eachTitlesList);
		System.out.println("=========findeach=======");
		return "findeachbook";
	}
	
}
