package service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import utils.DaoFactory;
import utils.WebUtils;
import dao.BookDao;
import dao.CategoryDao;
import dao.OrderDao;
import dao.UserDao;
import domain.Book;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Order;
import domain.OrderItem;
import domain.Page;
import domain.User;

public class BusinessServiceImpl implements BusinessService {
	
	private CategoryDao categoryDao = DaoFactory.getInstance().createDao("dao.impl.CategoryDaoImpl", CategoryDao.class);
	private BookDao bookDao = DaoFactory.getInstance().createDao("dao.impl.BookDaoImpl", BookDao.class);
	private UserDao userDao = DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl", UserDao.class);
	private OrderDao orderDao = DaoFactory.getInstance().createDao("dao.impl.OrderDaoImpl", OrderDao.class);
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#addCategory(domain.Category)
	 */
	public void addCategory(Category category){
		categoryDao.add(category);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findCategory(java.lang.String)
	 */
	public Category findCategory(String id){
		return categoryDao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getAllCategory()
	 */
	public List<Category> getAllCategory(){
		return categoryDao.getAll();
	}
	
	//�����
	public void addBook(Book book){
		bookDao.add(book);
	}
	
	//�����
	public Book findBook(String id){
		return bookDao.find(id);
	}
	
	//��÷�ҳ����
	public Page getBookPageData(String pagenum){
		int totalrecord = bookDao.getTotalRecord();
		Page page = null;
		if(pagenum == null){
			page = new Page(1,totalrecord);
		}else{
			page = new Page(Integer.parseInt(pagenum), totalrecord);
		}
		List<Book> list = bookDao.getPageData(page.getStartindex(), page.getPagesize());
		page.setList(list);
		return page;
	}
	
	public Page getBookPageData(String pagenum, String category_id){
		int totalrecord = bookDao.getTotalRecord(category_id);
		Page page = null;
		if(pagenum == null){
			page = new Page(1,totalrecord);
		}else{
			page = new Page(Integer.parseInt(pagenum), totalrecord);
		}
		List<Book> list = bookDao.getPageData(page.getStartindex(), page.getPagesize(), category_id);
		page.setList(list);
		return page;
	}

	public void buyBook(Cart cart, Book book) {
		cart.add(book);
	}
	
	//ע���û�
	public void registerUser(User user) {
		userDao.add(user);
	}
	
	public User findUser(String id){
		return userDao.find(id);
	}

	public User userLogin(String username, String password){
		return userDao.find(username, password);
	}
	
	//���ɶ���
	public void createOrder(Cart cart, User user){
		if(cart == null){
			throw new RuntimeException("�Բ�������û�й����κ���Ʒ");
		}
		Order order = new Order();
		order.setId(WebUtils.makeID());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		for(Map.Entry<String, CartItem> me : cart.getMap().entrySet()){
			//�õ�һ�������������һ��������
			CartItem citem = me.getValue();
			OrderItem oitem = new OrderItem();
			oitem.setBook(citem.getBook());
			oitem.setPrice(citem.getPrice());
			oitem.setId(WebUtils.makeID());
			oitem.setQuantity(citem.getQuantity());
			order.getOrderitems().add(oitem);
		}	
		orderDao.add(order);
	}

	//��̨��ȡ���ж�����Ϣ
	public List<Order> listOrder(String state) {
		return orderDao.getAll(Boolean.parseBoolean(state));	
	}

	//�г�������ϸ
	public Order findOrder(String orderid) {		
		return orderDao.find(orderid);
	}

	//�Ѷ�����Ϊ����״̬
	public void confirmOrder(String orderid) {
		Order order = orderDao.find(orderid);
		order.setState(true);
		orderDao.update(order);
	}

	//���ĳ���û��Ķ�����Ϣ
	public List<Order> listOrder(String state, String userid) {
		return orderDao.getAll(Boolean.parseBoolean(state), userid);
	}

	//��ȡĳ���û��Ķ�����Ϣ
	public List<Order> clientListOrder(String userid) {	
		return orderDao.getAllOrder(userid);
	}
}
