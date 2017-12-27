package minilib.action;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import minilib.dao.ManageReservationDAO;
import minilib.dao.ManageTitlesDAO;
import minilib.vo.Reserve;
import minilib.vo.Title;

public class ManageReservationAction extends ActionSupport {
	private Title title;

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	private Reserve reserve;
	
	public Reserve getReserve() {
		return reserve;
	}

	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	
	
	
	
	public String addReserve() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		String restadd = INPUT;
		ManageReservationDAO mtadd = new ManageReservationDAO();
		mtadd.savePerson(reserve);
	List<Reserve> vertifylist = mtadd.findAll(reserve.getReaderid());
	
	//session.setAttribute("vertifylist", vertifylist);
		//reserve中只有readerid，还要有一步，根据readerid获取全部信息，再调用saveperson
		request.setAttribute("message", "添加此人预定成功请继续");
		System.out.println("确认读者的预定");
		restadd="vertifyborrow";
		return restadd;
	}
	
	
	
	public String findTitle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		ManageTitlesDAO mt = new ManageTitlesDAO();
		List<Title> reservationlist = mt.findSpecificBook(title.getTitle());
		session.setAttribute("reservationlist", reservationlist);
		return "findreservation";
	}
	public String addToReserveList()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		String readerid=null;
		String readername=null;
		String Typeid=null;
		String Pressid=null;
		String booktitle = title.getTitle();
		//session.setAttribute("booktitle", booktitle);
		ManageTitlesDAO mt = new ManageTitlesDAO();
		List<Reserve> myreserverecord = mt.findOneRecord(booktitle);
		for(int i=0; i<myreserverecord.size();i++)
		{
			 readerid = (String)session.getAttribute("readerid");
		 readername = (String)session.getAttribute("readername");
		 Typeid=myreserverecord.get(i).getTypeid();
		 Pressid=myreserverecord.get(i).getPressid();
		}
		ManageReservationDAO mm = new ManageReservationDAO();
		mm.insertToReserve(readerid, readername, Typeid, booktitle, Pressid);
		List<Reserve> allrecords = mm.findAll(readerid);
		session.setAttribute("allrecords", allrecords);//allrecords中放的是此次登陆的人 在t_reserve表中的信息
		return "myreserverecord";
		
	}
	
	public String cancelReservation()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		ManageReservationDAO mr = new ManageReservationDAO();
		//List<Reserve> list = (List<Reserve>)session.getAttribute("allrecords");
		String delete = title.getTitle();
		String readerid = (String)session.getAttribute("readerid");
		mr.deletefromReserve(readerid, delete);
		List<Reserve> alldeletedrecords = mr.findAll(readerid);
		session.setAttribute("alldeletedrecords", alldeletedrecords);
		return "cancalreservation";
	}
	
	
	public String findAllreserve() throws Exception{
		System.out.println("=========findAllreserve========");
		String restType = INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		ManageReservationDAO mtfind = new ManageReservationDAO();
			//直接查找所有预订信息
			List<Reserve> allreservelist = mtfind.getAll();
			request.setAttribute("allreservelist", allreservelist);
			restType = "queryreserve";
		return restType;
	}
	
	public String findBorrower() throws Exception{
		System.out.println("=========findBorrower========");
		String restType = INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		ManageReservationDAO mtfind = new ManageReservationDAO();
			//直接查找t_reserve表中的所有hao
			List allBorrowid = mtfind.findId();
			request.setAttribute("allBorrowid", allBorrowid);
			restType = "queryyyy";
		return restType;
	}
	/*public String findId() throws Exception{
		System.out.println("=========findBorrower========");
		String restType = INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		ManageReservationDAO mtfind = new ManageReservationDAO();
			//直接查找t_reserve表中的所有人
			List allborrowid = mtfind.findId();
			request.setAttribute("allborrowid", allborrowid);
			restType = "borrowid";
		return restType;
		
	}*/
}
