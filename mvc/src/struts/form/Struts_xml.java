package struts.form;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class Struts_xml {
	public Struts_xml(){}
	
	public static Map<String,XmlBean>  jiexiXML(String xmlPath) throws Exception{
		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(new File(xmlPath));
		
		Element root = document.getRootElement();
		
		Map<String,XmlBean> rmap = new HashMap<String,XmlBean>();
		
		Element actionRoot = root.getChild("action-mapping");
		
		List<Element> action = actionRoot.getChildren();
		for(Element ele:action){
			
			XmlBean bean = new XmlBean();
			
			String name = ele.getAttributeValue("name");
			bean.setBeanName(name);
			
			Element actionForm = root.getChild("formbeans");
			List<Element> form = actionForm.getChildren();
			for(Element eles :form ){
				if(name.equals(eles.getAttributeValue("name"))){
					String formClass = eles.getAttributeValue("class");
					bean.setFormClass(formClass);
					break;
				}
			}
			
			String path = ele.getAttributeValue("path");
			bean.setPath(path);
			
			String type = ele.getAttributeValue("type");
			bean.setActionClass(type);
			
			
			List<Element> forward = ele.getChildren();
			
			Map<String,String> map = new HashMap<String, String>();
			for(Element e :forward){
				
				String fname = e.getAttributeValue("name");
				String fvalue = e.getAttributeValue("value");
				map.put(fname, fvalue);
				//System.out.println("forward:name="+fname+"||value="+fvalue);
			}
			bean.setActionForward(map);
			rmap.put(path, bean);
		}
		
		return rmap;
	}
}
