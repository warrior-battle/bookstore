package dao;

import java.util.List;

import domain.Order;
//订单接口
public interface OrderDao {

	void add(Order order);

	Order find(String id);
	//订单状态
	List<Order> getAll(boolean state);

	void update(Order order);
	//某一订单具体状态
	List<Order> getAll(boolean state, String userid);
	//订单查询
	List<Order> getAllOrder(String userid);

}