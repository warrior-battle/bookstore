package dao;

import java.util.List;

import domain.Category;
//����ӿ�
public interface CategoryDao {
	//�������
	public abstract void add(Category category);
	//��ѯ����ID
	public abstract Category find(String id);
	//��ȡ��������
	public abstract List<Category> getAll();

}