package dao;

import java.util.List;

import domain.Order;
//�����ӿ�
public interface OrderDao {

	void add(Order order);

	Order find(String id);
	//����״̬
	List<Order> getAll(boolean state);

	void update(Order order);
	//ĳһ��������״̬
	List<Order> getAll(boolean state, String userid);
	//������ѯ
	List<Order> getAllOrder(String userid);

}