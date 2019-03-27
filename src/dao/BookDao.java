package dao;

import java.util.List;

import domain.Book;
//书属性的抽象业务逻辑
public interface BookDao {
	//添加书
	void add(Book book);
	//查找书
	Book find(String id);
	//获得数据表页面数据
	public List<Book> getPageData(int startindex, int pagesize);
	//总记录数
	public int getTotalRecord();
	//获取数据库数据表要要显示的数据
	public List<Book> getPageData(int startindex, int pagesize, String category_id);
	//获取具体某一本书的记录
	public int getTotalRecord(String category_id);

}