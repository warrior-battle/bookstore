package bookstore;

import static org.junit.Assert.*;

import org.junit.Test;

public class Uni {

	@Test
	public void test() {
		Class a=null;
		try {
			a=Class.forName("bookstore.One");
			System.out.println(a.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			One a1=(One) a.newInstance();
			System.out.println(a1.a);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
