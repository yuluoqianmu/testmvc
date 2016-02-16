package Utils;

import java.io.File;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;



public class StrutsConfig {
	public StrutsConfig(){
		
	}
	
	public void jiexiXML() throws Exception{
		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(new File("WebRoot/WEB-INF/struts-config.xml"));
		
		Element root = document.getRootElement();
		
		Element actionForm = root.getChild("formbeans");
		List<Element> form = actionForm.getChildren();
		
		for(Element ele : form){
			String name = ele.getAttributeValue("name");
			String clas = ele.getAttributeValue("class");
			System.out.println("formbeans:name="+name+",class="+clas);
		}
		
		Element actionRoot = root.getChild("action-mapping");
		List<Element> action = actionRoot.getChildren();
		for(Element ele:action){
			String name = ele.getAttributeValue("name");
			String path = ele.getAttributeValue("path");
			String type = ele.getAttributeValue("type");
			List<Element> forward = ele.getChildren();
			for(Element e :forward){
				String fname = e.getAttributeValue("name");
				String fvalue = e.getAttributeValue("value");
				System.out.println("forward:name="+fname+"||value="+fvalue);
			}
			System.out.println("Action:name="+name+"||path="+path+"||type="+type);
		}
		
		
		
	}
	
	
	
	 public static void main(String args[]) {
		 StrutsConfig sc = new StrutsConfig();
		 try {
			sc.jiexiXML();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
