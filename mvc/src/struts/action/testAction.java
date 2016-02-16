package struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import struts.form.ActionForm;
import struts.form.testForm;

public class testAction implements Action{

	public String execute(HttpServletRequest request, ActionForm form,
			Map<String, String> actionForward) {
		
		testForm tform = (testForm)form;
		String url = "";
		
		if(tform.getName().equals("sml")){
			url = "chenggong";
		}else{
			url = "shibai";
		}
		
		return actionForward.get(url);
	}

}
