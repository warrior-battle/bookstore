package utils;

import java.util.UUID;

public class WebUtils {
	//ȡ���� 4��α������ɵģ�UUID �ľ�̬����
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
}
