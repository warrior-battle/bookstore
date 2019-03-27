package dao;

import java.util.List;

import domain.Category;
//种类接口
public interface CategoryDao {
	//添加种类
	public abstract void add(Category category);
	//查询种类ID
	public abstract Category find(String id);
	//获取所有种类
	public abstract List<Category> getAll();

}