package service.myService.panduan;

import java.util.HashMap;
import java.util.Map;

import service.vo.MessageVo;

public class PanduanServiceImpl implements PanduanService {

	public Map<String,MessageVo> getVo(String user) {
		
		Map<String,MessageVo> map = new HashMap<String,MessageVo>();
		boolean b = this.isUser(user);
		MessageVo vo = new MessageVo();
		if(b){
			vo.setName("zhangsan");
			vo.setAge("18");
			vo.setSex("ÄÐ");
			vo.setDesc("ITÄÐ");
			map.put("/view/MyJsp.jsp",vo);
		}else{
			vo.setName("zhangsanxxx");
			vo.setAge("18xxx");
			vo.setSex("ÄÐxxx");
			vo.setDesc("ITÄÐxxx");
			map.put("/view/error.jsp",vo);
		}
		return map;
	}

	private boolean isUser(String user){
		boolean b = false;
		if(user.equals("sml")){
			b = true;
		}
		return b;
	}
}
