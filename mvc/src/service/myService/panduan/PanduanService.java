package service.myService.panduan;

import java.util.Map;

import service.vo.MessageVo;

public interface PanduanService {
	Map<String,MessageVo> getVo(String user);
}
