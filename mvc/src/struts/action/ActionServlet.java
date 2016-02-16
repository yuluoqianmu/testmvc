package struts.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts.form.ActionForm;
import struts.form.FullForm;
import struts.form.XmlBean;

public class ActionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	//获得请求	
	String path = this.getPath(request.getServletPath());
	
	Map<String,XmlBean> map = (Map<String,XmlBean>)this.getServletContext().getAttribute("struts");
	
	XmlBean xml = map.get(path);
	String formClass = xml.getFormClass();
	ActionForm form = FullForm.full(formClass, request);
	
	String actionType = xml.getActionClass();
	
	String url = "";
	Action action = null;
	try{
		Class clazz = Class.forName(actionType);
		action = (Action)clazz.newInstance();
		url = action.execute(request, form, xml.getActionForward());
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}catch(Exception e){
		System.out.println("严重：控制器异常！");
	}
	
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String getPath(String servletPath){
		return servletPath.split("\\.")[0];
	}
	
}
