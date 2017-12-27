package minilib.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import minilib.dao.ManageBookinfoDAO;
import minilib.dao.ManageTitlesDAO;
import minilib.vo.CodePress;
import minilib.vo.CodeBookType;

public class ManageBookinfoAction extends ActionSupport {
	private CodePress codepress;
	public CodePress getCodepress() {
		return codepress;
	}
	public void setCodepress(CodePress codepress) {
		this.codepress = codepress;
	}
	private CodeBookType type;
	public CodeBookType getType() {
		return type;
	}
	public void setType(CodeBookType type) {
		this.type = type;
	}
	
	public String addPress() throws Exception{
		String restadd = INPUT;
		ManageBookinfoDAO mtadd = new ManageBookinfoDAO();
		
		mtadd.savePress(codepress);

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("codepress", codepress);
		//request.setAttribute("message", "添加成功请继续");
		System.out.println("添加出版社");
		restadd="addpressid";
		return restadd;
	}
	public String findAllPress() throws Exception{
		//System.out.println("=========find========");
		String restType = INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		ManageBookinfoDAO mtfind = new ManageBookinfoDAO();
		
			//直接查找所有书
			List allpress = mtfind.getALLPress();
			request.setAttribute("allpress", allpress);
			restType = "showallpress";
		return restType;
	}
	public String addType() throws Exception
	{
		ManageBookinfoDAO mt=new ManageBookinfoDAO();
	
		mt.addType(type);
		HttpServletRequest request= ServletActionContext.getRequest();
		
		request.setAttribute("type",type);
		return "addtype";
	}
	////查询图书分类
	public String findAllType() throws Exception{//�������ͺŲ�������
		String rest ="";
		ManageBookinfoDAO mt=new ManageBookinfoDAO();
		ArrayList<CodeBookType> allTypeList = mt.findAllType(type.getCodeid());
		HttpServletRequest request= ServletActionContext.getRequest();
		request.setAttribute("alltypelist", allTypeList);
		rest = "findAllType";
		return rest;
	}
	

}
