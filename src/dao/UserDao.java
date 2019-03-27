package dao;

import domain.User;
//用户接口
public interface UserDao {
	//添加用户
	void add(User user);
	//查询次用户
	User find(String id);
	//用户名和密码
	User find(String username, String password);

}