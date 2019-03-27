package utils;
//单例模式工厂
public class DaoFactory {
	
	private static final DaoFactory factory = new DaoFactory();
	private DaoFactory(){}
	
	public static DaoFactory getInstance(){
		return factory;
	}
	
	//反射加载得到类型对象
	public <T> T createDao(String className, Class<T> clazz){
		try{
			T t = (T) Class.forName(className).newInstance();
			return t;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
