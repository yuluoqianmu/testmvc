package struts.form;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ActionListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("信息：系统已经注销！");
	}

	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		String xmlPath = context.getInitParameter("struts-config");
		
		String tomcatPath = context.getRealPath("\\");
		
		try {
			Map<String,XmlBean> map = Struts_xml.jiexiXML(tomcatPath+xmlPath);
			context.setAttribute("struts", map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("信息：系统已经加载完成！");
	}
	
}
