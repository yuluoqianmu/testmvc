package struts.form;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class FullForm{
	public FullForm(){}
	
	public static ActionForm full(String formPath,HttpServletRequest request){
		ActionForm form = null;
		
		try{
			Class clazz = Class.forName(formPath);
			form = (ActionForm)clazz.newInstance();
			
			Field[] fields = clazz.getDeclaredFields();
			
			for(Field f :fields){
				
				f.setAccessible(true);
				f.set(form, request.getParameter(f.getName()));
				f.setAccessible(false);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("—œ÷ÿ  form ◊∞‘ÿ ß∞‹£°£°£°£°£°");
		}
		
		return form;
	}
	
}
