package dao;

import domain.User;
//�û��ӿ�
public interface UserDao {
	//����û�
	void add(User user);
	//��ѯ���û�
	User find(String id);
	//�û���������
	User find(String username, String password);

}