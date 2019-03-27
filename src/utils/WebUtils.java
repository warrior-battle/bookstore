package utils;

import java.util.UUID;

public class WebUtils {
	//取类型 4（伪随机生成的）UUID 的静态工厂
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
}
