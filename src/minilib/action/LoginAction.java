package minilib.action;
import minilib.dao.ManageReadersDAO;
import minilib.dao.ManageTitlesDAO;
import minilib.vo.Reader;
import minilib.vo.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport 
{
	private User user;
	private Reader reader;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	
	public String manager() throws Exception
	{
		/**/
			return "managerenter";
	}
	public String testManager() throws Exception
	{
		if(user.getUsername().equals("mia") && user.getUserpass().equals("0715"))
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			return "success";
		}
		else
			return "failure";
		
	}
	public String reader() throws Exception
	{
		return "existedreaderenter";
	}
	public String testreader() throws Exception
	{
		String restType = INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("readerid", reader.getReaderid());
		  session.setAttribute("readername", reader.getReadername());
		boolean flag = false;
		//boolean flag1=false;
		ManageReadersDAO mr = new ManageReadersDAO();
		List<Reader> allreaders = mr.getAllReader();
		for(int i=0; i<allreaders.size(); i++)
		{
			if(reader.getReaderid().equals(allreaders.get(i).getReaderid()) && reader.getReadername().equals(allreaders.get(i).getReadername()))
			{
				flag=true;
				restType = "readerexist";
			}
		}
		if(flag == false)
			restType = "failure";
		return restType;
		
	}
	public String newreader() throws Exception
	{
		return "newreader";
	}
	public String successregister() throws Exception
	{
		return "successregister";
	}
	public String insertreader() throws Exception
	{
		String restadd = INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("readerid", reader.getReaderid());
		  session.setAttribute("readername", reader.getReadername());
		ManageReadersDAO mr = new ManageReadersDAO();
		mr.addReader(reader);
		restadd="registedreader";
		return restadd;

	}

}
