package business;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import service.myService.panduan.PanduanService;
import service.myService.panduan.PanduanServiceImpl;
import service.vo.MessageVo;
import struts.action.Action;
import struts.form.ActionForm;

public class PandAction implements Action {

	public String execute(HttpServletRequest request,ActionForm form,Map<String,String> actionForward) {
		
		String url = "";
		
		PanduanService panduan = new PanduanServiceImpl();
		Map<String,MessageVo> map =  panduan.getVo(request.getParameter("text"));
		
		Set<String> set = map.keySet();
		
		for(Iterator<String> it =  set.iterator(); it.hasNext();){
			url = it.next();
			request.setAttribute("mess", map.get(url));
		}
		return url;
	}

}
