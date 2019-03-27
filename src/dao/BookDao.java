package dao;

import java.util.List;

import domain.Book;
//�����Եĳ���ҵ���߼�
public interface BookDao {
	//�����
	void add(Book book);
	//������
	Book find(String id);
	//������ݱ�ҳ������
	public List<Book> getPageData(int startindex, int pagesize);
	//�ܼ�¼��
	public int getTotalRecord();
	//��ȡ���ݿ����ݱ�ҪҪ��ʾ������
	public List<Book> getPageData(int startindex, int pagesize, String category_id);
	//��ȡ����ĳһ����ļ�¼
	public int getTotalRecord(String category_id);

}